package strategyFacundo.punto3;

public class CalculoPrecioLibro implements CalculadorDePrecios {
    @Override
    public double calcularPrecio(double precio) {
        double impuesto = 0.1;
        double descuento = 0.1;
        boolean envioGratis = precio > 100;
        double total = precio * (1 + impuesto) * (1 - descuento);
        if (envioGratis) {
            total -= 10;
        }

        return total;
    }

}