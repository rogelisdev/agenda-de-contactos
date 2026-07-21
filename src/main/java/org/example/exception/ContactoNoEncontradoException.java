package org.example.exception;

public class ContactoNoEncontradoException extends RuntimeException {

    public ContactoNoEncontradoException(){
        super("El usuario no existe, intenta registrarlo");
    }


    public ContactoNoEncontradoException(String message) {
        super(message);
    }
}
