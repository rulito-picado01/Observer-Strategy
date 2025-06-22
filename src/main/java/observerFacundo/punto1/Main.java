package observerFacundo.punto1;

public class Main {
    public static void main(String[] args) {
        String apiKey = "af9c6f75700e28100713173c1bfac931";

        WhatherChanelService clima = new Clima(apiKey);
        Medidor medidor = new Medidor(clima);


        Observador archivo = new ObservadorArchivo("temperaturas.txt");
        Observador consola = new ObservadorConsola();

        medidor.agregarObservador(archivo);
        medidor.agregarObservador(consola);


        medidor.leerTemperatura();
    }
}
