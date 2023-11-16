package com.uu.kiwii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uu.kiwii.repository.RmRepository;

@Service
public class RmService {
    
    @Autowired
    private RmRepository rmRepository;

    public boolean verifyRm(String rm){
        return rmRepository.verifyRm(rm);
    }
}
