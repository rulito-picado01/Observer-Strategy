package strategyFacundo.punto1;

public class CorreoArgentino implements EstrategiaEnvio {
    @Override
    public double calcularCosto(double peso, String destino) {
        if (destino.equalsIgnoreCase("capital federal")) {
            return 500;
        } else {
            int distancia = obtenerDistancia(destino);
            return 800 + (5 * distancia);
        }

    }

    private int obtenerDistancia(String destino) {

        if (destino.equalsIgnoreCase("La Plata")) return 60;
        if (destino.equalsIgnoreCase("Mar del Plata")) return 400;
        return 200;
    }
}
