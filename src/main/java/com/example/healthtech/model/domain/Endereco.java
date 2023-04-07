package com.example.healthtech.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name="endereco_tabela")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idRequisitante")
    private Requisitante requisitante;

    public Endereco() {

    }


    public Requisitante getRequisitante() {
        return requisitante;
    }

    public Endereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf){
        setCep(cep);
        setLogradouro(logradouro);
        setComplemento(complemento);
        setBairro(bairro);
        setLocalidade(localidade);
        setUf(uf);
    }


    public void setRequisitante(Requisitante requisitante) {
        this.requisitante = requisitante;
    }

    public Integer getId() {
        return id;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getUf() {
        return uf;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
