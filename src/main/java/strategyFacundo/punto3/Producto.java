package strategyFacundo.punto3;

public class Producto {
    private double precio;
    private CalculadorDePrecios calculadorDePrecios;

    public Producto(double precio, CalculadorDePrecios calculadorDePrecios) {
        this.precio = precio;
        this.calculadorDePrecios = calculadorDePrecios;
    }

    public double precioFinal() {
        return calculadorDePrecios.calcularPrecio(precio);
    }

}
