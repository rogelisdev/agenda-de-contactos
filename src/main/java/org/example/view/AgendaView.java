package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AgendaView {
    JFrame frame = new JFrame("Agenda de Contactos");

    //Tabla
    String[] columnas = {"Nombre", "Apellido", "Telefono", "Correo"};
    DefaultTableModel model = new DefaultTableModel(columnas, 0);
    JTable table = new JTable(model);

    JScrollPane scroll = new JScrollPane(table);

    //Botones
    JButton buttonAgregar = new JButton("Agregar");
    JButton buttonActualizar = new JButton("Actualizar");
    JButton buttonEliminar = new JButton("Eliminar");

    //Textos de la ventana
    JLabel labelNombre = new JLabel("Nombre: ");
    JLabel labelApellido = new JLabel("Apellido: ");
    JLabel labelTelefono = new JLabel("Telefono: ");
    JLabel labelEmail = new JLabel("Correo: ");
    JLabel labelTitulo = new JLabel("REGISTRO");
    JLabel labelContactos = new JLabel("CONTACTOS");

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

           //Texto
           labelNombre.setBounds(35,90,70,30);
           labelApellido.setBounds(35,130,70,30);
           labelTelefono.setBounds(35,170,70,30);
           labelEmail.setBounds(35,210,70,30);

           labelTitulo.setBounds(100,20,200,40);
           labelContactos.setBounds(580,20,200,40);


           //Campos de texto
           nombre.setBounds(100, 90, 200, 30);
           apellido.setBounds(100, 130, 200, 30);
           telefono.setBounds(100, 170, 200, 30);
           email.setBounds(100, 210, 200, 30);

           //Tabla contactos
           scroll.setBounds(450, 75, 400, 200);

           //Botones
           buttonAgregar.setBounds(200,260,100,25);
           buttonActualizar.setBounds(750,280,100,25);
           buttonEliminar.setBounds(640,280,100,25);

           //Fuentes
           labelTitulo.setFont(new Font("Serif", Font.BOLD, 24));
           labelContactos.setFont(new Font("Serif", Font.BOLD, 24));

           frame.add(nombre);
           frame.add(apellido);
           frame.add(telefono);
           frame.add(email);
           frame.add(labelNombre);
           frame.add(labelApellido);
           frame.add(labelTelefono);
           frame.add(labelEmail);
           frame.add(labelTitulo);
           frame.add(labelContactos);

           frame.add(buttonAgregar);
           frame.add(buttonActualizar);
           frame.add(buttonEliminar);

           frame.add(scroll);

           //Configuración del frame
           frame.setLayout(null);
           frame.setVisible(true);

           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       } catch (RuntimeException e) {
           throw new RuntimeException(e);
       }
    }
}
