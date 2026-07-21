package org.example.exception;

public class AgendaLlenaException extends RuntimeException {
    public AgendaLlenaException(){
        super("La capacidad esta FULL, actualiza o elimina algunos datos que ya no necesites");
    }

  public AgendaLlenaException(String message) {
    super(message);
  }
}
