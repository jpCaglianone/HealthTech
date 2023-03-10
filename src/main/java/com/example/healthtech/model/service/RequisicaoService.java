package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Requisitante;
import com.example.healthtech.model.repository.RequisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RequisicaoService {

    @Autowired
    private RequisitanteRepository requisitanteRepository;

    public Collection<Requisitante> listarRequisitantes() {

        return  requisitanteRepository.obterListaRequisitantes();
    }

    public boolean inclusaoRequisitante(Requisitante requisitante) {

       return requisitanteRepository.inclusaoRequisitante(requisitante);
    }


}
