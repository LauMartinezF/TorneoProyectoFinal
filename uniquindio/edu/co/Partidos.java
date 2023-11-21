package uniquindio.edu.co;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Partidos {

    private List<String> equipos;
    private List<Integer> puntuaciones;

    public Partidos(List<String> equipos) {
        this.equipos = new ArrayList<>(equipos);
        this.puntuaciones = new ArrayList<>(Collections.nCopies(equipos.size(), 0));
    }

    public void simularTorneo() {
        List<String> combinaciones = generarPartidos();
        simularPartidos(combinaciones);
    }

    public void imprimirTablasFinales() { 
        imprimirResultadosFinales();
    }

    public void campeon() { 
        imprimirCampeonTorneo();
    }

    private List<String> generarPartidos() {
        List<String> combinaciones = new ArrayList<>();

        for (int i = 0; i < equipos.size() - 1; i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                String equipoLocal = equipos.get(i);
                String equipoVisitante = equipos.get(j);
                Random golesL = new Random();
                Random golesV = new Random();
                int golesLocal = golesL.nextInt(5);
                int golesVisitante = golesV.nextInt(5);
                int puntosLocal = obtenerPuntos(golesLocal, golesVisitante);
                int puntosVisitante = obtenerPuntos(golesVisitante, golesLocal);

                actualizarPuntuacion(equipoLocal, puntosLocal);
                actualizarPuntuacion(equipoVisitante, puntosVisitante);

                String combinacion = "Partido: " + equipoLocal + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante + "  ";
                combinaciones.add(combinacion);
            }
        }

        return combinaciones;
    }

    private void simularPartidos(List<String> combinaciones) {
        String mensaje = "\nEncuentros:\n";
        for (String combinacion : combinaciones) {
            mensaje += combinacion + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void actualizarPuntuacion(String equipo, int puntos) {
        int indice = equipos.indexOf(equipo);
        puntuaciones.set(indice, puntuaciones.get(indice) + puntos);
    }

    private int obtenerPuntos(int golesEquipo1, int golesEquipo2) {
        if (golesEquipo1 > golesEquipo2) {
            return 3;
        } else if (golesEquipo1 < golesEquipo2) {
            return 0;
        } else {
            return 1;
        }
    }

    private void imprimirResultadosFinales() {
        // Ordenar los equipos y puntuaciones en orden descendente
        ordenarListasEnOrdenDescendente();
        String mensaje = "\nResultados Finales del Torneo\n";
        for (int i = 0; i < equipos.size(); i++) {
            mensaje += equipos.get(i) + ": " + puntuaciones.get(i) + " puntos\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void imprimirCampeonTorneo() {
        ordenarListasEnOrdenDescendente();
        String mensaje = "\n¡Campeón del Torneo\n";
        int posicion = 0;
        mensaje += equipos.get(posicion) + ": " + puntuaciones.get(posicion) + " puntos";
        JOptionPane.showMessageDialog(null, mensaje);
    }



    private void ordenarListasEnOrdenDescendente() {
        Collections.sort(equipos, (a, b) -> Integer.compare(puntuaciones.get(equipos.indexOf(b)), puntuaciones.get(equipos.indexOf(a))));
        Collections.sort(puntuaciones, Collections.reverseOrder());
    }
}

