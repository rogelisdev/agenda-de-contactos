package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AgendaView extends JFrame {


    //Tabla
    String[] columnas = {"Nombre", "Apellido", "Telefono", "Correo"};
    public DefaultTableModel model = new DefaultTableModel(columnas, 0);
    public JTable table = new JTable(model);

    public JScrollPane scroll = new JScrollPane(table);

    //Botones
    public JButton buttonAgregar = new JButton("Agregar");
    public JButton buttonActualizar = new JButton("Actualizar");
    public JButton buttonEliminar = new JButton("Eliminar");


    //Labels
    public JLabel labelNombre = new JLabel("Nombre: ");
    public JLabel labelApellido = new JLabel("Apellido: ");
    public JLabel labelTelefono = new JLabel("Telefono: ");
    public JLabel labelEmail = new JLabel("Correo: ");
    public JLabel labelTitulo = new JLabel("REGISTRO");
    public JLabel labelContactos = new JLabel("CONTACTOS");

    //Inputs
    public JTextField nombre = new JTextField();
    public JTextField apellido = new JTextField();
    public JTextField telefono = new JTextField();
    public JTextField email = new JTextField();
    public JTextField buscarNombre = new JTextField();
    public JTextField buscarApellido = new JTextField();
    public JButton buttonBuscar = new JButton("Buscar");


    //Menu
    public JMenuBar menuBar = new JMenuBar();
    public JMenu menu = new JMenu("Menu");
    public JMenuItem crear = new JMenuItem("Crear");
    public JMenuItem actualizar = new JMenuItem("Actualizar");
    public JMenuItem eliminar = new JMenuItem("Eliminar");
    public JMenuItem buscar = new JMenuItem("Buscar");
    public JButton buttonExpandir = new JButton("Expandir Agenda");

    public AgendaView(){
        init();
    }

    public void init(){

        setTitle("Agenda de Contactos");
        setSize(950,800);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 247, 250)); // gris claro elegante
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(52, 73, 94));
        table.getTableHeader().setForeground(Color.WHITE);

        // MENU
        menu.add(crear);
        menu.add(actualizar);
        menu.add(eliminar);
        menu.add(buscar);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // LABELS
        labelNombre.setBounds(35,90,70,30);
        labelApellido.setBounds(35,130,70,30);
        labelTelefono.setBounds(35,170,70,30);
        labelEmail.setBounds(35,210,70,30);

        labelTitulo.setBounds(100,20,200,40);
        labelContactos.setBounds(580,20,200,40);

        labelTitulo.setFont(new Font("Serif", Font.BOLD, 24));
        labelContactos.setFont(new Font("Serif", Font.BOLD, 24));

        // INPUTS
        nombre.setBounds(100, 90, 200, 30);
        apellido.setBounds(100, 130, 200, 30);
        telefono.setBounds(100, 170, 200, 30);
        email.setBounds(100, 210, 200, 30);
        Color bordeColor = new Color(180, 180, 180);

        nombre.setBorder(BorderFactory.createLineBorder(bordeColor, 1, true));
        apellido.setBorder(BorderFactory.createLineBorder(bordeColor, 1, true));
        telefono.setBorder(BorderFactory.createLineBorder(bordeColor, 1, true));
        email.setBorder(BorderFactory.createLineBorder(bordeColor, 1, true));
        buscarNombre.setBorder(BorderFactory.createLineBorder(bordeColor, 1, true));
        buscarApellido.setBorder(BorderFactory.createLineBorder(bordeColor, 1, true));

        // TABLA
        scroll.setBounds(450, 75, 400, 200);

        // BOTONES
        buttonAgregar.setBounds(200,260,100,25);
        buttonActualizar.setBounds(750,280,100,25);
        buttonEliminar.setBounds(640,280,100,25);
        buttonExpandir.setBounds(100, 450, 180, 30);
        // Colores botones
        buttonAgregar.setBackground(new Color(46, 204, 113)); // verde
        buttonActualizar.setBackground(new Color(52, 152, 219)); // azul
        buttonEliminar.setBackground(new Color(231, 76, 60)); // rojo
        buttonBuscar.setBackground(new Color(155, 89, 182)); // morado
        buttonExpandir.setBackground(new Color(241, 196, 15)); // amarillo

// Texto blanco
        buttonAgregar.setForeground(Color.WHITE);
        buttonActualizar.setForeground(Color.WHITE);
        buttonEliminar.setForeground(Color.WHITE);
        buttonBuscar.setForeground(Color.WHITE);

// Estilo botones
        buttonAgregar.setFocusPainted(false);
        buttonActualizar.setFocusPainted(false);
        buttonEliminar.setFocusPainted(false);
        buttonBuscar.setFocusPainted(false);
        buttonExpandir.setFocusPainted(false);
        add(buttonExpandir);

        // ADD
        add(nombre);
        add(apellido);
        add(telefono);
        add(email);

        add(labelNombre);
        add(labelApellido);
        add(labelTelefono);
        add(labelEmail);
        add(labelTitulo);
        add(labelContactos);

        add(buttonAgregar);
        add(buttonActualizar);
        add(buttonEliminar);

        add(scroll);

        // BUSCADOR
        buscarNombre.setBounds(100, 320, 200, 30);
        buscarApellido.setBounds(100, 360, 200, 30);
        buttonBuscar.setBounds(200, 400, 100, 25);

        add(new JLabel("Buscar Nombre:")).setBounds(10, 320, 120, 30);
        add(buscarNombre);

        add(new JLabel("Buscar Apellido:")).setBounds(10, 360, 120, 30);
        add(buscarApellido);

        add(buttonBuscar);
    }
}