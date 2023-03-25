package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.domain.Insumo;
import com.example.healthtech.model.domain.Produto;
import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.repository.EquipamentoRepository;
import com.example.healthtech.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public boolean incluirProduto(Produto produto){

        try{
            produtoRepository.save(produto);
            return true;
        }
        catch (Exception e){
            System.out.println("ERRO PRODUTO - " + e);
            return  false;
        }
    }


    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }

    public Collection<Produto> listarEquipamentos(){
        return (Collection<Produto>) produtoRepository.findAll();
    }



}
