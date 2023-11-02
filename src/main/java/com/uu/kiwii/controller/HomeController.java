package com.uu.kiwii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.uu.kiwii.service.SubjectService;

@Controller
public class HomeController {
    
    @Autowired
    private SubjectService subjectService;

    
}
