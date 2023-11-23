package com.uu.kiwii.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private RmService rmService;

    private String currentId;

    private String currentRm;

    @GetMapping("/home/{id}")
    public String home(@PathVariable String id, Model model, HttpSession session) {
        currentRm = (String) session.getAttribute("rm");
        currentId = id;

        if (currentRm == null) {
            return "redirect:/";
        }

        List<Scrap> scraps = scrap();

        model.addAttribute("scraps", scraps);
        model.addAttribute("subjectName", subjectService.findById(id).getName());
        model.addAttribute("currentUser", rmService.findById(currentRm).getName());

        return "home";
    }

    public List<Scrap> scrap() {
        List<Link> links = linkService.findAllById(currentId);
        List<Scrap> scraps = new ArrayList<>();

        for (Link link : links) {
            try {
                Document document = Jsoup.connect(link.getUrl()).get();

                String imgUrl = document.select("meta[property=og:image]").attr("content");
                String title = document.title();

                Scrap scrap = new Scrap(link.getId(), title, link.getUrl(), imgUrl, link.getRm().getName(),
                        link.getRm().getId(), linkService.isOwner(currentRm, currentId, link.getRm().getId()));

                scraps.add(scrap);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return scraps;
    }

    @PostMapping("/save")
    public String save(@RequestParam String url, RedirectAttributes attributes) {
        if (!linkService.verifyUrl(url)) {
            attributes.addFlashAttribute("message", "Link inválido ou inacessível.");
        } else if(linkService.findByUrl(currentId, url)){
            attributes.addFlashAttribute("message", "Este conteúdo já existe.");
        }else if(!subjectService.verifyRmInSubject(currentRm, currentId)){
            attributes.addFlashAttribute("message", "Você não faz parte desta turma.");
        }
        else {
            linkService.save(url, currentRm, currentId);
            attributes.addFlashAttribute("message", "Enviado! :)");
        }
        return "redirect:/home/" + currentId;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
        linkService.deleteById(id);
        return "redirect:/home/" + currentId;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("rm");
        return "redirect:/";
    }
}