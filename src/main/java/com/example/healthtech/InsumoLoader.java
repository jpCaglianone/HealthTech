package com.example.healthtech;

import com.example.healthtech.model.domain.Insumo;
import com.example.healthtech.model.domain.Requisitante;
import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.TipoInsumoException;
import com.example.healthtech.model.exception.ValorValidoException;
import com.example.healthtech.model.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@Order(3)
@Component
public class InsumoLoader  implements ApplicationRunner {
    @Autowired
    InsumoService insumoService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String arquivoAcessorio = "insumos.txt";
        String diretorioArquivos="src\\data\\";

        try{
            FileReader fileR = new FileReader(diretorioArquivos + arquivoAcessorio);
            BufferedReader leitura = new BufferedReader(fileR);

            String linha = leitura.readLine();
            String[] campos = null;


            while (linha != null) {
                campos = linha.split(";");

                Insumo insumo = new Insumo(campos[0],
                        Integer.parseInt(campos[1]),
                        Float.parseFloat(campos[2]),
                        campos[3],
                        campos[4],
                        campos[5],
                        Integer.parseInt(campos[6]));

                insumoService.incluirInsumos(insumo);

                linha = leitura.readLine();
            }
            leitura.close();
            fileR.close();

        }
       catch (TipoInsumoException | NomeInvalidoException | ValorValidoException e){

            System.out.println("Não foi possível inserir os dados do arquivo insumos.txt. Verifique o arquivo e tente novamente!" + e);
        }
        finally {
            System.out.println("Dados do arquivo " + arquivoAcessorio + " carregados com sucesso!");
        }
    }
}
