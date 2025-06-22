package strategyFacundo.punto3;

public class CalculadoraDePreciosAlimentos implements CalculadorDePrecios {

    public double calcularPrecio(double precio) {
        double impuesto = 0.5;
        double descuento = 0;
        boolean envioGratis = false;

        if (precio > 100) {
            descuento = 0.15;
        }
        if (precio > 200) {
            envioGratis = true;
        }
        double total = precio * (1 + impuesto) * (1 - descuento);
        if (envioGratis) {
            total -= 10;
        }
        return total;
    }
}