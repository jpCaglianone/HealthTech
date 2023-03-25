
package com.example.healthtech;

import com.example.healthtech.model.domain.Acessorio;
import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.ValorValidoException;
import com.example.healthtech.model.service.AcessorioService;
import com.example.healthtech.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;

@Order(5)
@Component
public class AcessorioLoader implements ApplicationRunner {

    @Autowired
    AcessorioService acessorioService;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(1);

        String arquivoAcessorio = "acessorios.txt";
        try {
            FileReader fileR = new FileReader("src\\data\\" + arquivoAcessorio);
            BufferedReader leitura = new BufferedReader(fileR);

            String linha = leitura.readLine();
            String[] campos = null;
            while (linha != null) {

                campos = linha.split(";");
                // Acessorio.setId(1);

                    Acessorio acessorio = new Acessorio(
                            campos[0],
                            Integer.parseInt(campos[1]),
                            Float.parseFloat(campos[2]),
                            campos[3],
                            campos[4],
                            campos[5],
                            Integer.parseInt(campos[6]),
                            campos[7]);


                    acessorio.setUsuario(usuario);
                    acessorioService.incluirAcessorios(acessorio);



                System.out.println("A inclusão do acessorio  foi realizada com sucesso!");
                linha = leitura.readLine();
            }

            leitura.close();
            fileR.close();
        }
        catch (NomeInvalidoException | ValorValidoException e) {


            System.out.println("Não foi possivel carregar os dados do arquivo acessorios.txt. Verifique a construção do arquivo e tente novamente!");
        }
    }
}
