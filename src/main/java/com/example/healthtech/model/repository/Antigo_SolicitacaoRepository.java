package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Solicitacao;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Antigo_SolicitacaoRepository {


    private static Map<Integer, Solicitacao> solicitacoes = new HashMap<Integer, Solicitacao>();
    private static Integer chavePrimaria = 1;

    public static boolean incluirSolicitacoes (Solicitacao solicitacao) {

        try{

            solicitacoes.put(chavePrimaria, solicitacao);
            chavePrimaria ++;
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static void excluitSolicitacoes (Integer id){
        solicitacoes.remove(id);
    }


    public static Collection<Solicitacao> obterListaSolicitacoes(){

        return solicitacoes.values();
    }

}
