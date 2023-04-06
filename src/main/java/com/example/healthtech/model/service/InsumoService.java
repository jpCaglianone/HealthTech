package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.domain.Insumo;
import com.example.healthtech.model.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;

@Controller
public class InsumoService {
    @Autowired
    InsumoRepository insumoRepository;

    public List<Insumo> listaInsumo(int id){
        return  insumoRepository.obterLista(id);
    }

    public Collection<Insumo> listarTodosInsumos(){
        return insumoRepository.obterListaCompleta();
    }
    public boolean incluirInsumos(Insumo insumo){

        try{
            insumoRepository.save(insumo);
            return true;
        }
        catch (Exception e){
            System.out.println("ERRO INSUMO - " + e);
            return  false;
        }
    }

    public void excluirInsumos (Integer id){
        insumoRepository.deleteById(id);
    }
}
