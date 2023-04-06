package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EquipamentoRepository extends CrudRepository<Equipamento, Integer> {
    @Query("from Equipamento e where e.usuario.id = :userId ORDER BY e.nomeProduto ASC")
    List<Equipamento> obterLista(Integer userId);

    @Query("from Equipamento e ORDER BY e.nomeProduto ASC")
    List<Equipamento> obterListaCompleta();
}
