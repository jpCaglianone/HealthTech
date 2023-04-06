package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class ProdutoController {
    private String mensagem;
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/listaProduto")
    public String listarProdutos(Model model, @SessionAttribute("user") Usuario usuario){
        if (usuario.getNivel() == 4) {
            model.addAttribute("listaProdutos", produtoService.listarTodosProdutos());

        }
        else {
            model.addAttribute("listaProdutos", produtoService.listarProdutos(usuario.getId()));
        }
         return "PaginasProduto/listaProdutos";
    }

    @GetMapping("listaProduto/{indice}/excluir")
    public String excluirProduto(@PathVariable Integer indice){
        mensagem = produtoService.excluirProduto(indice);
        return "redirect:/listaProduto";
    }

}
