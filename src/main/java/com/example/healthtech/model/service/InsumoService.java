package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.domain.Insumo;
import com.example.healthtech.model.repository.EquipamentoRepository;
import com.example.healthtech.model.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
@Controller
public class InsumoService {
    @Autowired
    InsumoRepository insumoRepository;

    public Collection<Insumo> listarEquipamentos(){
        return insumoRepository.obterListaInsumos();
    }
    public boolean incluirAcessorios(Insumo insumo){
        return insumoRepository.incluirInsumos(insumo);
    }
}
