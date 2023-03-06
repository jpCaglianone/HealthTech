package com.example.healthtech.model.domain;


import com.example.healthtech.model.exception.*;
public class Acessorio extends Produto{

    private String equipamentoAlvo;
    private String funcao;
    private boolean acompanhaEquipamento;
    private int linhaNomenclatura;
    public Acessorio(String nomeProduto, int quantidade, float valor, String marca, String funcao, String acompanhaEquipamento, int linhaNomenclatura, String equipamentoAlvo) throws ValorValidoException, NomeInvalidoException {

        super(nomeProduto, quantidade, valor, marca);

        if (funcao == null || funcao == "".trim()){
            throw new NomeInvalidoException("A função do acessório deve ser cadastrada?");
        }
        if (linhaNomenclatura < 0 || linhaNomenclatura > 3 ){
            throw new ValorValidoException("Só são permitidos valores de 0 a 3!");
        }
        if (!"sim".equalsIgnoreCase(acompanhaEquipamento.trim()) && !"não".equalsIgnoreCase(acompanhaEquipamento.trim())){
            throw new NomeInvalidoException("Somente é permitido inserir SIM ou NÃO!");
        }

        this.equipamentoAlvo = equipamentoAlvo;
        this.funcao = funcao;
        this.linhaNomenclatura = linhaNomenclatura;
        if ("sim".equalsIgnoreCase(acompanhaEquipamento)){
            this.acompanhaEquipamento = true;
        } else {
            this.acompanhaEquipamento = false;
        }

    }

    @Override
    public float calcularValorTotal() {
        if (isAcompanhaEquipamento()){
            return 0;
        } else {
            float total = getValor();
            total *= getQuantidade();
            return total;
        }
    }

    public int getLinhaNomenclatura() {
        return linhaNomenclatura;
    }

    public String getEquipamentoAlvo() {
        return equipamentoAlvo;
    }

    public String getFuncao() {
        return funcao;
    }

    public boolean isAcompanhaEquipamento() {
        return acompanhaEquipamento;
    }

    public void setEquipamentoAlvo(String equipamentoAlvo) {
        this.equipamentoAlvo = equipamentoAlvo;
    }

    @Override
    public String toString(){

        StringBuilder mensagem = new StringBuilder();
        mensagem.append(getFuncao());
        mensagem.append(";");
        if (getEquipamentoAlvo()!="".trim() || getEquipamentoAlvo()!=null){
            mensagem.append(getEquipamentoAlvo());
        }else{
            mensagem.append("Sem equipamento alvo");
        }
        mensagem.append(";");
        mensagem.append(isAcompanhaEquipamento()?"Vai com o equipamento": "Vendido a parte");
        mensagem.append(";");
        
        switch (getLinhaNomenclatura()){
            case 0:
                mensagem.append("Padrão");
                break;
            case 1:
                mensagem.append("Premium");
                break;
            case 2:
                mensagem.append("Econômica");
                break;
            case 3:
                mensagem.append("Remanufaturado");
                break;
        }

        return mensagem.toString();
    }
}
