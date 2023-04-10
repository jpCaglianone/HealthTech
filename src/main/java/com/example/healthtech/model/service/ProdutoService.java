package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.*;
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


    public String excluirProduto(Integer id) {

        try{
            produtoRepository.deleteById(id);
            return "Produto de id " + id + "deletado com sucesso!";
        }
        catch (Exception e){
            return "Produto não pode ser deletado. Log do erro: " + e;
        }
    }

    public Collection<Produto> listarProdutos(int id){
        return (Collection<Produto>) produtoRepository.obterLista(id);
    }

    public Collection<Produto> listarTodosProdutos(){
        return (Collection<Produto>) produtoRepository.obterListaCompleta();
    }

    public Produto retornarProduto (Integer id){
        return produtoRepository.retornarProduto(id);
    }

}
