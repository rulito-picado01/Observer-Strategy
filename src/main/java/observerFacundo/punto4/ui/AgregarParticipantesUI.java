package observerFacundo.punto4.ui;

import observerFacundo.punto4.modelo.AplicacionRegistracionParticipantes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AgregarParticipantesUI extends JFrame {
    AplicacionRegistracionParticipantes aplicacion;
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private JTextField email;

    public AgregarParticipantesUI(AplicacionRegistracionParticipantes aplicacion) {
        this.aplicacion = aplicacion;
        setupUIComponents();
    }

    public void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.email = new JTextField(10);
        this.email.setText("");
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
        contentPane.add(new JLabel("Email: "));
        contentPane.add(email);
        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBotonCargar();
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() {
        String nombreStr = this.nombre.getText();
        String telefonoStr = this.telefono.getText();
        String regionStr = this.region.getText();
        String emailStr = this.email.getText();
        try {
            aplicacion.agregarParticipantes(nombreStr, telefonoStr, regionStr, emailStr);
            JOptionPane.showMessageDialog(this, "Participante agregado correctamente");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el participante: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
