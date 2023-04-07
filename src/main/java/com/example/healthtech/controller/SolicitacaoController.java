package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Produto;
import com.example.healthtech.model.service.ProdutoService;
import com.example.healthtech.model.service.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SolicitacaoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    RequisicaoService requisicaoService;

    @GetMapping("/cadastroSolicitacao")
    public String novaSolicitacao(Model model){


        model.addAttribute("listaProdutos", produtoService.listarTodosProdutos());
        model.addAttribute("listaRequisitantes", requisicaoService.listarTodosRequisitantes());

        return "PaginasSolicitacao/cadastroSolicitacao";
    }

        @PostMapping("cadastroSolicitacao/incluir")
        public String inclusaoSolicitacao(@RequestParam String produtos, @RequestParam(required = false) String requisitantes){
            System.out.println(requisitantes + " - " + produtos);

         return "redirect:/";
        }

}
