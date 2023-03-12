package com.example.healthtech.model.domain;


import com.example.healthtech.model.auxs.Constantes;
import com.example.healthtech.model.auxs.Metodos;
import com.example.healthtech.model.exception.*;

public class Equipamento extends Produto{

    private int anoFabricacao;
    private String numeroSerie;
    private String tipoAlimentacao;
    private boolean usado;

    public Equipamento(String estado, int anoFabricacao , String nomeProduto, int quantidade, float valor, String marca, int corrente, int tensao, String numeroSerie) throws NomeInvalidoException, ValorValidoException, AnoInvalidoException, TensaoInvalidaException {
        super(nomeProduto, quantidade, valor, marca);

        if (!"usado".equalsIgnoreCase(estado) && !"novo".equalsIgnoreCase(estado)){
            throw new NomeInvalidoException("O estado inserido só pode ser NOVO ou USADO");
        }

        if (anoFabricacao < Constantes.anoMenor || anoFabricacao > Metodos.ano()){
            throw new AnoInvalidoException("O ano não pode ser menor que " + Constantes.anoMenor + " ou maior que " + Metodos.ano());
        }

        if (tensao < 0 || tensao >= Constantes.tensoes.length){
            StringBuilder mensagem = new StringBuilder();
            mensagem.append("É permitido digitar somente uma opção válida de tensão");
            for (int i = 0; i < Metodos.getTensao().size(); i++){
                mensagem.append("\n" + i + " - " +  Metodos.getTensao().get(i));
            }
            throw new TensaoInvalidaException(mensagem);
        }
        if (corrente < 0 || corrente >= Constantes.correntes.length){
            StringBuilder mensagem = new StringBuilder();
            mensagem.append("É permitido digitar somente uma opção válida de corrente");
            for (int i = 0; i < Metodos.getCorrente().size(); i++){
                mensagem.append("\n" + i + " - " +  Metodos.getCorrente().get(i));
            }
            throw new TensaoInvalidaException(mensagem);
        }

        if (numeroSerie == null || numeroSerie.trim() == ""){
            throw new NomeInvalidoException("O número de série do equipamento deve ser preenchido!");
        }

        this.numeroSerie = numeroSerie;
        this.anoFabricacao = anoFabricacao;
        this.tipoAlimentacao = Constantes.tensoes[tensao] + "/" + Constantes.correntes[corrente];
        if ("usado".equalsIgnoreCase(estado)){
            this.usado = true;
        } else {
            this.usado = false;
        }


    }

    public String getEstado(){
        return isUsado()?"Usado":"Novo";
    }

    public boolean isUsado() {
        return usado;
    }

    public String getTipoAlimentacao() {
        return tipoAlimentacao;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    @Override
    public float calcularValorTotal() {
        float total = getValorEstado();
        total *= getQuantidade();
        return total;
    }

    public float getValorEstado(){
        float valor_estado = this.getValor();
        if (this.isUsado()){
            valor_estado *= 0.45; //perde 55% do valor total se for usado
        }
        return valor_estado;
    }

    @Override
    public float getValor() {
        return super.getValor();
    }

    @Override
    public String toString(){
        StringBuilder mensagem = new StringBuilder();
        mensagem.append(this.getAnoFabricacao());
        mensagem.append(";");
        mensagem.append(this.getTipoAlimentacao());
        mensagem.append(";");
        mensagem.append(this.isUsado()?"Usado":"Novo");
        mensagem.append(";");
        mensagem.append(this.getNumeroSerie());
        mensagem.append(";");
        mensagem.append(this.calcularValorTotal());

        return mensagem.toString();
    }



}
