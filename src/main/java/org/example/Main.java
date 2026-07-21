package org.example;

import org.example.controller.AgendaController;
import org.example.model.Agenda;
import org.example.service.AgendaService;
import org.example.view.AgendaView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Modelo
            Agenda agenda = new Agenda(10);

            // Service
            AgendaService service = new AgendaService(agenda);

            // Vista
            AgendaView vista = new AgendaView();

            // Controller (conecta todo)
            new AgendaController(vista, service);

            // Mostrar ventana
            vista.setVisible(true);
        });
    }
}