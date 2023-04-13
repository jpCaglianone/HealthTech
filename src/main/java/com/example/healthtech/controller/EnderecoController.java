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
    public String buscaCep(@RequestParam String cepPesquisa, Model model){

        model.addAttribute("endereco", enderecoService.buscaPorCep(cepPesquisa));

        return "PaginasRequisitante/cadastroRequisitante";
    }

}
