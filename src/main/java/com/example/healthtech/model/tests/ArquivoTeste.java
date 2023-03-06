package com.example.healthtech.model.tests;


import com.example.healthtech.model.auxs.Constantes;
import com.example.healthtech.model.auxs.Metodos;
import com.example.healthtech.model.domain.*;
import com.example.healthtech.model.exception.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoTeste {

    public static void main(String[] args) {
        Metodos.arqEnergia();
        String arq = "solicitacoes.txt";
        try {
            FileReader arquivoL = new FileReader(Constantes.diretorio + "entrada_" + arq);
            BufferedReader leitura = new BufferedReader(arquivoL);

            FileWriter arquivoE = new FileWriter(Constantes.diretorio + "saida_" + arq);
            BufferedWriter escrita = new BufferedWriter(arquivoE);

            String linha = leitura.readLine();
            String[] campos = null;

            List<Produto> produtos = new ArrayList<Produto>();
            Solicitacao solicitacao = null;

            while (linha != null){
                campos = linha.split(";");

                switch (campos[0]){
                    case "a":
                        try {
                            Acessorio a1 = new Acessorio(campos[1], Integer.parseInt(campos[2]), Float.parseFloat(campos[3]), campos[4],campos[5], campos[6],Integer.parseInt(campos[7]));
                            a1.setEquipamentoAlvo("Monitor Multiparâmetro");
                            produtos.add(a1);
                            System.out.println(a1.toString());
                        } catch (ValorValidoException | NomeInvalidoException e) {
                            System.out.println(("[ERRO] - " + e.getMessage()));
                        }
                        break;
                    case "e":
                        try {
                            Equipamento e1 = new Equipamento(campos[1], Integer.parseInt(campos[2]), campos[3], Integer.parseInt(campos[4]), Float.parseFloat(campos[5]), campos[6], Integer.parseInt(campos[7]), Integer.parseInt(campos[8]), campos[9]);
                            produtos.add(e1);
                            System.out.println(e1.toString());
                        }catch(TensaoInvalidaException |ValorValidoException | AnoInvalidoException | NomeInvalidoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "i":
                        try{
                            Insumo i1 = new Insumo(campos[1], Integer.parseInt(campos[2]), Float.parseFloat(campos[3]), campos[4], campos[5],campos[6],Integer.parseInt(campos[7]));
                            produtos.add(i1);
                            System.out.println(String.format("R$%.2f", i1.calcularValorTotal()));
                            System.out.println(i1.toString());
                        } catch (TipoInsumoException | NomeInvalidoException | ValorValidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "s":
                        try {
                            solicitacao = new Solicitacao(new Requisitante(campos[1], Integer.parseInt(campos[2]), campos[3],"teste", 1313423), produtos, campos[4]);
                            escrita.write("\n");
                            escrita.write(solicitacao.imprimirSolicitacao());
                            escrita.write("\n");
                            escrita.write("--------------------------------------------------------------------------------------------------------------------------------------");
                        }catch (TipoInsumoException | TipoAquisicaoException | SolicitacaoSemProdutoException | SolicitacaoSemRequisitanteException | ValorValidoException| NomeInvalidoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "r":
                        try {
                            Requisitante r1 = new Requisitante(campos[1], Integer.parseInt(campos[2]),campos[3], "teste", 1313423);
                            System.out.println(r1.toString());
                        } catch (ValorValidoException | TipoInsumoException | NomeInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }

                linha = leitura.readLine();
            }

            escrita.close();
            leitura.close();
            arquivoL.close();
            arquivoE.close();

        } catch (IOException e) {
            System.out.println("[ERRO] - Não foi possível ler o arquivo");
        } finally {
            System.out.println("Arquivo de pedido gerado com sucesso!");
        }
    }
}