package strategyFacundo.punto1;

public class CalculadorEnvio {

    private EstrategiaEnvio estrategia;

    public void setEstrategia(EstrategiaEnvio estrategia) {
        this.estrategia = estrategia;

    }

    public double calcular(String destino, double pesoKg) {
        return estrategia.calcularCosto(pesoKg, destino);
    }
}
