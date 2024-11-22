package com.findhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quienesSomos")
public class QuienesSomosController {

    @GetMapping("listado")
    public String listado(Model model) {
        return "/quienesSomos/listado";
    }
}
