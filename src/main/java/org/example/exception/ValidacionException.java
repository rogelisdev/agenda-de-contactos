package org.example.exception;

public class ValidacionException extends RuntimeException {

    public ValidacionException(){
        super("Validacion necesaria");
    }

    public ValidacionException(String message) {
        super(message);
    }
}
