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

    public boolean excluir (Integer id){
        try{
            requisitanteRepository.deleteById(id);
            System.out.println("Requisitante excluido com sucesso!");
            return true;
        }
        catch(Exception e){
            System.out.println("Erro exclusão requisitante: " + e);
            return false;
        }
    }

    public Collection<Requisitante> listarRequisitantes() {

        return  (Collection<Requisitante>) requisitanteRepository.findAll();
    }

    public boolean inclusaoRequisitante(Requisitante requisitante) {
        try {
            requisitanteRepository.save(requisitante);
            return true;
        } catch (Exception e) {
            return false;
        }
       //return requisitanteRepository.inclusaoRequisitante(requisitante);
    }


}
