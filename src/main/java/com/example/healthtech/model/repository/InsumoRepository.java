package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.domain.Insumo;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class InsumoRepository {

    private static Map<Integer, Insumo> insumos = new HashMap<Integer, Insumo>();
    private static Integer chavePrimaria = 1;

    public static boolean incluirInsumos (Insumo insumo) {

        try{

            insumos.put(chavePrimaria, insumo);
            chavePrimaria ++;
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static void excluirInsumos (Integer id){
        insumos.remove(id);
    }


    public static Collection<Insumo> obterListaInsumos(){

        return insumos.values();
    }


}
