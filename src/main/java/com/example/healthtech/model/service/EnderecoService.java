package com.example.healthtech.model.service;

import com.example.healthtech.client.EnderecoClient;
import com.example.healthtech.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoClient enderecoClient;


    public Endereco buscaPorCep(String cep){
       /* Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.setBairro("Rio comprido");
        endereco.setComplemento("apartamento 201");
        endereco.setLocalidade("ZN");
        endereco.setLogradouro("Rua Tenente Vieira Sampaio, 154");
        endereco.setUf("RJ");
        */

        return enderecoClient.buscaPorCep(cep);
    }

}
