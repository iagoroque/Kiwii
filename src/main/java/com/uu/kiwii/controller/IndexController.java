package com.uu.kiwii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uu.kiwii.service.SubjectService;

@Controller
public class IndexController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/findSubject")
    public String findSubject(@RequestParam("rm") String rm, @RequestParam("id") String id,
            RedirectAttributes attributes) {
        if (!subjectService.verifyRm(rm.toUpperCase()) || !subjectService.verifySubject(id)) {
            attributes.addFlashAttribute("message", "Informações inválidas");
            return "redirect:/";
        } else {
            return "home";
        }
    }
}
