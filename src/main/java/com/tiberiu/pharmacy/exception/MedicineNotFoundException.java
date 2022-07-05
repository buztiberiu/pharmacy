package com.tiberiu.pharmacy.exception;

public class MedicineNotFoundException extends Exception {

    public MedicineNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
