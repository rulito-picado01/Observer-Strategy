package strategyFacundo.punto3;

public class Main {
    public static void main(String[] args) {
        Producto libro = new Producto(30, new CalculoPrecioLibro());
        Producto medicina = new Producto(330, new CalculadoraDePreciosMedicina());
        Producto alimento = new Producto(130, new CalculadoraDePreciosAlimentos());
        Producto otro = new Producto(130, new CalculadoraPreciosDemasArticulos());
        System.out.println(libro.precioFinal());
        System.out.println(medicina.precioFinal());
        System.out.println(alimento.precioFinal());
        System.out.println(otro.precioFinal());
    }
}
