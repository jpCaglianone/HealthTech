package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.exception.AnoInvalidoException;
import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.TensaoInvalidaException;
import com.example.healthtech.model.exception.ValorValidoException;
import com.example.healthtech.model.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class EquipamentoController {


    String mensagem;

    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping("/cadastroEquipamento")
    public String EquipamentoListPage(@SessionAttribute("user") Usuario usuario, Model model){

        if (usuario == null || usuario.getNivel()<=2){
            return "redirect:/"; //pode colocar uma página de acesso restrito
        }

        model.addAttribute("mensagem", mensagem);
        return "PaginasEquipamento/cadastroEquipamento";
    }


    @PostMapping("/cadastroEquipamento/incluir")
    public String AcessorioInclusao(Model model, @RequestParam String nomeProduto
            , @RequestParam String quantidade, @RequestParam String valor
            , @RequestParam String marca, @RequestParam String anoFabricacao
            , @RequestParam String numeroSerie, @RequestParam String tensao
            , @RequestParam String corrente , @RequestParam String estado
            ,@SessionAttribute("user") Usuario usuario) throws NomeInvalidoException, ValorValidoException, AnoInvalidoException, TensaoInvalidaException {

        mensagem = null;

        Equipamento equipamento = new Equipamento(estado, Integer.parseInt(anoFabricacao),
                                 nomeProduto, Integer.parseInt(quantidade), Float.parseFloat(valor),
                                 marca, Integer.parseInt(corrente), Integer.parseInt(tensao), numeroSerie);

        equipamento.setUsuario(usuario);
        if (!equipamentoService.incluirEquipamentos(equipamento)) {
            mensagem = "Não foi possivel incluir o acessório!";
            model.addAttribute("mensagem",  mensagem);
            return "redirect:/cadastroAcessorio";
        }
        mensagem = "Acessório incluido com sucesso!";
        model.addAttribute("mensagem", mensagem );

        return "redirect:/cadastroEquipamento";

    }


    @GetMapping("listaEquipamento")
    public String ListaAcessoriosPage(Model model, @SessionAttribute("user") Usuario usuario){
        if (usuario.getNivel() == 4) {
            model.addAttribute("listaEquipamento", equipamentoService.listarTodosEquipamentos());
        }
        else {
            model.addAttribute("listaEquipamento", equipamentoService.listaEquipamentos(usuario.getId()));
        }
        return "PaginasEquipamento/listaEquipamento";
    }



    @GetMapping("listaEquipamento/{indice}/excluir")
    public String excluirEquipamento(@PathVariable Integer indice){
        equipamentoService.excluirEquipamentos(indice);
        mensagem = "O equipamento de id " + indice + " foi excluído com sucesso!";
        return "redirect:/listaEquipamento";
    }

}
