package com.ssn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.entity.SsnEntity;
import com.ssn.repository.SsnEntityRepository;

@Service
public class SsnService {

    @Autowired
    private SsnEntityRepository entityRepository;
    
    public boolean saveSsn(SsnEntity ssnEntity) {
        SsnEntity saved = entityRepository.save(ssnEntity);
        return saved.getId() != null; 
    }

    public String getSsnByState(Long ssn) {
        String state = mapSsnToState(ssn);
        return state != null ? state : "SSN not found";
    }

    private String mapSsnToState(Long ssn) {
        String ssnString = String.valueOf(ssn);
        char firstDigit = ssnString.charAt(0);

        switch (firstDigit) {
            case '3':
                return "Texas";
            case '4':
                return "California";
            case '5':
                return "Florida";
            case '6':
                return "New Jersey";
            default:
                return null;
        }
    }
}
