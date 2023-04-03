package com.example.healthtech.client;

import com.example.healthtech.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url="https://viacep.com.br/ws", name = "enderecoClient")
public interface EnderecoClient {
    @GetMapping(value = "/{cep}/json")
    public Endereco buscaPorCep(@PathVariable String cep);


}
