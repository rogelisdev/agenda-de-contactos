package org.example.view;

import javax.swing.*;

public class AgendaView extends JFrame{

    JFrame frame = new JFrame();
    JButton button = new JButton();
    JLabel label = new JLabel();
    JPanel panel = new JPanel();

    void vistaAgenda(){
        try{

            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);


        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
