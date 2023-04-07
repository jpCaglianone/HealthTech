package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Endereco;
import com.example.healthtech.model.domain.Requisitante;
import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.exception.*;
import com.example.healthtech.model.service.RequisicaoService;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class RequisicaoController {

    private String mensagem;
    @Autowired
    private RequisicaoService requisicaoService;

    @GetMapping("/cadastroRequisitante")
    public String cadUserPage() {
        return "PaginasRequisitante/cadastroRequisitante";
    }

    @PostMapping(value = "cadastroRequisitante/incluir")
    public String postCadRequester(@SessionAttribute("user")Usuario usuario,
                                    Endereco endereco,
                                    Requisitante requisitante,Model model) {

        System.out.println(endereco.getLogradouro());
        requisitante.setUsuario(usuario);
        requisitante.setEndereco(endereco);
        requisicaoService.inclusaoRequisitante(requisitante);
        model.addAttribute("mensagem", true);

        return "redirect:/";
    }

    @GetMapping("listaRequisitante")
    public String listRequesterPage(Model model, @SessionAttribute("user") Usuario usuario) {

        int nivelUsuario = usuario.getNivel();


        System.out.println(requisicaoService.listaRequisitante(usuario.getId()));


        if (nivelUsuario!=4) {
            model.addAttribute("listaRequisitantes", requisicaoService.listaRequisitante(usuario.getId()));
        }else{
            model.addAttribute("listaRequisitantes", requisicaoService.listarTodosRequisitantes());
        }
        model.addAttribute("nivelUsuario", nivelUsuario);
        model.addAttribute("mensagem", "mensagem");

        return "PaginasRequisitante/listaRequisitante";
    }

    @GetMapping("listaRequisitante/{indice}/excluir")
    public String excluirRequisitante(@PathVariable Integer indice){
        mensagem = requisicaoService.excluirRequisitante(indice);
        return "redirect:/listaRequisitante";
    }

}
