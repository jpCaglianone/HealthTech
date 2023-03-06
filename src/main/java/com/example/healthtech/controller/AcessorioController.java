package com.example.healthtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AcessorioController {

    @GetMapping("/cadastroAcessorio")
    public String AcessorioListPage(){
        return "PaginasAcessorio/cadastroAcessorio";
    }


    @PostMapping("/cadastroAcessorio/incluir")
    public String AcessorioInclusao(@RequestParam String nomeAcessorio,@RequestParam String quantidadeAcessorio,@RequestParam String marcaAcessorio,
                                    @RequestParam String valorAcessorio,@RequestParam String equipamentoAlvo,@RequestParam String acompanhaEquipamento,
                                    @RequestParam String linhaAcessorio){
        System.out.println( nomeAcessorio + " - " + quantidadeAcessorio + " - " + marcaAcessorio + " - " +valorAcessorio
                + " - " + equipamentoAlvo + " - " +acompanhaEquipamento  + " - " + linhaAcessorio);

        return "PaginasAcessorio/cadastroAcessorio";
    }
}
