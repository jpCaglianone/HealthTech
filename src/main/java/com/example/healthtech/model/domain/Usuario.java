package com.example.healthtech.model.domain;

import jakarta.persistence.*;
import com.example.healthtech.model.domain.Requisitante;
import java.util.List;

@Entity
@Table(name="Usuario_tabela")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int nivelUsuario;
    private String emailUsuario;
    private String nomeUsuario;
    private String senhaUsuario;

    private boolean bloqueado;
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Requisitante> requisitantes;
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Produto> produtos;
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Solicitacao> solicitacoes;


    public Usuario() {
    }
    public Usuario(String emailUsuario,String senhaUsuario) {
        setSenha(senhaUsuario);
        setEmail(emailUsuario);
    }

    public Usuario(String email, String nome, String senha, int nivel, boolean bloqueado){
        setNivel(nivel);
        setEmail(email);
        setNome(nome);
        setSenha(senha);
        setBloqueado(bloqueado);
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senhaUsuario = senha;
    }

    public void setEmail(String email) {
        this.emailUsuario = email;
    }

    public void setNivel(int nivel) {
        this.nivelUsuario = nivel;
    }

    public void setNome(String nome) {
        this.nomeUsuario = nome;
    }

    public String getSenha() {
        return senhaUsuario;
    }

    public String getEmail() {
        return emailUsuario;
    }

    public String getNome() {
        return nomeUsuario;
    }

    public int getId() {
        return id;
    }

    public int getNivel() {
        return nivelUsuario;
    }

    public List<Requisitante> getRequisitantes() {
        return requisitantes;
    }

    public void setRequisitantes(List<Requisitante> requisitantes) {
        this.requisitantes = requisitantes;
    }

    public String statusUsuario(){
        return this.isBloqueado()?"Inativo/Bloqueado":"Ativo";
    }

}
