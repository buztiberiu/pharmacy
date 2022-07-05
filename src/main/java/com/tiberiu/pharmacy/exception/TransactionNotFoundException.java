package com.tiberiu.pharmacy.exception;

public class TransactionNotFoundException extends Exception {

    public TransactionNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
