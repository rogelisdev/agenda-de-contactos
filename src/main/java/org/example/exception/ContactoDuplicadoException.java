package org.example.exception;

public class ContactoDuplicadoException extends RuntimeException {

    public ContactoDuplicadoException(){
        super("El usuario ya existe, verifica e intenta nuevamente");
    }

    public ContactoDuplicadoException(String message) {
        super(message);
    }
}
