package org.example.util;

public class Validacion {
    public static boolean esTextoVacio(String texto){
        return texto == null || texto.isBlank();
    }

    public static boolean esTelefonoValido(String telefono){

        if (telefono == null) return false;

        String limpio = telefono.replaceAll("\\D", "");


        return limpio.length() >= 7 && limpio.length() <= 15;
    }

    public static boolean esEmailValido(String email){
        return email != null && email.contains("@");
    }
}
