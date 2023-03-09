package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Acessorio;
import com.example.healthtech.model.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AcessorioService {

    @Autowired
    AcessorioRepository acessorioRepository;

    public Collection<Acessorio> listarAcessorios(){
        return acessorioRepository.obterListaAcessorios();
    }
    public boolean incluirAcessorios(Acessorio acessorio){
        return acessorioRepository.incluirAcessorios(acessorio);
    }

}
