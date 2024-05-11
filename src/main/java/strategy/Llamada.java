package strategy;

enum TipoLlamada {
    NACIONAL,
    INTERNACIONAL
}

class Llamada {
    public TipoLlamada tipo;
    public double duracion; // en minutos

    public Llamada(TipoLlamada tipo, double duracion) {
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public double calcularCosto() {
        double costo = 0;
        boolean promocion = false;

        if (tipo == TipoLlamada.NACIONAL) {
            costo = 0.05 * duracion; // $0.05 por minuto
            if (duracion > 30) {
                promocion = true; // Si la llamada supera los 30 minutos, se aplica una promoción
            }
        } else if (tipo == TipoLlamada.INTERNACIONAL) {
            costo = 0.1 * duracion; // $0.10 por minuto
            if (duracion > 20) {
                promocion = true; // Si la llamada supera los 20 minutos, se aplica una promoción
            }
        }

        if (promocion) {
            costo *= 0.9; // Se aplica un descuento del 10% si se cumple la promoción
        }
        return costo;
    }
}

