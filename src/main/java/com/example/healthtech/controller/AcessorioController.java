package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Acessorio;
import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.ValorValidoException;
import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AcessorioController {

    String mensagem;

    @GetMapping("/cadastroAcessorio")
    public String AcessorioListPage(Model model){

        model.addAttribute("mensagem", mensagem);
        return "PaginasAcessorio/cadastroAcessorio";
    }


    @PostMapping("/cadastroAcessorio/incluir")
    public String AcessorioInclusao(@RequestParam String nomeAcessorio, @RequestParam String quantidadeAcessorio, @RequestParam String marcaAcessorio,
                                    @RequestParam String valorAcessorio, @RequestParam String equipamentoAlvo, @RequestParam String acompanhaEquipamento,
                                    @RequestParam String linhaAcessorio, @RequestParam String funcaoAcessorio, Model model) throws NomeInvalidoException, ValorValidoException {

        mensagem = null;
        Acessorio acessorio;
        try {
             acessorio = new Acessorio(nomeAcessorio, Integer.parseInt(quantidadeAcessorio), Float.parseFloat(valorAcessorio),
            marcaAcessorio, funcaoAcessorio, acompanhaEquipamento, Integer.parseInt(linhaAcessorio), equipamentoAlvo);
             mensagem = "Acessório cadastrado com sucesso!";
            model.addAttribute("mensagem", mensagem);
        }catch (Exception e) {
            mensagem = "Acessório não pode ser cadastrado";

        }

        return "redirect:/cadastroAcessorio";
    }

    @GetMapping("listaAcessorio")
    public String ListaAcessoriosPage(Model model){


        return "PaginasAcessorio/listaAcessorio";
    }
}
