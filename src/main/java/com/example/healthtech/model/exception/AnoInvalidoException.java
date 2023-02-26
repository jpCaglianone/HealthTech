package com.example.healthtech.model.exception;

public class AnoInvalidoException extends Throwable {
    public AnoInvalidoException(String mensagem) {
        super("Ano inválido! " + mensagem);
    }
}
