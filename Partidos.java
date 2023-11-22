import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import javax.swing.JOptionPane;

public class Partidos {

    private List<Enfrentamiento> enfrentamientos;
    private TablaPosiciones tablaPosiciones;

    public Partidos(List<String> equipos) {
        this.enfrentamientos = new ArrayList<>();
        this.tablaPosiciones = new TablaPosiciones(equipos);
        generarPartidos(equipos);
    }

    public void simularTorneo() {
        simularPartidos();
        actualizarTablaPosiciones();
    }

    public void imprimirTablasFinales() {
        imprimirResultadosFinales();
        imprimirTablaPosiciones();
    }

    public void campeon() {
        imprimirCampeonTorneo();
    }

    private void generarPartidos(List<String> equipos) {
        for (int i = 0; i < equipos.size() - 1; i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                String equipoLocal = equipos.get(i);
                String equipoVisitante = equipos.get(j);
                Enfrentamiento enfrentamiento = new Enfrentamiento(equipoLocal, equipoVisitante);
                enfrentamientos.add(enfrentamiento);
            }
        }
    }

    private void simularPartidos() {
        String mensaje = "\nEncuentros:\n";
        for (Enfrentamiento enfrentamiento : enfrentamientos) {
            mensaje += enfrentamiento.toString() + "\n";
            enfrentamiento.simular();
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void actualizarTablaPosiciones() {
        for (Enfrentamiento enfrentamiento : enfrentamientos) {
            String equipoLocal = enfrentamiento.getEquipoLocal();
            String equipoVisitante = enfrentamiento.getEquipoVisitante();
            int puntosLocal = enfrentamiento.getPuntosLocal();
            int puntosVisitante = enfrentamiento.getPuntosVisitante();

            tablaPosiciones.actualizarPuntuacion(equipoLocal, puntosLocal);
            tablaPosiciones.actualizarPuntuacion(equipoVisitante, puntosVisitante);
        }
    }

    private void imprimirResultadosFinales() {
        // Ordenar los enfrentamientos por fecha y hora
        Collections.sort(enfrentamientos, (a, b) -> a.getFechaHora().compareTo(b.getFechaHora()));

        String mensaje = "\nResultados Finales del Torneo\n";
        for (Enfrentamiento enfrentamiento : enfrentamientos) {
            mensaje += enfrentamiento.getResultado() + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void imprimirTablaPosiciones() {
        String mensaje = "\nTabla de Posiciones\n";
        mensaje += tablaPosiciones.toString();
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void imprimirCampeonTorneo() {
        // Ordenar los enfrentamientos por fecha y hora
        Collections.sort(enfrentamientos, (a, b) -> a.getFechaHora().compareTo(b.getFechaHora()));

        String mensaje = "\n¡Campeón del Torneo!\n";
        Enfrentamiento campeon = enfrentamientos.get(0);
        mensaje += campeon.getResultado();
        JOptionPane.showMessageDialog(null, mensaje);
    }

    
}