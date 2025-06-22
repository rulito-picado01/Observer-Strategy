package observerFacundo.punto4.bd;

import observerFacundo.punto4.modelo.ListaParticipantes;
import observerFacundo.punto4.modelo.Observador;
import observerFacundo.punto4.modelo.Observer;
import observerFacundo.punto4.modelo.Participante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ParticipanteBd extends Observador implements ListaParticipantes {
    private final String url = "jdbc:mysql://localhost:3306/Participantes";
    private final String user = "root";
    private final String password = "";
    private Connection dbConn;

    public ParticipanteBd(List<Observer> observadores) {
        super(observadores);
    }

    @Override
    public void addParticipante(Participante p) {

        if (p.cualEsTuNombre().isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un nombre");
        }
        if (p.cualEsTuNumTelefono().isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un teléfono");
        }
        if (!validarTelefono(p.cualEsTuNumTelefono())) {
            throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!p.cualEsTuReguion().equals("China") && !p.cualEsTuReguion().equals("US")
                && !p.cualEsTuReguion().equals("Europa")) {
            throw new IllegalArgumentException("Región desconocida. Las conocidas son: China, US, Europa");
        }

        try (Connection conn = conectar();
             PreparedStatement st = conn
                     .prepareStatement(
                             "INSERT INTO participantes(nombre, telefono, region, email) VALUES (?, ?, ?, ?)")) {
            st.setString(1, p.cualEsTuNombre());
            st.setString(2, p.cualEsTuNumTelefono());
            st.setString(3, p.cualEsTuReguion());
            st.setString(4, p.cualEsTuEmail());
            st.executeUpdate();
            notificar(p.cualEsTuEmail());
        } catch (SQLException e) {
            throw new RuntimeException("no se pudo conectar a la base de datos ", e);
        }

    }

    @Override
    public Participante recuperarParticipante(Participante p) {
        Participante p1;
        try (Connection conn = conectar();
             PreparedStatement st = conn.prepareStatement("SELECT * FROM participantes WHERE nombre =?")) {
            st.setString(1, p.cualEsTuNombre());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String region = rs.getString("region");
                String email = rs.getString("email");
                p1 = new Participante(nombre, telefono, region, email);
                return p1;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("no se pudo conectar a la base de datos ", e);
        }

    }

    @Override
    public ArrayList<Participante> getParticipantes() {
        Participante p;
        try (Connection conn = conectar();
             PreparedStatement st = conn.prepareStatement("SELECT * FROM participantes")) {
            ResultSet rs = st.executeQuery();
            ArrayList<Participante> participantes = new ArrayList<>();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String region = rs.getString("region");
                String email = rs.getString("email");
                p = new Participante(nombre, telefono, region, email);
                participantes.add(p);
                st.close();
            }
            return participantes;
        } catch (SQLException e) {
            throw new RuntimeException("no se pudo conectar a la base de datos ", e);

        }
    }

    private Connection conectar() {
        try {
            this.dbConn = DriverManager.getConnection(url, user, password);
            return this.dbConn;
        } catch (SQLException e) {
            throw new RuntimeException("no se pudo conectar");
        }

    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

}
