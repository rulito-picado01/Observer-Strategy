package strategyFacundo.punto2;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaNacimiento(FormatoFecha formato) {
        return formato.formatearFecha(fechaNacimiento);
    }
}
