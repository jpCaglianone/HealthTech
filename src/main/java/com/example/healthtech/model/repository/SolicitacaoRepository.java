package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Solicitacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SolicitacaoRepository extends CrudRepository<Solicitacao,Integer> {


    @Query("from Solicitacao s inner join Usuario u " +
            " on s.usuario.id = u.id " +
            " ORDER BY s.requisitante.nomeRequisitante ASC")
    List obterListaCompleta();
}
