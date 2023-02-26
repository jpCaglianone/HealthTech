package com.example.healthtech.model.tests;


import com.example.healthtech.model.auxs.Metodos;
import com.example.healthtech.model.exception.*;

import com.example.healthtech.model.domain.*;

public class EquipamentoTeste {
        public static void main (String[] args) throws NomeInvalidoException, ValorValidoException, AnoInvalidoException, TensaoInvalidaException {
            Metodos.arqEnergia();

            //primeiro objeto
            try {
                Equipamento e1 = new Equipamento("usado", 2020, "Ventilador Pulmonar", 2, 57899.99f, "Maquet", 2, 5, "u89ihwgfod");
                System.out.println(e1.toString() + ";" + e1.getNomeProduto());
            } catch(NomeInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(AnoInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(TensaoInvalidaException e){
                System.out.println(e.getMessage());
            }
            catch(ValorValidoException e){
                System.out.println(e.getMessage());
            }

            //segundo objeto
            try {
                Equipamento e2 = new Equipamento("novo", 2020, "Monitor multiparametro", 8, 7899.99f, "Philips", 1, 0,"");
                System.out.println(e2.toString());
            } catch(NomeInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(AnoInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(TensaoInvalidaException e){
                System.out.println(e.getMessage());
            }
            catch(ValorValidoException e){
                System.out.println(e.getMessage());
            }

            //terceiro objeto
            try {
                Equipamento e3 = new Equipamento("novo", 2020, "Monitor multiparametro", 0, 7899.99f, "Philips", 1, 0,"9t28hg4fv");
                System.out.println(e3.toString());
            } catch(NomeInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(AnoInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(TensaoInvalidaException e){
                System.out.println(e.getMessage());
            }
            catch(ValorValidoException e){
                System.out.println(e.getMessage());
            }

            //quarto objeto
            try {
                Equipamento e4 = new Equipamento("novo", 2027, "Monitor multiparametro", 8, 7899.99f, "Philips", 1, 0,"t24-grvf");
                System.out.println(e4.toString());
            } catch(NomeInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(AnoInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(TensaoInvalidaException e){
                System.out.println(e.getMessage());
            }
            catch(ValorValidoException e){
                System.out.println(e.getMessage());
            }

            //quinto objeto
            try {
                Equipamento e5 = new Equipamento("outro", 2020, "", 8, 7899.99f, "Philips", 1, 0,"23-5-235");
                System.out.println(e5.toString());
            } catch(NomeInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(AnoInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(TensaoInvalidaException e){
                System.out.println(e.getMessage());
            }
            catch(ValorValidoException e){
                System.out.println(e.getMessage());
            }

            //sexto objeto
            try {
                Equipamento e6 = new Equipamento("novo", 2020, "Monitor multiparametro", 8, -23f, "Philips", 1, 0,"8h4fj");
                System.out.println(e6.toString());
            } catch(NomeInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(AnoInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(TensaoInvalidaException e){
                System.out.println(e.getMessage());
            }
            catch(ValorValidoException e){
                System.out.println(e.getMessage());
            }

            //setimo objeto
            try {
                Equipamento e7 = new Equipamento("novo", 2020, "Monitor multiparametro", 8, 7899.99f, "Philips", 90, 0, "29tjg8");
                System.out.println(e7.toString());
            } catch(NomeInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(AnoInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(TensaoInvalidaException e){
                System.out.println(e.getMessage());
            }
            catch(ValorValidoException e){
                System.out.println(e.getMessage());
            }
            //oitavo objeto
            try {
                Equipamento e8 = new Equipamento("novo", 2020, "Monitor multiparametro", 8, 7899.99f, "Philips", 0, 10,"3t4g/353");
                System.out.println(e8.toString());
            } catch(NomeInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(AnoInvalidoException e){
                System.out.println(e.getMessage());
            }
            catch(TensaoInvalidaException e){
                System.out.println(e.getMessage());
            }
            catch(ValorValidoException e){
                System.out.println(e.getMessage());
            }
        }
}

