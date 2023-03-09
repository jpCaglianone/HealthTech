package com.example.healthtech.model.repository;


import com.example.healthtech.model.domain.Requisitante;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.*;

@Repository
public class RequisitanteRepository {


    private Map<Integer,Requisitante> listaRequisitantes = new HashMap<Integer,Requisitante>();
    private static Integer chavePrimaria = 1;

    public Collection<Requisitante> obterListaRequisitantes() {
        return listaRequisitantes.values();
    }

    public boolean inclusaoRequisitante(Requisitante requisitante) {

        try {
            listaRequisitantes.put(chavePrimaria, requisitante);
            chavePrimaria ++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

