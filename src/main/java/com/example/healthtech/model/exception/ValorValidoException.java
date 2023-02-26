package com.example.healthtech.model.exception;

public class ValorValidoException extends Throwable {
    public ValorValidoException (String mensagem){
        super("Valor inválido! " + mensagem);
    }
}
