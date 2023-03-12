package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.exception.AnoInvalidoException;
import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.TensaoInvalidaException;
import com.example.healthtech.model.exception.ValorValidoException;
import com.example.healthtech.model.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @PostMapping("/cadastroEquipamento/incluir")
    public String AcessorioInclusao(Model model, @RequestParam String nomeProduto , @RequestParam String quantidadeProduto, @RequestParam String valorProduto
            , @RequestParam String marcaProduto, @RequestParam String anoFabricacao, @RequestParam String tensao, @RequestParam String corrente
            ,@RequestParam String estado, @RequestParam String numeroSerie) throws NomeInvalidoException, ValorValidoException, AnoInvalidoException, TensaoInvalidaException {


        mensagem = null;
        Equipamento equipamento= new Equipamento(estado,Integer.parseInt(anoFabricacao), nomeProduto, Integer.parseInt(quantidadeProduto),Float.parseFloat(valorProduto),marcaProduto,Integer.parseInt(corrente),Integer.parseInt(tensao), numeroSerie);
        if (!equipamentoService.incluirAcessorios(equipamento)) {
            mensagem = "Não foi possivel incluir o acessório!";
            model.addAttribute("mensagem",  mensagem);
            return "redirect:/cadastroAcessorio";
        }
        mensagem = "Acessório incluido com sucesso!";
        model.addAttribute("mensagem", mensagem );

        return "redirect:/cadastroEquipamento";

    }

    @GetMapping("listaEquipamento")
    public String ListaAcessoriosPage(Model model){

        model.addAttribute("listaEquipamento", equipamentoService.listarEquipamentos());

        return "PaginasEquipamento/listaEquipamento";
    }

}
