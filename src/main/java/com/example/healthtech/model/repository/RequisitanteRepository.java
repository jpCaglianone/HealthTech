package com.example.healthtech.model.repository;


import com.example.healthtech.model.domain.Requisitante;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class RequisitanteRepository {


    private static List<Requisitante> listaRequisitantes = new ArrayList<Requisitante>();

    public static List<Requisitante> getListaRequisitantes() {
        return listaRequisitantes;
    }

    public static boolean inclusaoRequisitante(Requisitante requisitante, Model model) {

        try {
            listaRequisitantes.add(requisitante);
            for (int i = 0; i < listaRequisitantes.size(); i++) {
                System.out.println(listaRequisitantes.get(i)); //temporário, para testes
                model.addAttribute("mensagem",true);
            }
            return true;
        } catch (Exception e) {
            model.addAttribute("mensagem",false);
            return false;
        }
    }
}

