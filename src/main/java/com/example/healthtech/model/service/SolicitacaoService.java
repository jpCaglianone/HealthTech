package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Solicitacao;
import com.example.healthtech.model.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SolicitacaoService {
    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    public List listarTodasSolicitacoes() {
        return  solicitacaoRepository.obterListaCompleta();
    }

    public List listarSolicitacoesPorId(int id) {
        return  solicitacaoRepository.obterListaPorId(id);
    }

    public void excluirSolicitacao  (Integer id){
        solicitacaoRepository.deleteById(id);
    }
    public void incluirSolicitacoes(Solicitacao solicitacao) {

            try {
                solicitacaoRepository.save(solicitacao);
                System.out.println("Solicitação incluida com sucesso");
            }catch (Exception e){
                System.out.println(e);
            }
    }





    public int retornaRequisitateSolicitacao (Integer id){

        if (solicitacaoRepository.retornaRequisitateSolicitacao(id) == null){
            return (-1);
        }
        else{
            return solicitacaoRepository.retornaRequisitateSolicitacao(id);
        }

    }


}