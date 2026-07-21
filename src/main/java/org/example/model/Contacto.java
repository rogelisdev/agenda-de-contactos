package org.example.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Contacto {
    private static final Pattern TELEFONO_PATTERN =
            Pattern.compile("^(\\+\\d{1,3}[ ]?)?\\d{3}([ ]?\\d{3}){2}$");
    private static final Pattern CORREO_PATTERN =
            Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    /* public Contacto() {
    } */

    /* public Contacto(String nombre, String apellido, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    } */

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
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        this.apellido = apellido.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !CORREO_PATTERN.matcher(email.trim()).matches()) {
            throw new IllegalArgumentException(
                    "Formato de correo inválido. Ejemplo válido: 'usuario@dominio.com'.");
        }
        this.email = email.trim();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || !TELEFONO_PATTERN.matcher(telefono.trim()).matches()) {
            throw new IllegalArgumentException(
                    "Formato de teléfono inválido. Ejemplos válidos: '+34 600 000 000' o '600000000'.");
        }
        this.telefono = telefono.trim();
    }

    /* public String toString() {
        return nombre + " " + apellido + " - " + telefono + " - " + email;
    } */

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
