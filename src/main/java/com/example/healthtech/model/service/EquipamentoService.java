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
        return equipamentoRepository.obterListaEquipamentos();
    }
    public boolean incluirEquipamentos(Equipamento equipamento){
        return equipamentoRepository.incluirEquipamentos(equipamento);
    }
}
