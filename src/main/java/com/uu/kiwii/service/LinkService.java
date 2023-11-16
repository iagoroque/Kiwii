package com.uu.kiwii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uu.kiwii.model.Link;
import com.uu.kiwii.repository.LinkRepository;
import com.uu.kiwii.repository.SubjectRepository;

import jakarta.transaction.Transactional;

@Service
public class LinkService {
    
    @Autowired
    LinkRepository linkRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public List<Link> findAll(){
        return linkRepository.findAll();
    }

    @Transactional
    public void save(String url, String rm, String subject){
        linkRepository.save(url, rm, subject);
    }
}
