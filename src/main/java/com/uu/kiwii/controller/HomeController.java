package com.uu.kiwii.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uu.kiwii.model.Subject;
import com.uu.kiwii.service.SubjectService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/home/{id}")
    public String home(@PathVariable String id, Model model) {
        Subject subject = subjectService.findById(id);
        model.addAttribute("subject", subject);

        List<String> links = subject.getLinks();
        List<String> titles = new ArrayList<>();
        String imageUrl = "https://img.myloview.com.br/posters/cartoon-kiwi-bird-vector-isolated-illustration-700-167863502.jpg";
        for (String link : links) {
            try {
                Document doc = Jsoup.connect(link).get();
                Element ogImage = doc.select("meta[property=og:image]").first();
                String imageUrl = ogImage.attr("content");

                String title = doc.title();
                titles.add(title);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("titles", titles);

        return "home";
    }
}
