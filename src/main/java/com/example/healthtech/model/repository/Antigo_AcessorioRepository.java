package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Acessorio;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class Antigo_AcessorioRepository {
    private static Map<Integer, Acessorio> acessorios = new HashMap<Integer, Acessorio>();
    private static Integer chavePrimaria = 1;

    public static boolean incluirAcessorios (Acessorio acessorio) {

        try{
            acessorios.put(chavePrimaria, acessorio);
            chavePrimaria ++;
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static void excluirAcessorio (Integer id){
        acessorios.remove(id);
    }


    public static Collection<Acessorio> obterListaAcessorios(){

        return acessorios.values();
    }

}
