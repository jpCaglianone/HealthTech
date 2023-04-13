package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Solicitacao;
import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SolicitacaoRepository extends CrudRepository<Solicitacao,Integer> {
    @Query("from Solicitacao s inner join Usuario u " +
            " on s.usuario.id = u.id " +
            "where s.usuario.id = :id" +
            " ORDER BY s.requisitante.nomeRequisitante ASC")
    List obterListaPorId(Integer id);
    @Query("from Solicitacao s inner join Usuario u " +
            " on s.usuario.id = u.id " +
            " ORDER BY s.requisitante.nomeRequisitante ASC")
    List obterListaCompleta();

    @Query("SELECT r.solicitacao.id FROM Requisitante r WHERE r.id = :id")
    Integer retornarNumeroSolicitacao(@Param("id") Integer id);

    @Query ("SELECT s.id FROM Solicitacao s where s.requisitante.id = :id")
    Integer retornaRequisitateSolicitacao(int id);
}
