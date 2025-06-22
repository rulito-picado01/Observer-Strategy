package strategyFacundo.punto3;

public class CalculadoraPreciosDemasArticulos implements CalculadorDePrecios {
    @Override
    public double calcularPrecio(double precio) {
        double impuesto = 0.15;
        double descuento = 0;
        boolean envioGratis = false;

        if (precio > 50) {
            descuento = 0.05;
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
