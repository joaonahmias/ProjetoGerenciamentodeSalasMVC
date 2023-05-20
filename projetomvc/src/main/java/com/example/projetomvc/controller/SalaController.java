package com.example.projetomvc.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.projetomvc.model.Sala;
import com.example.projetomvc.service.SalaService;
import com.fasterxml.jackson.core.sym.Name;

import jakarta.websocket.server.PathParam;

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
    public String doSalvar(@ModelAttribute Sala sala){//@ModelAttribute é aplicada ao parâmetro sala, indicando que o objeto Usuario será preenchido com os valores fornecidos na solicitação HTTP
        service.save(sala);
        return "redirect:/index";
    }

    @GetMapping("/editar/{id}")//Esse valor nas {} será mapeado para o parâmetro id do método getEditarPage
    public String getEditarPage(@PathVariable(name = "id") Integer id, Model model){//indica que o valor especificado que está na URL deve ser atribuido ao parametro id. 
        Optional<Sala> sala;//pode receber como retorno um valor não nulo ou nulo
        sala = service.findById(id);
        if(sala.isPresent()){//se não for nulo
            model.addAttribute("sala", sala.get());
        }
        else{
            return "redirect:/index";
        }
        return "editarPage";
    }
    @GetMapping("/deletar/{id}")
    public String doDeletar(@PathVariable(name = "id") Integer id){
        Optional<Sala> sala;
        sala = service.findById(id);
        if(sala.isPresent()){
            service.delete(sala.get());
        }
        
        return "redirect:/index";
        

    }

}
