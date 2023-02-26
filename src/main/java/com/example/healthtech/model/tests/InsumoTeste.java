package com.example.healthtech.model.tests;

import com.example.healthtech.model.exception.*;

import com.example.healthtech.model.domain.*;

public class InsumoTeste {
    public static void main (String[] args) throws NomeInvalidoException, ValorValidoException, AnoInvalidoException, TensaoInvalidaException {

        //primeiro objeto
        try{
          Insumo i1 = new Insumo("Seringa", 3, 0.5f, "Descarpak", "Independente","Descartável",10);
          System.out.println(String.format("R$%.2f", i1.calcularValorTotal()));
          System.out.println(i1.toString());
      } catch (TipoInsumoException | NomeInvalidoException | ValorValidoException e) {
            System.out.println(e.getMessage());
        }
        try{
            Insumo i2 = new Insumo("", 3, 0.5f, "Descarpak", "Independente","Descartável",10);
            System.out.println(String.format("R$%.2f", i2.calcularValorTotal()));
            System.out.println(i2.toString());
        } catch (TipoInsumoException | NomeInvalidoException | ValorValidoException e) {
            System.out.println(e.getMessage());
        }
        try{
            Insumo i3 = new Insumo("Seringa", 3, -2f, "Descarpak", "Independente","Descartável",10);
            System.out.println(String.format("R$%.2f", i3.calcularValorTotal()));
            System.out.println(i3.toString());
        } catch (TipoInsumoException | NomeInvalidoException| ValorValidoException e) {
            System.out.println(e.getMessage());
        }
        try{
            Insumo i4 = new Insumo("Seringa", 3, 0.5f, "Descarpak", "Independente","",10);
            System.out.println(String.format("R$%.2f", i4.calcularValorTotal()));
            System.out.println(i4.toString());
        } catch (TipoInsumoException | NomeInvalidoException | ValorValidoException e) {
            System.out.println(e.getMessage());
        }
        try{
            Insumo i5 = new Insumo("Seringa", 3, 0.5f, "Descarpak", "Independente","Descartável",0);
            System.out.println(String.format("R$%.2f", i5.calcularValorTotal()));
            System.out.println(i5.toString());
        } catch (TipoInsumoException | NomeInvalidoException | ValorValidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
