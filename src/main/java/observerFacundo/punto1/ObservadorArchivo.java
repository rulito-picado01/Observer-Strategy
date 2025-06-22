package observerFacundo.punto1;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ObservadorArchivo implements Observador{


    private String archivo;

    public ObservadorArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void actualizar(String temperatura) {
        try (PrintWriter out = new PrintWriter(new FileWriter(archivo, true))) {
            out.println(LocalDateTime.now() + " - Temperatura: " + temperatura);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
