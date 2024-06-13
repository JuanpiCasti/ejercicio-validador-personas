package org.example.exceptions;

public class ServicioRenaperException extends RuntimeException implements ICustomException {
    public ServicioRenaperException(String mensaje) {
        super(mensaje);
    }


    @Override
    public String getCustomMessage() {
        return "Error repnaper: " + super.getMessage();
    }

    @Override
    public String getCustomStackTrace() {
        return "Erorr renaper: " + super.getStackTrace();
    }
}
