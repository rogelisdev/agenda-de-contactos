package org.example.view;

import javax.swing.*;

public class AgendaView {
    JFrame frame = new JFrame("Agenda de Contactos");

    //Distintas vistas
    JPanel panel = new JPanel();
    JPanel  panel2 = new JPanel();

    //Botones
    JButton buttonAgregar = new JButton("Agregar");
    JButton buttonActualizar = new JButton("Actualizar");
    JButton buttonEliminar = new JButton("Eliminar");

    //Titulos
    JLabel labelNombre = new JLabel("Nombre: ");
    JLabel labelApellido = new JLabel("Apellido: ");
    JLabel labelTelefono = new JLabel("Telefono: ");
    JLabel labelEmail = new JLabel("Correo");

    //Campos de texto para el usuario
    JTextField nombre = new JTextField();
    JTextField apellido = new JTextField();
    JTextField telefono = new JTextField();
    JTextField email = new JTextField();

    //Menu
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem crear = new JMenuItem("Crear");
    JMenuItem actualizar = new JMenuItem("Actualizar");
    JMenuItem eliminar = new JMenuItem("Eliminar");
    JMenuItem buscar = new JMenuItem("Buscar");

    public void vista(){
       try {
           frame.setSize(950,800);

           menu.add(crear);
           menu.add(actualizar);
           menu.add(eliminar);
           menu.add(buscar);
           menuBar.add(menu); //Barra del menu
           frame.setJMenuBar(menuBar); //Agregar la barra del menu

           nombre.setBounds(70, 100, 200, 30);
           apellido.setBounds(70, 130, 200, 30);
           telefono.setBounds(70, 160, 200, 30);
           email.setBounds(70, 190, 200, 30);

           frame.add(nombre);
           frame.add(apellido);
           frame.add(telefono);
           frame.add(email);

           //Configuración del frame
           frame.setLayout(null);
           frame.setVisible(true);

           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       } catch (RuntimeException e) {
           throw new RuntimeException(e);
       }
    }
}
