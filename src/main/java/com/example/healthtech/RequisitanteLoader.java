package com.example.healthtech;

import com.example.healthtech.model.auxs.Metodos;
import com.example.healthtech.model.domain.*;
import com.example.healthtech.model.exception.*;
import com.example.healthtech.model.service.EnderecoService;
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

    @Autowired
    EnderecoService enderecoService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        String[] ceps = {"08391-712","04884-992","05639-100","04650-185","04843-475","08430-820","08430-900",
                        "01229-904","08391-705","08391-715","20250-450","20090-907","20251-901",
                        "20040-906","20031-900","20210-900","20931-675","21061-901","21360-901"};
        int i = 0;

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
                usuario.setId(Integer.parseInt(campos[4]));

                Requisitante requisitante = new Requisitante(
                        campos[0],
                        Integer.parseInt(campos[1]),
                        campos[2],
                        Long.parseLong(campos[3]));

                requisitante.setUsuario(usuario);

                Endereco endereco = enderecoService.buscaPorCep(ceps[i]);

                requisitante.setEndereco(endereco);
                requisicaoService.inclusaoRequisitante(requisitante);
                linha = leitura.readLine();

                i++;
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
