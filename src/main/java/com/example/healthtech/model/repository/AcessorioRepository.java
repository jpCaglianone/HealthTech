package com.example.healthtech.model.repository;


import com.example.healthtech.model.domain.Acessorio;
import com.example.healthtech.model.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcessorioRepository extends CrudRepository<Acessorio,Integer> {

    @Query("from Acessorio a where a.usuario.id = :userId ORDER BY a.nomeProduto ASC")
    List<Acessorio> obterLista(Integer userId);

    @Query("from Acessorio a ORDER BY a.nomeProduto ASC")
    List<Acessorio> obterListaCompleta();
}

