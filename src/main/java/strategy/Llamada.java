package strategy;

enum TipoLlamada {
    NACIONAL,
    INTERNACIONAL
}

class Llamada {
    public TipoLlamada tipo;
    public double duracion;

    public Llamada(TipoLlamada tipo, double duracion) {
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public double calcularCosto() {
        double costo = 0;
        boolean promocion = false;

        if (tipo == TipoLlamada.NACIONAL) {
            costo = 1.1 * duracion;
            if (duracion > 30) {
                promocion = true;
            }
        } else if (tipo == TipoLlamada.INTERNACIONAL) {
            costo = 1.5 * duracion;
            if (duracion > 20) {
                promocion = true;
            }
        }

        if (promocion) {
            costo = costo - (costo * 0.05);
        }
        return costo;
    }
}

