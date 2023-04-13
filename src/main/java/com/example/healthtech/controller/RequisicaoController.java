package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Endereco;
import com.example.healthtech.model.domain.Requisitante;
import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.service.RequisicaoService;
import com.example.healthtech.model.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("user")
public class RequisicaoController {

    private String mensagem;

    private boolean alerta;
    @Autowired
    private RequisicaoService requisicaoService;

    @Autowired
    private SolicitacaoService solicitacaoService;

    @GetMapping("/cadastroRequisitante")
    public String cadUserPage() {
        return "PaginasRequisitante/cadastroRequisitante";
    }

    @PostMapping(value = "cadastroRequisitante/incluir")
    public String postCadRequester(@SessionAttribute("user")Usuario usuario,
                                    Endereco endereco,
                                    Requisitante requisitante,Model model) {

        try {
            requisitante.setUsuario(usuario);
            requisitante.setEndereco(endereco);
            requisicaoService.inclusaoRequisitante(requisitante);
            model.addAttribute("alerta",false);
            model.addAttribute("mensagem", "Requisitante incluido com sucesso");
        }
        catch(Exception e){
            model.addAttribute("alerta",true);
            model.addAttribute("mensagem", "Requisitante não pode ser incluido. Log: " + e);
        }
        return "redirect:/cadastroRequisitante";
    }

    @GetMapping("listaRequisitante")
    public String listRequesterPage(Model model, @SessionAttribute("user") Usuario usuario) {

        int nivelUsuario = usuario.getNivel();

        if (nivelUsuario!=4) {
            model.addAttribute("listaRequisitantes", requisicaoService.listaRequisitantePorUsuario(usuario.getId()));
        }else{
            model.addAttribute("listaRequisitantes", requisicaoService.listarTodosRequisitantes());
        }
        model.addAttribute("nivelUsuario", nivelUsuario);
        model.addAttribute("alerta",alerta);
        model.addAttribute("mensagem", mensagem);

        return "PaginasRequisitante/listaRequisitante";
    }

    @GetMapping("listaRequisitante/{indice}/excluir")
    public String excluirRequisitante(@PathVariable Integer indice, Model model){

        if (solicitacaoService.retornaRequisitateSolicitacao(indice) >= 0) {
            alerta = true;
            mensagem = "Não foi possivel excluir o requisitante pois o mesmo tem uma solicitação em aberto!";
        }
        else {
            requisicaoService.excluirRequisitante(indice);
            alerta = false;
            mensagem = "Requisitante excluido com sucesso!";
        }
        return "redirect:/listaRequisitante";
    }

}
