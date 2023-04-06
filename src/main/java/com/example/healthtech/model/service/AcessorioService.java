package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Acessorio;
import com.example.healthtech.model.domain.Produto;
import com.example.healthtech.model.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AcessorioService {

    @Autowired
    AcessorioRepository acessorioRepository;

    public List<Acessorio> listarAcessorios(int id){
        return  acessorioRepository.obterLista(id);
    }

    public Collection<Acessorio> listarTodosAcessorios(){
        return acessorioRepository.obterListaCompleta();
    }
    public boolean incluirAcessorios(Acessorio acessorio){

        try{
            acessorioRepository.save(acessorio);
            return true;
        }catch (Exception e){
            System.out.println("ERRO ACESSORIO - " + e);
            return false;
        }
    }

    public void excluirAcessorios (Integer id){
        acessorioRepository.deleteById(id);
    }
    public Iterable<Acessorio> listaAcessorios(){

        return  acessorioRepository.findAll();

    }

}
