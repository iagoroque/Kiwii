package com.uu.kiwii.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

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

    public List<Link> findAllById(String subject_id) {
        return linkRepository.findAllById(subject_id);
    }

    @Transactional
    public void save(String url, String rm, String subject) {
        linkRepository.save(url, rm, subject);
    }

    public boolean verifyUrl(String urlString) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(urlString);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                return statusCode >= 200 && statusCode < 300;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean findByUrl(String rm, String url) {
        return linkRepository.findByUrl(rm, url);
    }

    public void deleteById(Long id) {
        linkRepository.deleteById(id);
    }

    public boolean isOwner(String currentRm, String subjectId, String linkRm) {
        if (currentRm.startsWith("1000") && subjectRepository.verifyRmInSubject(currentRm, subjectId) || currentRm.equals(linkRm)) {
            return true;
        }

        return false;
    }

}
