package com.projetoBackEnd.sghss.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String mensagem) {
        super(mensagem);
    }

    public BusinessException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
