package com.example.healthtech.controller;


import com.example.healthtech.model.domain.Requisitante;
import com.example.healthtech.model.exception.*;
import com.example.healthtech.model.service.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequisicaoController {

    @Autowired
    private RequisicaoService requisicaoService;

    @GetMapping("/cadastroRequisitante")
    public String cadUserPage() {
        return "PaginasRequisitante/cadastroRequisitante";
    }

    @PostMapping(value = "cadastroRequisitante/incluir")
    public String postCadRequester(@RequestParam String nome, @RequestParam String tipoRequisitante, @RequestParam String orgao, @RequestParam String enderecoRequisitante, @RequestParam String registroRequisitante, Model model) throws TipoInsumoException, NomeInvalidoException, ValorValidoException {

        Requisitante requisitante = new Requisitante(nome, Integer.parseInt(tipoRequisitante), orgao, enderecoRequisitante, Long.parseLong(registroRequisitante));
        requisicaoService.inclusaoRequisitante(requisitante);
        model.addAttribute("mensagem", true);

        return "redirect:/";
    }

    @GetMapping("listaRequisitante")
    public String listRequesterPage(Model model) {

        model.addAttribute("listaRequisitantes", requisicaoService.listarRequisitantes());
        model.addAttribute("mensagem", "mensagem");

        return "PaginasRequisitante/listaRequisitante";
    }

}
