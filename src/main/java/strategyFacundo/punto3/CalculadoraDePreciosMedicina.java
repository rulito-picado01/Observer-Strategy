package strategyFacundo.punto3;

public class CalculadoraDePreciosMedicina implements CalculadorDePrecios {
    @Override
    public double calcularPrecio(double precio) {
        double impuesto = 0;
        double descuento = 0;
        boolean envioGratis = false;

        if (precio > 50) {
            descuento = 0.1;
        }
        if (precio > 100) {
            envioGratis = true;
        }
        double total = precio * (1 + impuesto) * (1 - descuento);
        if (envioGratis) {
            total -= 10;
        }
        return total;
    }

}