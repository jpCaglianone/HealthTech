package com.example.healthtech;

import com.example.healthtech.model.auxs.Metodos;
import com.example.healthtech.model.domain.*;
import com.example.healthtech.model.exception.*;
import com.example.healthtech.model.service.RequisicaoService;
import com.example.healthtech.model.service.SolicitacaoService;
import com.example.healthtech.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Order(2)
@Component
public class RequisitanteLoader implements ApplicationRunner {

    @Autowired
    RequisicaoService requisicaoService;


    @Override
    public void run(ApplicationArguments args) throws Exception {







        String arquivoAcessorio = "requisitantes.txt";
        String diretorioArquivos="src\\data\\";

        try{
            FileReader fileR = new FileReader(diretorioArquivos + arquivoAcessorio);
            BufferedReader leitura = new BufferedReader(fileR);

            String linha = leitura.readLine();
            String[] campos = null;
            while (linha != null) {
                campos = linha.split(";");

                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(campos[5]));

                Requisitante requisitante = new Requisitante(
                        campos[0],
                        Integer.parseInt(campos[1]),
                        campos[2],
                        campos[3],
                        Long.parseLong(campos[4]));

                requisitante.setUsuario(usuario);
                requisicaoService.inclusaoRequisitante(requisitante);
                linha = leitura.readLine();

            }
            leitura.close();
            fileR.close();
    }
        catch (TipoInsumoException | NomeInvalidoException | ValorValidoException e){
            System.out.println("Não foi possível inserir os dados do arquivo requisitantes.txt. Verifique o arquivo e tente novamente!");
        }
        finally {
            System.out.println("Dados do arquivo " + arquivoAcessorio + " carregados com sucesso!");
        }

    }
}
