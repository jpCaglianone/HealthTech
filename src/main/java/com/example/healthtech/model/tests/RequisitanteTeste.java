package com.example.healthtech.model.tests;

import com.example.healthtech.model.exception.*;

import com.example.healthtech.model.domain.*;

public class RequisitanteTeste {
    public static void main(String[] args){

        try {
            Requisitante r1 = new Requisitante("João Pedro", 1,"Público", "Rua tal", 99999999999999l);
            System.out.println(r1.toString());
        } catch (ValorValidoException | TipoInsumoException | NomeInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            Requisitante r2 = new Requisitante("", 1,"Privado", "Rua tal", 99999999999999l);
            System.out.println(r2.toString());
        } catch (ValorValidoException | TipoInsumoException | NomeInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            Requisitante r2 = new Requisitante("João Pedro", 6,"","Rua tal", 99999999999999l);
            System.out.println(r2.toString());
        } catch (ValorValidoException | TipoInsumoException | NomeInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
