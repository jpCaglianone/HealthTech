package com.example.healthtech.model.exception;

public class NomeInvalidoException extends Throwable {
    public NomeInvalidoException(String mensagem) {
        super("Nome inválido! " + mensagem);
    }
}
