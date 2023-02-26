package com.example.healthtech.model.tests;

import com.example.healthtech.model.domain.Acessorio;
import com.example.healthtech.model.exception.*;



public class AcessorioTeste {
    public static void main (String[] args) {

        try {
            Acessorio a1 = new Acessorio("Cabo de ECG", 10,
                    99.9f, "Phillips", "Verifica os sinais vitais do paciente",
                    "Não", 2);
            a1.setEquipamentoAlvo("Monitor Multiparâmetro");
            System.out.println(a1.toString());
        } catch (ValorValidoException e) {
            System.out.println(("[ERRO] - " + e.getMessage()));
        } catch (NomeInvalidoException e) {
            System.out.println("[ERRO] - " + e.getMessage());
        }

        try {
            Acessorio a2 = new Acessorio("", 10,
                    99.9f, "Phillips", "Verifica os sinais vitais do paciente",
                    "Não", 2);
            a2.setEquipamentoAlvo("Monitor Multiparâmetro");
            System.out.println(a2.toString());
        } catch (ValorValidoException e) {
            System.out.println(("[ERRO] - " + e.getMessage()));
        } catch (NomeInvalidoException e) {
            System.out.println("[ERRO] - " + e.getMessage());
        }

        try {
            Acessorio a3 = new Acessorio("Cabo de ECG", 10,
                    99.9f, "Phillips", "",
                    "Não", 2);
            a3.setEquipamentoAlvo("Monitor Multiparâmetro");
            System.out.println(a3.toString());
        } catch (ValorValidoException e) {
            System.out.println(("[ERRO] - " + e.getMessage()));
        } catch (NomeInvalidoException e) {
            System.out.println("[ERRO] - " + e.getMessage());
        }

        try {
            Acessorio a4 = new Acessorio("Cabo de ECG", 10,
                    0, "Phillips", "Verifica os sinais vitais do paciente",
                    "Não", 2);
            a4.setEquipamentoAlvo("Monitor Multiparâmetro");
            System.out.println(a4.toString());
        } catch (ValorValidoException e) {
            System.out.println(("[ERRO] - " + e.getMessage()));
        } catch (NomeInvalidoException e) {
            System.out.println("[ERRO] - " + e.getMessage());
        }


        try {
            Acessorio a5 = new Acessorio("Cabo de ECG", 10,
                    99.9f, "Phillips", "Verifica os sinais vitais do paciente",
                    "Não", 123);
            a5.setEquipamentoAlvo("Monitor Multiparâmetro");
            System.out.println(a5.toString());
        } catch (ValorValidoException e) {
            System.out.println(("[ERRO] - " + e.getMessage()));
        } catch (NomeInvalidoException e) {
            System.out.println("[ERRO] - " + e.getMessage());
        }

        try {
            Acessorio a6 = new Acessorio("Cabo de ECG", 0,
                    99.9f, "Phillips", "Verifica os sinais vitais do paciente",
                    "Não", 2);
            a6.setEquipamentoAlvo("Monitor Multiparâmetro");
            System.out.println(a6.toString());
        } catch (ValorValidoException e) {
            System.out.println(("[ERRO] - " + e.getMessage()));
        } catch (NomeInvalidoException e) {
            System.out.println("[ERRO] - " + e.getMessage());
        }


    }


}
