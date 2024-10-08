package com.ssn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.entity.SsnEntity;
import com.ssn.service.SsnService;

@RestController
@RequestMapping("/ssn")
public class SsnController {

    @Autowired
    private SsnService ssnService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSsn(@RequestBody SsnEntity ssnEntity) {
        boolean isSaved = ssnService.saveSsn(ssnEntity);
        if (isSaved) {
            return new ResponseEntity<>("SSN is Saved", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("SSN is not Saved", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{ssn}")
    public ResponseEntity<String> getStateBySsn(@PathVariable("ssn") Long ssn) {
        String stateName = ssnService.getSsnByState(ssn);
        if ("SSN not found".equals(stateName)) {
            return new ResponseEntity<>(stateName, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stateName, HttpStatus.OK);
    }
}
