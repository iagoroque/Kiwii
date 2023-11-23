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
    public String home(@PathVariable String id, Model model) {
        currentRm = (String) model.asMap().get("rm");
        currentId = id;

<<<<<<< Updated upstream
=======
        if (currentRm == null) {
            return "redirect:/";
        }

>>>>>>> Stashed changes
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
                        link.getRm().getId(), linkService.isOwner(currentRm, link.getRm().getId()));

                scraps.add(scrap);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return scraps;
    }

    @PostMapping("/save")
    public String save(String rm, @RequestParam String url, RedirectAttributes attributes) {
<<<<<<< Updated upstream
        if (!rmService.verifyRm(currentRm)) {
            attributes.addFlashAttribute("message", "Você não tem permissões :(");
        } 
        else if(linkService.verifyUrl(url) == false){
            attributes.addFlashAttribute("message", "Link inválido!");
        }
        else {
=======
        if (!linkService.verifyUrl(url)) {
            attributes.addFlashAttribute("message", "Link inválido ou inacessível.");
        } else if(linkService.findByUrl(currentId, url)){
            attributes.addFlashAttribute("message", "Este conteúdo já existe.");
        } else {
>>>>>>> Stashed changes
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

}