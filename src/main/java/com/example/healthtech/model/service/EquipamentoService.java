package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Acessorio;
import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EquipamentoService {
    @Autowired
    EquipamentoRepository equipamentoRepository;

    public List<Equipamento> listaEquipamentos(int id){
        return  equipamentoRepository.obterLista(id);
    }

    public Collection<Equipamento> listarTodosEquipamentos(){
        return equipamentoRepository.obterListaCompleta();
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

}
