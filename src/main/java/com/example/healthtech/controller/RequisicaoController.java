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


    @Autowired
    private RequisicaoService requisicaoService;

    @GetMapping("/cadastroRequisitante")
    public String cadUserPage() {
        return "PaginasRequisitante/cadastroRequisitante";
    }

    @PostMapping(value = "cadastroRequisitante/incluir")
    public String postCadRequester(@SessionAttribute("user")Usuario usuario, @RequestParam String nome,
                                   @RequestParam String tipoRequisitante, @RequestParam String orgao,
                                   @RequestParam String enderecoRequisitante, @RequestParam String registroRequisitante,
                                   Endereco endereco, Model model) throws TipoInsumoException, NomeInvalidoException, ValorValidoException {



        Requisitante requisitante = new Requisitante(nome, Integer.parseInt(tipoRequisitante), orgao, enderecoRequisitante, Long.parseLong(registroRequisitante));


        requisitante.setEndereco(endereco);
        requisitante.setUsuario(usuario);
        requisicaoService.inclusaoRequisitante(requisitante);


        model.addAttribute("mensagem", true);

        return "redirect:/";
    }

    @GetMapping("listaRequisitante")
    public String listRequesterPage(Model model, @SessionAttribute("user") Usuario usuario) {

        int nivelUsuario = usuario.getNivel();

        if (nivelUsuario!=4) {
            model.addAttribute("listaRequisitantes", requisicaoService.listarRequisitantes(nivelUsuario));
        }else{
            model.addAttribute("listaRequisitantes", requisicaoService.listarRequisitantes());
        }
        model.addAttribute("nivelUsuario", nivelUsuario);
        model.addAttribute("mensagem", "mensagem");

        return "PaginasRequisitante/listaRequisitante";
    }

}
