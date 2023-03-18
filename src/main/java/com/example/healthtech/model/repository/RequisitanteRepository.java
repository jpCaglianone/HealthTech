package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Requisitante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisitanteRepository extends CrudRepository<Requisitante,Integer> {

    @Query("from Requisitante r where r.usuario.id = :id")
    List<Requisitante> listarRequisitantes(Integer id);
}
