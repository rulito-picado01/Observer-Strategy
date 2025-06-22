package observerFacundo.punto4.main;

import observerFacundo.punto4.bd.ParticipanteBd;
import observerFacundo.punto4.mail.EnvioDeMailConcursantes;
import observerFacundo.punto4.modelo.AplicacionRegistracionParticipantes;
import observerFacundo.punto4.ui.AgregarParticipantesUI;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        launchApplication();
    }

    private static void launchApplication() {
        try {
            ParticipanteBd aplicacionBd = new ParticipanteBd(List.of(new EnvioDeMailConcursantes()));
            AplicacionRegistracionParticipantes AplicacionRegistracionParticipantes = new AplicacionRegistracionParticipantes(
                    aplicacionBd);
            AgregarParticipantesUI UIpar = new AgregarParticipantesUI(AplicacionRegistracionParticipantes);
            UIpar.setupUIComponents();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
