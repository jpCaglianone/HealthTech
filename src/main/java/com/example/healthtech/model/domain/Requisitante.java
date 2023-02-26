package com.example.healthtech.model.domain;

import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.TipoInsumoException;
import com.example.healthtech.model.exception.ValorValidoException;

public class Requisitante {
    private String nomeRequisitante;
    private int tipoRequisitante; // 1 - Hospital 2 - Clínica, 3 - Empresa/Instituição, 4 - outros
    private boolean orgaoPublico;
    //private int idRequisitante;


    public Requisitante (String nomeRequisitante, int tipoRequisitante, String orgao) throws ValorValidoException, NomeInvalidoException, TipoInsumoException {

        if (nomeRequisitante == null || nomeRequisitante == "".trim()){
            throw new NomeInvalidoException("O campo nome deve ser preenchido!");
        }
        if (tipoRequisitante <= 0 || tipoRequisitante > 4 ){
            throw new ValorValidoException("Só são válidos os tipos de requisitante de 1 a 4!");
        }
        if(!"público".equalsIgnoreCase(orgao) && !"privado".equalsIgnoreCase(orgao)){
            throw new TipoInsumoException("Só são permitidos os valores PÚBLICO ou PRIVADO");
        }
        this.nomeRequisitante = nomeRequisitante;
        this.tipoRequisitante = tipoRequisitante;
        if ("público".equalsIgnoreCase(orgao) ){
            setOrgaoPublico(true);
        }else{
            setOrgaoPublico(false);
        }
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

    public int getTipoRequisitante() {
        return tipoRequisitante;
    }

    public String getNomeRequisitante() {
        return nomeRequisitante;
    }

    public boolean isOrgaoPublico() {
        return orgaoPublico;
    }

    public void setNomeRequisitante(String nomeRequisitante) {
        this.nomeRequisitante = nomeRequisitante;
    }

    public void setTipoRequisitante(int tipoRequisitante) {
        this.tipoRequisitante = tipoRequisitante;
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
}
