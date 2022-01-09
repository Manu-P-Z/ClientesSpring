package com.manu.ClientesSpring.gui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
@Component
public class Ventana {

    //Elementos de la ventana(swing)

    private JPanel panel1;


    private JLabel textNombre;
    private JLabel textApellidios;
    private JLabel textCategory;
    private JLabel textLimiteCredito;
    private JLabel getTextCreationDate;

    public JTextField textFieldId;
    public JTextField textFieldNombre;
    public JTextField textFieldApellidos;
    public JTextField textFieldCategory;
    public JTextField textFieldLimiteCredito;
    public JTextField getTextFieldCreationDate;
    public JTextField textFieldBuscar;

    public JButton nuevoButton;
    public JButton guardarButton;
    public JButton modificarButton;
    public JButton eliminarButton;
    public JButton buscarButton;

    public JTextPane buscarTextPane;
    private JTextField TextFieldCreationDate;
    private JLabel textCreationDate;

    @Autowired
    public Ventana() {
        JFrame frame = new JFrame("Clientes");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}
