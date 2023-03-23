package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Equipamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EquipamentoRepository extends CrudRepository<Equipamento, Integer> {

}
