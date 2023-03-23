package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Acessorio;
import com.example.healthtech.model.repository.AcessorioRepository;
import com.example.healthtech.model.repository.Antigo_AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AcessorioService {

    @Autowired
    AcessorioRepository acessorioRepository;

    public Collection<Acessorio> listarAcessorios(){
        return (Collection<Acessorio>) acessorioRepository.findAll();
    }
    public boolean incluirAcessorios(Acessorio acessorio){

        try{
            acessorioRepository.save(acessorio);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
