package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Requisitante;
import org.springframework.data.repository.CrudRepository;

public interface RequisitanteRepository extends CrudRepository<Requisitante,Integer> {

    public Requisitante save(Requisitante requisitante);
}
