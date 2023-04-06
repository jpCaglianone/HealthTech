package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Insumo;
import com.example.healthtech.model.domain.Produto;
import com.example.healthtech.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto,Integer> {
    @Query("from Produto p where p.usuario.id = :userId ORDER BY p.valor ASC")
    List<Produto> obterLista(Integer userId);

    @Query("from Produto p ORDER BY p.valor ASC")
    List<Produto> obterListaCompleta();
}
