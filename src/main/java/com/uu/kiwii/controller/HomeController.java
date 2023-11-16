package com.uu.kiwii.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uu.kiwii.dto.Scrap;
import com.uu.kiwii.model.Link;
import com.uu.kiwii.service.LinkService;
import com.uu.kiwii.service.RmService;
import com.uu.kiwii.service.SubjectService;

@Controller
public class HomeController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private RmService rmService;

    private String currentId;

    @GetMapping("/home/{id}")
    public String home(@PathVariable String id, Model model) {
        List<Scrap> scraps = scrap();
        String subjectName = subjectService.findById(id).getName();
        currentId = id;

        model.addAttribute("scraps", scraps);
        model.addAttribute("subjectName", subjectName);

        return "home";
    }

    public List<Scrap> scrap() {

        List<Link> links = linkService.findAll();
        List<Scrap> scraps = new ArrayList<>();

        for (Link link : links) {
            try {
                Document document = Jsoup.connect(link.getUrl()).get();

                String imgUrl = document.select("meta[property=og:image]").attr("content");
                String title = document.title();

                Scrap scrap = new Scrap(title, link.getUrl(), imgUrl, link.getRm().getName(), link.getRm().getId());
                scraps.add(scrap);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return scraps;
    }

    @PostMapping("/save")
    public String save(@RequestParam String rm, @RequestParam String url, RedirectAttributes attributes) {
        if (!rmService.verifyRm(rm)) {
            attributes.addFlashAttribute("message", "Você não tem permissões :(");
        } else {
            linkService.save(url, rm, currentId);
            attributes.addFlashAttribute("message", "Enviado! :)");
        }
        return "redirect:/home/" + currentId;
    }

}