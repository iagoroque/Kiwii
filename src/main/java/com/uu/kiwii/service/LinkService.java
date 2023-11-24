package com.uu.kiwii.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

    public List<Link> findAllById(String subject_id) {
        return linkRepository.findAllById(subject_id);
    }

    @Transactional
    public void save(String url, String rm, String subject) {
        linkRepository.save(url, rm, subject);
    }

    public boolean verifyUrl(String url) {
        try {
            new URL(url).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    
        try {
            Document document = Jsoup.connect(url).get();
        } catch (IOException | IllegalArgumentException e) {
            return false;
        }
        System.out.println(url);
        return true;
    }

    public boolean findByUrl(String rm, String url) {
        return linkRepository.findByUrl(rm, url);
    }

    public void deleteById(Long id) {
        linkRepository.deleteById(id);
    }

    public boolean isOwner(String currentRm, String subjectId, String linkRm) {
        if (currentRm.startsWith("1000") && subjectRepository.verifyRmInSubject(currentRm, subjectId)
                || currentRm.equals(linkRm)) {
            return true;
        }

        return false;
    }

}
