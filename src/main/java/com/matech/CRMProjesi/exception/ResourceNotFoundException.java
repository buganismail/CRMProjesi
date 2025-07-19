package com.matech.CRMProjesi.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mesaj) {
        super(mesaj);
    }
}