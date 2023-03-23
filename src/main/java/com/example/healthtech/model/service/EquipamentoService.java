package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.repository.Antigo_EquipamentoRepository;
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
            return  false;
        }
    }
}
