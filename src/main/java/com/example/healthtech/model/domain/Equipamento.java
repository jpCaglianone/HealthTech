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

        if (tensao < 0 || tensao >= Metodos.getTensao().size()){
            StringBuilder mensagem = new StringBuilder();
            mensagem.append("É permitido digitar somente uma opção válida de tensão");
            for (int i = 0; i < Metodos.getTensao().size(); i++){
                mensagem.append("\n" + i + " - " +  Metodos.getTensao().get(i));
            }
            throw new TensaoInvalidaException(mensagem);
        }
        if (corrente < 0 || corrente >= Metodos.getCorrente().size()){
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
        this.tipoAlimentacao = Metodos.getTensao().get(tensao) + "/" + Metodos.getCorrente().get(corrente);
        if ("usado".equalsIgnoreCase(estado)){
            this.usado = true;
        } else {
            this.usado = false;
        }
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
        float total = this.getValor();
        if (this.isUsado()){
            total *= 0.45; //perde 55% do valor total se for uysado
        }
        total *= getQuantidade();
        return total;
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
