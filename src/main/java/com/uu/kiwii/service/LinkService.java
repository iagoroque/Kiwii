package com.uu.kiwii.service;

import org.apache.commons.validator.routines.UrlValidator;
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

    public List<Link> findAll() {
        return linkRepository.findAll();
    }

    public List<Link> findAllById(String subject_id){
        return linkRepository.findAllById(subject_id);
    }

    @Transactional
    public void save(String url, String rm, String subject) {
        linkRepository.save(url, rm, subject);
    }

    public boolean verifyUrl(String urlString) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(urlString);
    }

    public void deleteById(Long id){
        linkRepository.deleteById(id);
    }

    public boolean isOwner(String currentRm, String linkRm) {

        if (currentRm != null && currentRm.startsWith("1000")) {
            return true;
        }

        return currentRm != null && linkRm != null && currentRm.equals(linkRm);
    }
    
}
