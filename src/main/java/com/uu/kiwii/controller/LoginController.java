package com.uu.kiwii.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uu.kiwii.model.Subject;
import com.uu.kiwii.service.RmService;
import com.uu.kiwii.service.SubjectService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("rm")
public class LoginController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private RmService rmService;

    @GetMapping("/")
    public String index(Model model) {
        List<Subject> subjects = subjectService.findAll();

        model.addAttribute("subjects", subjects);

        return "login";
    }

    @PostMapping("/findSubject")
    public String findSubject(@RequestParam(name = "id", required = false) String id, @RequestParam(name = "rm") String rm, RedirectAttributes attributes, HttpSession session) {
        
        if (rmService.verifyRm(rm)) {
            session.setAttribute("rm", rm);
            return "redirect:/home/" + id.toUpperCase();
        }
        attributes.addFlashAttribute("message", "Informações inválidas");
        return "redirect:/";
    }

}
