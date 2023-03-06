package com.example.healthtech.model.tests;

import com.example.healthtech.model.auxs.Metodos;
import com.example.healthtech.model.exception.*;

import com.example.healthtech.model.domain.*;

import java.util.ArrayList;
import java.util.List;


public class SolicitacaoTeste {
    public static void main (String[] args) throws NomeInvalidoException, ValorValidoException, AnoInvalidoException, TensaoInvalidaException {

        Metodos.arqEnergia();

        List<Produto> p1 = new ArrayList<Produto>();
        List<Produto> p2 = new ArrayList<Produto>();
        List<Produto> p3 = new ArrayList<Produto>();
        List<Produto> p4 = new ArrayList<Produto>();
        List<Produto> p5 = new ArrayList<Produto>();
        List<Produto> p6 = new ArrayList<Produto>();

        try {
            Equipamento e1 = new Equipamento("Novo", 2000, "Cardioversor", 4, 7456.54f, "Cardiomax", 4, 2, "3t24/tgwes");
            p1.add(e1);
            p3.add(e1);
            p4.add(e1);
        } catch (NomeInvalidoException | TensaoInvalidaException | ValorValidoException e) {
            System.out.println(e.getMessage());
        }
        try {
            Equipamento e2 = new Equipamento("Usado", 2010, "cardiotocógrafo", 10, 2056.99f, "Bistos", 2, 5,"t34g-3");
            p1.add(e2);
            p2.add(e2);
            p5.add(e2);
            p6.add(e2);
        } catch (NomeInvalidoException | TensaoInvalidaException | ValorValidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            Acessorio a1 = new Acessorio("Oximetro", 20, 199.99f, "sem marca", "Serve para medir a oximetria do paciente", "Não", 1, "monitor");
            p3.add(a1);
            p4.add(a1);
        } catch (NomeInvalidoException | ValorValidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            Acessorio a2 = new Acessorio("ECG", 1, 129.99f, "Dixtal", "Serve para aferir frequeência cardíaca", "Sim", 2, "monitor");
            p3.add(a2);
            p4.add(a2);
        } catch (NomeInvalidoException | ValorValidoException e) {
            System.out.println(e.getMessage());
        }


        try {
            Insumo i1 = new Insumo("Manguitos", 15, 59.99f, "sem marca", "dependente", "permanente", 2);
            p1.add(i1);
            p3.add(i1);
            p5.add(i1);
            p6.add(i1);
        } catch (NomeInvalidoException | ValorValidoException | TipoInsumoException e) {
            System.out.println(e.getMessage());
        }

        try{
            Solicitacao s1 = new Solicitacao(new Requisitante("Elberth Moraes", 2,"Público", "teste", 1313423),p1,"C");
            s1.imprimirSolicitacao();
        }  catch (TipoInsumoException | TipoAquisicaoException | SolicitacaoSemProdutoException | SolicitacaoSemRequisitanteException | ValorValidoException| NomeInvalidoException  e) {
            System.out.println(e.getMessage());
        }
        try{
            Solicitacao s2 = new Solicitacao(new Requisitante("", 2,"Privado", "teste", 1313423),p1,"C");
            System.out.println(s2.imprimirSolicitacao());
        }  catch (TipoInsumoException | TipoAquisicaoException | SolicitacaoSemProdutoException | SolicitacaoSemRequisitanteException | ValorValidoException | NomeInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try{
            Solicitacao s3 = new Solicitacao(new Requisitante("João Pedro", 9,"Privado", "teste", 1313423),p1,"C");
            System.out.println(s3.imprimirSolicitacao());
        }  catch (TipoInsumoException | TipoAquisicaoException | SolicitacaoSemProdutoException | SolicitacaoSemRequisitanteException | ValorValidoException | NomeInvalidoException e) {
            System.out.println(e.getMessage());
        }
        try{
            Solicitacao s4 = new Solicitacao(new Requisitante("João Pedro", 2,"Privado", "teste", 1313423),p2,"Z");
            System.out.println(s4.imprimirSolicitacao());
        }  catch (TipoInsumoException | TipoAquisicaoException | SolicitacaoSemProdutoException | SolicitacaoSemRequisitanteException | ValorValidoException | NomeInvalidoException e) {
            System.out.println(e.getMessage());
        }
        try{
            Solicitacao s4 = new Solicitacao(new Requisitante("João Pedro", 4,"Privado", "teste", 1313423),p4,"A");
            System.out.println(s4.imprimirSolicitacao());
        }  catch (TipoInsumoException | TipoAquisicaoException | SolicitacaoSemProdutoException | SolicitacaoSemRequisitanteException | ValorValidoException | NomeInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
