package com.example.healthtech.model.auxs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.example.healthtech.model.auxs.Constantes.diretorio;

public class  Metodos {

    private static int id = 0;
    private static ArrayList tensao = new ArrayList<>();
    private static ArrayList corrente = new ArrayList<>();

    public static int ano(){
        int ano;

        LocalDateTime data = LocalDateTime.now();
        String aux = String.valueOf(data);
        aux = aux.substring(0,4);
        ano = Integer.valueOf(aux);

        return ano;
    }
    public static void arqEnergia() {

        ArrayList energia = new ArrayList<>();
        String arquivo = "energia.txt";

            try {
                FileReader arq = new FileReader(diretorio + arquivo);
                BufferedReader leitura = new BufferedReader(arq);

                String linha = leitura.readLine();;
                String[] campos = null;
                while(linha != null){
                    campos = linha.split(";");
                    String aux = campos[0];
                    if("t".equals(campos[0])){
                        tensao.add(campos[1]);
                    }
                    else if ("c".equals(campos[0])){
                       corrente.add(campos[1]);
                    }
                    linha = leitura.readLine();
                }
                leitura.close();
                arq.close();
            } catch (IOException e) {
                System.out.println("Não foi possivel ler o arquivo!");
            }
        }

    public static ArrayList getCorrente() {
        return corrente;
    }

    public static ArrayList getTensao() {
        return tensao;
    }

    public static int getId() {
        return id;
    }

    public static void setId() {
        Metodos.id ++;
    }
}

