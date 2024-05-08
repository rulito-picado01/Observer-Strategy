package ui;

import observer.model.CuentaBancaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CajeroUI {

    private SwingMonitorDeCuenta monitor;

    CajeroUI(SwingMonitorDeCuenta monitor) {
        this.monitor = monitor;
    }

    public void iniciar() {
        CuentaBancaria cuenta = new CuentaBancaria(0);

        JFrame dialog = new JFrame("Cajero Automático");
        JButton button = new JButton("Depositar $1000");
        button.setFont(new Font("Dialog", Font.PLAIN, 20));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Deposito y en este mismo action listener muestro en la pantalla el nuevo saldo
                //Que pasa si tambien quiero que salga en una consola?
                //o si quiero mandar un email al gerente del banco en los casos donde el saldo supere los 10 millones
                //¿ ?
                cuenta.depositar(1000);
                monitor.nuevoMonto(cuenta.saldo());
            }
        });

        dialog.add(button);
        dialog.setSize(250, 150);
        dialog.setLocation(600, 200);
        dialog.setVisible(true);

    }

}
