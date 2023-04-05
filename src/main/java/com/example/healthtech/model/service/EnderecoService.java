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

        return enderecoClient.buscaPorCep(cep);
    }

}
