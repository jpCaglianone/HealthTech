package com.example.healthtech;


import com.example.healthtech.model.domain.Equipamento;
import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.exception.AnoInvalidoException;
import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.TensaoInvalidaException;
import com.example.healthtech.model.exception.ValorValidoException;
import com.example.healthtech.model.service.AcessorioService;
import com.example.healthtech.model.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(4)
@Component
public class EquipamentoLoader implements ApplicationRunner {

    @Autowired
    EquipamentoService equipamentoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(4);


        String arquivoEquipamento = "equipamentos.txt";
        try {
            FileReader fileR = new FileReader("src\\data\\" + arquivoEquipamento);
            BufferedReader leitura = new BufferedReader(fileR);

            String linha = leitura.readLine();
            String[] campos = null;
            while (linha != null) {

                campos = linha.split(";");
                // Equipamento.setId(1);

                    Equipamento equipamento = new Equipamento(
                            campos[0],
                            Integer.parseInt(campos[1]),
                            campos[2],
                            Integer.parseInt(campos[3]),
                            Float.parseFloat(campos[4]),
                            campos[5],
                            Integer.parseInt(campos[6]),
                            Integer.parseInt(campos[7]),
                            campos[8]
                    );
                    equipamento.setUsuario(usuario);
                    equipamentoService.incluirEquipamentos(equipamento);

                System.out.println("A inclusão do equipamento  foi realizada com sucesso!");
                linha = leitura.readLine();
            }

            leitura.close();
            fileR.close();
        }
         catch (NomeInvalidoException | AnoInvalidoException | TensaoInvalidaException | ValorValidoException e) {
             System.out.println("Não foi possivel carregar os dados do arquivo equipamentos.txt. Verifique a construção do arquivo e tente novamente!");
         }
    }
}