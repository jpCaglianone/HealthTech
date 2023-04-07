package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Acessorio;
import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.ValorValidoException;
import com.example.healthtech.model.service.AcessorioService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AcessorioController {

    String mensagem;

    @Autowired
    AcessorioService acessorioService;

    @GetMapping("/cadastroAcessorio")
    public String AcessorioListPage(Model model){

        model.addAttribute("mensagem", mensagem);
        return "PaginasAcessorio/cadastroAcessorio";
    }


    @PostMapping("/cadastroAcessorio/incluir")
    public String AcessorioInclusao( @RequestParam String nomeProduto
            , @RequestParam String quantidade, @RequestParam String valor
            , @RequestParam String marca, @RequestParam String funcao
            , @RequestParam String equipamentoAlvo, @RequestParam String acompanhaEquipamento
            , @RequestParam String linhaAcessorio, @SessionAttribute("user") Usuario usuario,Model model)
            throws NomeInvalidoException, ValorValidoException {

        mensagem = null;
        Acessorio acessorio = new Acessorio(nomeProduto, Integer.parseInt(quantidade),
                            Float.parseFloat(valor), marca, funcao, acompanhaEquipamento,
                            Integer.parseInt(linhaAcessorio),equipamentoAlvo);

        acessorio.setUsuario(usuario);
        if (!acessorioService.incluirAcessorios(acessorio)) {
            mensagem = "Não foi possivel incluir o acessório!";
            model.addAttribute("mensagem",  mensagem);
            return "redirect:/cadastroAcessorio";
        }
        mensagem = "Acessório incluido com sucesso!";
        model.addAttribute("mensagem", mensagem );
        return "redirect:/cadastroAcessorio";

    }


    @GetMapping("/listaAcessorio")
    public String ListaAcessoriosPage(Model model, @SessionAttribute("user") Usuario usuario){
        if (usuario.getNivel() == 4) {
            model.addAttribute("listaAcessorios", acessorioService.listarTodosAcessorios());
        }
        else {
            model.addAttribute("listaAcessorios", acessorioService.listarAcessorios(usuario.getId()));
        }
        return "PaginasAcessorio/listaAcessorio";
    }


    @GetMapping("listaAcessorio/{indice}/excluir")
    public String excluirAcessorio(@PathVariable Integer indice, Model model){
        acessorioService.excluirAcessorios(indice);
        mensagem = "O acessorio de id " + indice + " foi excluído com sucesso!";
        return "redirect:/listaAcessorio";
    }

}
