package com.example.healthtech.model.domain;

import com.example.healthtech.model.exception.*;
public class Insumo extends Produto{

    private String tipoInsumo;
    private boolean descartavel;
    private int quantidadeLote;


    public Insumo(String nomeProduto, int quantidade, float valor, String marca,String tipoInsumo, String durabilidade, int quantidadeLote) throws TipoInsumoException,ValorValidoException, NomeInvalidoException {
        super(nomeProduto, quantidade, valor, marca);

    if(!"dependente".equalsIgnoreCase(tipoInsumo) && !"independente".equalsIgnoreCase(tipoInsumo)){
        throw new TipoInsumoException("Só são permitidos os valores DEPENDENTE ou INDEPENDENTE!1");
    }

    if(!"descartável".equalsIgnoreCase(durabilidade) && !"permanente".equalsIgnoreCase(durabilidade)){
        throw new TipoInsumoException("Só são permitidos os valores DESCARTÁVEL ou PERMANENTE");
    }

    if(quantidadeLote <= 0){
        throw new ValorValidoException("A quantidade deve ser maior que 0!");
    }

    this.tipoInsumo = tipoInsumo;

    this.descartavel = "descartável".equalsIgnoreCase(durabilidade);

    this.quantidadeLote = quantidadeLote;

    }

    public String getNomeInsumo(){
        return super.getNomeProduto();
    }
    public String getDescricaoDescartavel(){
        return isDescartavel()?"Permanente":"Descartável";
    }
    public int getQuantidadeLote() {
        return quantidadeLote;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public boolean isDescartavel() {
        return descartavel;
    }

    @Override
    public float calcularValorTotal() {
        float total;
        total = getValor();
        total *= getQuantidadeLote() * super.getQuantidade();
        if(!isDescartavel()){
         total *=1.3;
        }
        return total;
    }

    @Override
    public String toString(){
        StringBuilder mensagem = new StringBuilder();
        mensagem.append(this.getTipoInsumo());
        mensagem.append(";");
        mensagem.append(this.getQuantidadeLote());
        mensagem.append(";");
        mensagem.append(this.isDescartavel()?"Descartável":"Permanente");

        return String.valueOf(mensagem);
    }
}
