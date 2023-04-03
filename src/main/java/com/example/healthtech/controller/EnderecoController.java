package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Endereco;
import com.example.healthtech.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;
    @PostMapping("/cep")
    public String buscaCep(@RequestParam String cep, Model model){

        Endereco endereco = new Endereco();
        endereco.setCep(cep);
    System.out.println(enderecoService.buscaPorCep(cep));
        model.addAttribute("endereco", enderecoService.buscaPorCep(cep));

        return "PaginasRequisitante/cadastroRequisitante";
    }

}
git