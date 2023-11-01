package com.uu.kiwii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uu.kiwii.service.CourseService;

@Controller
public class IndexController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/findSubject")
    public void findSubject(@RequestParam("rm") String rm, @RequestParam("code") String code,
            RedirectAttributes attributes) {
        if (!courseService.findRmOnCourse(rm)) {
            attributes.addFlashAttribute("message", "Informações inválidas!");
        }
    }
}
