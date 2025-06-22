package observerFacundo.punto1;

public class ObservadorConsola implements Observador {

    @Override
    public void actualizar(String temperatura) {
        System.out.println("Lectura: " + temperatura);

        try {
            double tempValor = Double.parseDouble(temperatura.split(" ")[0]);
            if (tempValor < 12) {
                System.out.println("Hace frio, se encenderá la caldera.");
            } else if (tempValor > 17) {
                System.out.println("Hace calor, se encenderá el aire acondicionado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error al leer temperatura: " + temperatura);
        }
    }
}
