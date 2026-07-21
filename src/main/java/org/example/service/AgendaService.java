package org.example.service;

import org.example.model.Agenda;
import org.example.model.Contacto;

import java.util.List;

public class AgendaService {

    private final Agenda agenda;

    public AgendaService(Agenda agenda) {
        this.agenda = agenda;
    }

    public ResultadoOperacion agregarContacto(String nombre, String apellido, String email, String telefono) {
        try {
            Contacto contacto = new Contacto(nombre, apellido, email, telefono);
            agenda.añadirContacto(contacto);
            return ResultadoOperacion.exito("Contacto agregado correctamente.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResultadoOperacion.error(e.getMessage());
        }
    }

    public ResultadoOperacion eliminarContacto(String nombre, String apellido) {
        try {
            Contacto contacto = new Contacto(nombre, apellido, "placeholder@x.com", "600000000");
            boolean eliminado = agenda.eliminarContacto(contacto);
            return eliminado
                    ? ResultadoOperacion.exito("Contacto eliminado correctamente.")
                    : ResultadoOperacion.error("No se encontró un contacto con ese nombre y apellido.");
        } catch (IllegalArgumentException e) {
            return ResultadoOperacion.error(e.getMessage());
        }
    }

    public ResultadoOperacion modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        try {
            agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
            return ResultadoOperacion.exito("Teléfono actualizado correctamente.");
        } catch (IllegalArgumentException e) {
            return ResultadoOperacion.error(e.getMessage());
        }
    }

    public String buscarContacto(String nombre, String apellido) {
        return agenda.buscarContacto(nombre, apellido);
    }

    public List<Contacto> listarContactos() {
        return agenda.listarContactos();
    }

    public boolean agendaLlena() {
        return agenda.agendaLlena();
    }

    public int espaciosLibres() {
        return agenda.espaciosLibres();
    }
}