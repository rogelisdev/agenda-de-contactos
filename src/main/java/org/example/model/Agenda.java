package org.example.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Agenda {

    private static final int CAPACIDAD_POR_DEFECTO = 10;

    private final List<Contacto> contactos;
    private final int capacidadMaxima;

    public Agenda() {
        this(CAPACIDAD_POR_DEFECTO);
    }

    public Agenda(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor a 0.");
        }
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    public void añadirContacto(Contacto c) {
        if (c == null) {
            throw new IllegalArgumentException("El contacto no puede ser nulo.");
        }
        if (agendaLlena()) {
            throw new IllegalStateException("La agenda está llena. No hay espacio disponible.");
        }
        if (existeContacto(c)) {
            throw new IllegalArgumentException("Ya existe un contacto con ese nombre y apellido.");
        }
        contactos.add(c);
    }

    public boolean existeContacto(Contacto c) {
        return contactos.contains(c); // usa equals() sobrescrito
    }

    public List<Contacto> listarContactos() {
        List<Contacto> copia = new ArrayList<>(contactos);
        copia.sort(Comparator
                .comparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER));
        return copia;
    }

    public String buscarContacto(String nombre, String apellido) {
        return buscarContactoInterno(nombre, apellido)
                .map(Contacto::getTelefono)
                .orElse(null);
    }

    public boolean eliminarContacto(Contacto c) {
        return contactos.remove(c); // usa equals() sobrescrito
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        Contacto existente = buscarContactoInterno(nombre, apellido)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe un contacto con ese nombre y apellido."));
        existente.setTelefono(nuevoTelefono); // lanza IllegalArgumentException si el formato es inválido
    }

    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    public int espaciosLibres() {
        return capacidadMaxima - contactos.size();
    }

    private Optional<Contacto> buscarContactoInterno(String nombre, String apellido) {
        return contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre)
                        && c.getApellido().equalsIgnoreCase(apellido))
                .findFirst();
    }
}