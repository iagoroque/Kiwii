package com.uu.kiwii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uu.kiwii.model.Link;
import com.uu.kiwii.repository.LinkRepository;

@Service
public class LinkService {
    
    @Autowired
    LinkRepository linkRepository;

    public List<Link> findAll(){
        return linkRepository.findAll();
    }
}
