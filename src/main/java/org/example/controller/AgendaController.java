package org.example.controller;

import org.example.model.Contacto;
import org.example.service.AgendaService;
import org.example.service.ResultadoOperacion;
import org.example.view.AgendaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AgendaController {

    private final AgendaView vista;
    private final AgendaService service;

    public AgendaController(AgendaView vista, AgendaService service) {
        this.vista = vista;
        this.service = service;

        initEventos();
        actualizarTabla();
    }

    private void initEventos() {

        vista.buttonAgregar.addActionListener(e -> agregar());
        vista.buttonEliminar.addActionListener(e -> eliminar());
        vista.buttonActualizar.addActionListener(e -> modificar());
        vista.buttonExpandir.addActionListener(e -> expandir());

        vista.buttonBuscar.addActionListener(e -> buscar());

        // Cargar datos al seleccionar fila
        vista.table.getSelectionModel().addListSelectionListener(e -> {
            int fila = vista.table.getSelectedRow();

            if (fila != -1) {
                vista.nombre.setText(vista.table.getValueAt(fila, 0).toString());
                vista.apellido.setText(vista.table.getValueAt(fila, 1).toString());
                vista.telefono.setText(vista.table.getValueAt(fila, 2).toString());
                vista.email.setText(vista.table.getValueAt(fila, 3).toString());
            }
        });
    }

    // AGREGAR
    private void agregar() {

        ResultadoOperacion resultado = service.agregarContacto(
                vista.nombre.getText(),
                vista.apellido.getText(),
                vista.email.getText(),
                vista.telefono.getText()
        );

        mostrarMensaje(resultado);
        actualizarTabla();
        limpiarCampos();
    }

    // ELIMINAR
    private void eliminar() {

        int fila = vista.table.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un contacto");
            return;
        }

        String nombre = vista.table.getValueAt(fila, 0).toString();
        String apellido = vista.table.getValueAt(fila, 1).toString();

        ResultadoOperacion resultado = service.eliminarContacto(nombre, apellido);

        mostrarMensaje(resultado);
        actualizarTabla();
    }

    // ACTUALIZAR (teléfono)
    private void modificar() {

        int fila = vista.table.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un contacto");
            return;
        }

        String nombre = vista.table.getValueAt(fila, 0).toString();
        String apellido = vista.table.getValueAt(fila, 1).toString();

        String nuevoTelefono = vista.telefono.getText();

        ResultadoOperacion resultado = service.modificarTelefono(nombre, apellido, nuevoTelefono);

        mostrarMensaje(resultado);
        actualizarTabla();
        limpiarCampos();
    }

    // BUSCAR
    private void buscar() {

        String nombre = vista.buscarNombre.getText();
        String apellido = vista.buscarApellido.getText();

        String resultado = service.buscarContacto(nombre, apellido);

        JOptionPane.showMessageDialog(null,
                resultado != null ? "Teléfono: " + resultado : "Contacto no encontrado");
    }

    // ACTUALIZAR TABLA
    private void actualizarTabla() {

        DefaultTableModel modelo = vista.model;
        modelo.setRowCount(0);

        List<Contacto> contactos = service.listarContactos();

        for (Contacto c : contactos) {
            modelo.addRow(new Object[]{
                    c.getNombre(),
                    c.getApellido(),
                    c.getTelefono(),
                    c.getEmail()
            });
        }
    }

    // LIMPIAR
    private void limpiarCampos() {
        vista.nombre.setText("");
        vista.apellido.setText("");
        vista.telefono.setText("");
        vista.email.setText("");
    }

    private void mostrarMensaje(ResultadoOperacion resultado) {
        JOptionPane.showMessageDialog(null, resultado.getMensaje());
    }

    private void expandir() {

        String input = JOptionPane.showInputDialog("Nueva capacidad:");

        if (input == null || input.isBlank()) return;

        try {
            int nuevaCapacidad = Integer.parseInt(input);

            ResultadoOperacion resultado = service.expandirAgenda(nuevaCapacidad);

            mostrarMensaje(resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido");
        }
    }
}