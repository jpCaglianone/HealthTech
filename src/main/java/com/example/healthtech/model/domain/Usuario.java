package com.example.healthtech.model.domain;

public class Usuario {
    private int id;
    private int nivelUsuario;
    private String emailUsuario;
    private String nomeUsuario;
    private String senhaUsuario;

    public Usuario(String email, String nome, String senha, int nivel){
        setNivel(nivel);
        setEmail(email);
        setNome(nome);
        setSenha(senha);
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
}
