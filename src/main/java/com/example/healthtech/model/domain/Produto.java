package com.example.healthtech.model.domain;

import com.example.healthtech.model.exception.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="produto_tabela")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeProduto;
    private int quantidade;
    private float valor;
    private String marca;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToMany(mappedBy = "produtos")
    private List<Solicitacao> solicitacoes;



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

    public Produto() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
