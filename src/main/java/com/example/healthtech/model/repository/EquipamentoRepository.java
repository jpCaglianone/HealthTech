package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Equipamento;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EquipamentoRepository {

    private static Map<Integer, Equipamento> equipamentos = new HashMap<Integer, Equipamento>();
    private static Integer chavePrimaria = 1;

    public static boolean incluirEquipamentos (Equipamento equipamento) {

        try{

            equipamentos.put(chavePrimaria, equipamento);
            chavePrimaria ++;
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static void excluirEquipamento (Integer id){
        equipamentos.remove(id);
    }


    public static Collection<Equipamento> obterListaEquipamentos(){

        return equipamentos.values();
    }


}
