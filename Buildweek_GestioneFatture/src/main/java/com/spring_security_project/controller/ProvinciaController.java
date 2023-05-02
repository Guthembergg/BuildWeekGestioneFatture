package com.spring_security_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_project.auth.service.AuthService;
import com.spring_security_project.service.ProvinciaService;
@RestController
@RequestMapping("/provincia")
public class ProvinciaController {





    private ProvinciaService ProvinciaService;

    public ProvinciaController(ProvinciaService ProvinciaService) {
        this.ProvinciaService = ProvinciaService;
    }

}