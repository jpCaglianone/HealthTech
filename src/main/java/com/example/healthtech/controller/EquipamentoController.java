package com.example.healthtech.controller;

import com.example.healthtech.model.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipamentoController {


    String mensagem;

    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping("/cadastroEquipamento")
    public String EquipamentoListPage(Model model){

        model.addAttribute("mensagem", mensagem);
        return "PaginasEquipamento/cadastroEquipamento";
    }

/*
    @PostMapping("/cadastroEquipamento/incluir")
    public String AcessorioInclusao(@RequestParam String nomeAcessorio, @RequestParam String quantidadeAcessorio, @RequestParam String marcaAcessorio,
                                    @RequestParam String valorAcessorio, @RequestParam String equipamentoAlvo, @RequestParam String acompanhaEquipamento,
                                    @RequestParam String linhaAcessorio, @RequestParam String funcaoAcessorio, Model model) throws NomeInvalidoException, ValorValidoException {

        mensagem = null;
        Acessorio acessorio= new Acessorio(nomeAcessorio, Integer.parseInt(quantidadeAcessorio), Float.parseFloat(valorAcessorio),
                marcaAcessorio, funcaoAcessorio, acompanhaEquipamento, Integer.parseInt(linhaAcessorio), equipamentoAlvo);
        if (!acessorioService.incluirAcessorios(acessorio)) {
            mensagem = "Não foi possivel incluir o acessório!";
            model.addAttribute("mensagem",  mensagem);
            return "redirect:/cadastroAcessorio";
        }
        mensagem = "Acessório incluido com sucesso!";
        model.addAttribute("mensagem", mensagem );
        return "redirect:/cadastroAcessorio";

    }
*/
    @GetMapping("listaEquipamento")
    public String ListaAcessoriosPage(Model model){

        model.addAttribute("listaEquipamento", equipamentoService.listarEquipamentos());

        return "PaginasEquipamento/listaEquipamento";
    }

}
