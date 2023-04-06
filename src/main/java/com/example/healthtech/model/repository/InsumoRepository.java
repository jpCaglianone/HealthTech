package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.domain.Insumo;
import com.example.healthtech.model.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsumoRepository extends CrudRepository<Insumo,Integer> {
    @Query("from Insumo i where i.usuario.id = :userId ORDER BY i.nomeProduto ASC")
    List<Insumo> obterLista(Integer userId);

    @Query("from Insumo i ORDER BY i.nomeProduto ASC")
    List<Insumo> obterListaCompleta();
}
