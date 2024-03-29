package com.example.healthtech.model.domain;

import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.TipoInsumoException;
import com.example.healthtech.model.exception.ValorValidoException;
import jakarta.persistence.*;

@Entity
@Table(name = "Requisitante_tabela")
public class Requisitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeRequisitante;
    private int tipoRequisitante; // 1 - Hospital 2 - Clínica, 3 - Empresa/Instituição, 4 - outros
    private boolean orgaoPublico;
    private long registroRequisitante;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idSolicitacao")
    private Solicitacao solicitacao;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;



    public Requisitante (String nomeRequisitante, int tipoRequisitante, String orgao, long registroRequisitante) throws ValorValidoException, NomeInvalidoException, TipoInsumoException {

        if (nomeRequisitante == null || nomeRequisitante == "".trim()){
            throw new NomeInvalidoException("O campo nome deve ser preenchido!");
        }
        if (tipoRequisitante <= 0 || tipoRequisitante > 4 ){
            throw new ValorValidoException("Só são válidos os tipos de requisitante de 1 a 4!");
        }
        if(!"público".equalsIgnoreCase(orgao) && !"privado".equalsIgnoreCase(orgao)){
            throw new TipoInsumoException("Só são permitidos os valores PÚBLICO ou PRIVADO");
        }

        if (registroRequisitante <= 0){
            throw new ValorValidoException("Registro inválido!");
        }

        this.registroRequisitante = registroRequisitante;
        this.nomeRequisitante = nomeRequisitante;
        this.tipoRequisitante = tipoRequisitante;
        if ("público".equalsIgnoreCase(orgao) ){
            setOrgaoPublico(true);
        }else{
            setOrgaoPublico(false);
        }
    }

    public Requisitante() {

    }

    @Override
    public String toString(){
        StringBuilder mensagem = new StringBuilder();
        mensagem.append(this.nomeRequisitante);
        mensagem.append(";");
        mensagem.append(this.dominioRequisitante());
        mensagem.append(";");
        mensagem.append(this.orgaoPublico?"Público":"Privado");

        return mensagem.toString();
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public long getRegistroRequisitante() {
        return registroRequisitante;
    }


    public String descricaoOrgao(){
        return this.orgaoPublico?"Público":"Privado";
    }

    public int getTipoRequisitante() {
        return tipoRequisitante;
    }

    public  String getNomeRequisitante() {
        return nomeRequisitante;
    }

    public boolean isOrgaoPublico() {
        return orgaoPublico;
    }

    public void setOrgaoPublico(boolean orgaoPublico) {
        this.orgaoPublico = orgaoPublico;
    }

    public String dominioRequisitante(){
        String dominio = switch (this.getTipoRequisitante()) {
            case 1 -> "Hospital";
            case 2 -> "Clínica";
            case 3 -> "Empresa/Instituição";
            case 4 -> "Outros";
            default -> "";
        };
        return dominio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    public void setRegistroRequisitante(long registroRequisitante) {
        this.registroRequisitante = registroRequisitante;
    }

    public void setNomeRequisitante(String nomeRequisitante) {
        this.nomeRequisitante = nomeRequisitante;
    }

    public void setTipoRequisitante(int tipoRequisitante) {
        this.tipoRequisitante = tipoRequisitante;
    }

    public void setId(int id) {
        this.id = id;
    }
}
