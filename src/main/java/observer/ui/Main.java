package observer.ui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().start();
            }
        });
    }

    private void start() {
        new CajeroUI(new MonitorDeCuenta()).iniciar();
    }
}
