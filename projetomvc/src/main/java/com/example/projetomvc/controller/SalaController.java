package com.example.projetomvc.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.projetomvc.model.Sala;
import com.example.projetomvc.service.SalaService;

@Controller
public class SalaController {
    SalaService service;

    public SalaController(SalaService service){
        this.service = service;
    }
    @GetMapping("/index")
    public String getIndex(Model model){
        var salas = service.findAll();
        model.addAttribute("salas",salas);
        return "index";
    }
    @GetMapping("/cadastrar")
    public String getCadastrarPage(Model model){//Model é usado para transportar dados entre o controlador e a visualização (view)
        Sala sala = new Sala();
        model.addAttribute("sala", sala); 
        return "cadastrarPage";
    }
    @PostMapping("/doSalvar")
    public String doSalvar(@ModelAttribute Sala sala){
        service.save(sala);
        return "redirect:/index";
    }
}
