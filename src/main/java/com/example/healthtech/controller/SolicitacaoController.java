package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Produto;
import com.example.healthtech.model.domain.Requisitante;
import com.example.healthtech.model.domain.Solicitacao;
import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.exception.SolicitacaoSemProdutoException;
import com.example.healthtech.model.exception.SolicitacaoSemRequisitanteException;
import com.example.healthtech.model.exception.TipoAquisicaoException;
import com.example.healthtech.model.service.ProdutoService;
import com.example.healthtech.model.service.RequisicaoService;
import com.example.healthtech.model.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
public class SolicitacaoController {

    @Autowired
    SolicitacaoService solicitacaoService;
    @Autowired
    ProdutoService produtoService;

    @Autowired
    RequisicaoService requisicaoService;

    @GetMapping("/listaSolicitacao")
    public String listaSolicitacoes(Model model){

        model.addAttribute("listaSolicitacoes", solicitacaoService.listarSolicitacoes());

        return "PaginasSolicitacao/listaSolicitacao";
    }

    @GetMapping("/cadastroSolicitacao")
    public String novaSolicitacao(Model model){


        model.addAttribute("listaProdutos", produtoService.listarTodosProdutos());
        model.addAttribute("listaRequisitantes", requisicaoService.listarTodosRequisitantes());

        return "PaginasSolicitacao/cadastroSolicitacao";
    }

        @PostMapping("cadastroSolicitacao/incluir")
        public String inclusaoSolicitacao(@RequestParam String produtos[], @RequestParam String requisitantes,
                                          @RequestParam String tipoSolicitacao, @SessionAttribute("user") Usuario usuario)
                throws TipoAquisicaoException, SolicitacaoSemProdutoException, SolicitacaoSemRequisitanteException {

            Requisitante requisitanteSolicitado = requisicaoService.retornarRequisitante(Integer.parseInt(requisitantes));

            List<Produto> produtoSolicitado = new ArrayList<>();
            for(int iProdutos = 0; iProdutos < produtos.length; iProdutos++) {
                produtoSolicitado.add(produtoService.retornarProduto(iProdutos));
            }
            Solicitacao solicitacao = new Solicitacao(requisitanteSolicitado, produtoSolicitado, tipoSolicitacao);
            solicitacao.setUsuario(usuario);
            solicitacaoService.incluirSolicitacoes(solicitacao);

         return "redirect:/";
        }

}
