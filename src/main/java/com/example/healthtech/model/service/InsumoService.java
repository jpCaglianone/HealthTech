package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Insumo;
import com.example.healthtech.model.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
@Controller
public class InsumoService {
    @Autowired
    InsumoRepository insumoRepository;

    public Collection<Insumo> listarInsumos(){
        return (Collection<Insumo>) insumoRepository.findAll();
    }
    public boolean incluirInsumos(Insumo insumo){

        try{
            insumoRepository.save(insumo);
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }
}
