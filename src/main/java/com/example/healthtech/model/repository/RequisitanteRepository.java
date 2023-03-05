package com.example.healthtech.model.repository;


import com.example.healthtech.model.domain.Requisitante;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RequisitanteRepository {


    private static List<Requisitante> listaRequisitantes = new ArrayList<Requisitante>();

    public List<Requisitante> getListaRequisitantes() {
        return listaRequisitantes;
    }

    public boolean inclusaoRequisitante(Requisitante requisitante) {

        try {
            listaRequisitantes.add(requisitante);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

