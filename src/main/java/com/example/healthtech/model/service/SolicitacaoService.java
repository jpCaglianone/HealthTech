package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Solicitacao;
import com.example.healthtech.model.repository.Antigo_SolicitacaoRepository;
import com.example.healthtech.model.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class SolicitacaoService {
    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    public Collection<Solicitacao> listarSolicitacoes() {
        return (Collection<Solicitacao>) solicitacaoRepository.findAll();
    }

    public void incluirSolicitacoes(Solicitacao solicitacao) {

            try {
                solicitacaoRepository.save(solicitacao);
                System.out.println("Solicitação incluida com sucesso");
            }catch (Exception e){
                System.out.println(e);
            }


    }
}