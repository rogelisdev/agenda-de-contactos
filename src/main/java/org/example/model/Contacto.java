package org.example.model;

import org.example.util.Validacion;

import java.util.Objects;

public class Contacto {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Contacto(Long id, String nombre, String apellido, String email, String telefono) {
        this(nombre, apellido, email, telefono);
        this.id = id;
    }

    public Contacto(String nombre, String apellido, String email, String telefono) {
        setNombre(nombre);
        setApellido(apellido);
        setEmail(email);
        setTelefono(telefono);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (Validacion.esTextoVacio(nombre)) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (Validacion.esTextoVacio(apellido)) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        this.apellido = apellido.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (!Validacion.esEmailValido(email)) {
            throw new IllegalArgumentException(
                    "Formato de correo inválido. Ejemplo: usuario@dominio.com");
        }

        // normalizar
        this.email = email.trim().toLowerCase();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        if (!Validacion.esTelefonoValido(telefono)) {
            throw new IllegalArgumentException(
                    "Formato inválido. Ingrese un teléfono válido (ej: 3001234567)");
        }

        // guardar limpio (solo números)
        this.telefono = telefono.replaceAll("\\D", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;

        Contacto contacto = (Contacto) o;

        return nombre.equalsIgnoreCase(contacto.nombre)
                && apellido.equalsIgnoreCase(contacto.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    @Override
    public String toString() {
        return apellido + ", " + nombre + " - " + telefono + " - " + email;
    }
}