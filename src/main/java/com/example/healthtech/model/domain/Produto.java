package com.example.healthtech.model.domain;

import com.example.healthtech.model.exception.*;

public abstract class Produto {
    private String nomeProduto;
    private int quantidade;
    private float valor;
    private String marca;

    public Produto(String nomeProduto, int quantidade, float valor, String marca) throws ValorValidoException, NomeInvalidoException {
        if (valor <= 0) {
            throw new ValorValidoException("O valor deve ser maior que 0!");
        }
        if (nomeProduto == null || nomeProduto.isEmpty()) {
            throw new NomeInvalidoException("O campo nome deve ser preenchido!");
        }
        if (quantidade <= 0) {
            throw new ValorValidoException("A quantidade deve ser maior que 0!");
        }
        if (marca == null || marca.isEmpty()) {
            throw new NomeInvalidoException("O campo marca deve ser preenchido!");
        }

        this.nomeProduto = nomeProduto;
        this.marca = marca;
        this.valor = valor;
        this.quantidade = quantidade;
    }


    public String toString() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append(this.getNomeProduto());
        mensagem.append(";");
        mensagem.append(this.getMarca());
        mensagem.append(";");
        mensagem.append(this.getValor());
        mensagem.append(";");
        mensagem.append(this.getQuantidade());

        return mensagem.toString();
    }

    public String getMarca() {
        return marca;
    }

    public float getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }


    public abstract float calcularValorTotal();
}
