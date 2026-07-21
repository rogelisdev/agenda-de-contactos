package org.example.util;

public class Validacion {
    public static boolean esTextoVacio(String texto){
        return texto == null || texto.isBlank();
    }

    public static boolean esTelefonoValido(String telefono){
        return telefono != null && telefono.matches("\\d{7,15}");
    }

    public static boolean esEmailValido(String email){
        return email != null && email.contains("@");
    }
}
