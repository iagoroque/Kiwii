package com.uu.kiwii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uu.kiwii.model.Subject;
import com.uu.kiwii.repository.SubjectRepository;

@Service
public class SubjectService {
    
    @Autowired
    private SubjectRepository subjectRepository;

    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

}
