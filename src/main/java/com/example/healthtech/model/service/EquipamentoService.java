package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EquipamentoService {
    @Autowired
    EquipamentoRepository equipamentoRepository;

    public Collection<Equipamento> listarEquipamentos(){
        return (Collection<Equipamento>) equipamentoRepository.findAll();
    }
    public boolean incluirEquipamentos(Equipamento equipamento){
        try{
            equipamentoRepository.save(equipamento);
            return true;
        }catch (Exception e){
            System.out.println("ERRO EQUIPAMENTO - " + e);
            return  false;
        }
    }

    public void excluirEquipamentos (Integer id){
        equipamentoRepository.deleteById(id);
    }
    public Iterable<Equipamento> listaEquipamentos(){

        return  equipamentoRepository.findAll();

    }

    public Object listarEquipamentoPorId (Integer id){

        return equipamentoRepository.findById(id);
    }
}
