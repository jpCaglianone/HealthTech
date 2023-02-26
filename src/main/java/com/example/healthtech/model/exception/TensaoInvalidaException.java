package com.example.healthtech.model.exception;

public class TensaoInvalidaException extends Throwable {
    public TensaoInvalidaException(StringBuilder mensagem) {
        super(String.valueOf(mensagem));
    }
}
