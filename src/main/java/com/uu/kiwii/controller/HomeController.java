package com.uu.kiwii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uu.kiwii.model.Subject;
import com.uu.kiwii.service.SubjectService;

@Controller
public class HomeController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/home/{id}")
    public String home(@PathVariable String id, Model model) {
        Subject subject = subjectService.findById(id);

        model.addAttribute("subject", subject);
        return "home";
    }

}
