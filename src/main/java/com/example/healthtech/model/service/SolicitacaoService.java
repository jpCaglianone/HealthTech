package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Solicitacao;
import com.example.healthtech.model.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class SolicitacaoService {
    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    public Collection<Solicitacao> listarSolicitacoes() {
        return solicitacaoRepository.obterListaSolicitacoes();
    }

    public boolean incluirSolicitacoes(Solicitacao solicitacao) {
        return solicitacaoRepository.incluirSolicitacoes(solicitacao);
    }
}