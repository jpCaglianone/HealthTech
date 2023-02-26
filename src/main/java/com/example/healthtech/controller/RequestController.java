package com.example.healthtech.controller;


import com.example.healthtech.model.domain.Requisitante;
import com.example.healthtech.model.exception.*;
import com.example.healthtech.model.repository.RequisitanteRepository;
import com.example.healthtech.model.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {


    @GetMapping("/cadastroRequisitante")
    public String cadUserPage() {
        return "paginas/cadastroRequisitante";
    }

    @PostMapping(value="cadastroRequisitante/incluir")
    public String postCadRequester(@RequestParam String nome, @RequestParam String tipoRequisitante ,@RequestParam String orgao, Model model ) throws TipoInsumoException, NomeInvalidoException, ValorValidoException {

        Requisitante requisitante = new Requisitante(nome, Integer.parseInt(tipoRequisitante),orgao );


        RequisitanteRepository.inclusaoRequisitante(requisitante, model);

        model.addAttribute("mensagem",true);

        return "redirect:/";
    }

    @GetMapping("listaRequisitante")
    public String listRequesterPage(Model model) {

        model.addAttribute("listaRequisitantes", RequisitanteRepository.getListaRequisitantes());
        model.addAttribute("mensagem","mensagem");
        return "paginas/listaRequisitante";
    }

}
