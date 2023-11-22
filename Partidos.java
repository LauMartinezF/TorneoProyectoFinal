import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.JOptionPane;

public class Partidos {
    private List<String> equipos;
    private List<Integer> puntuaciones;
    private List<Enfrentamiento> enfrentamientos;

    public Partidos(List<String> equipos) {
        this.equipos = equipos;
        this.puntuaciones = new ArrayList<>();
        this.enfrentamientos = new ArrayList<>();
        generarPuntuacionesIniciales();
    }

    private void generarPuntuacionesIniciales() {
        for (int i = 0; i < equipos.size(); i++) {
            puntuaciones.add(0);
        }
    }

    public void simularTorneo() {
        simularPartidos();
        imprimirResultadosFinales();
        imprimirCampeonTorneo();
        imprimirInfoEnfrentamientos();
    }

    private void simularPartidos() {
        for (int i = 0; i < equipos.size() - 1; i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                // Simulación de puntos y otros detalles
                int puntosLocal = (int) (Math.random() * 5);
                int puntosVisitante = (int) (Math.random() * 5);

                // Información adicional
                String estadio = "Estadio " + (i + j + 1);
                LocalDate fecha = generarFechaAleatoria();
                String juez = "Juez " + (i + j + 1);

                puntuaciones.set(i, puntuaciones.get(i) + puntosLocal);
                puntuaciones.set(j, puntuaciones.get(j) + puntosVisitante);

                // Registro del enfrentamiento
                Enfrentamiento enfrentamiento = new Enfrentamiento(equipos.get(i), equipos.get(j), puntosLocal,
                        puntosVisitante, EstadoEnfrentamiento.FINALIZADO, estadio, fecha, juez);
                enfrentamientos.add(enfrentamiento);
            }
        }
    }

    private LocalDate generarFechaAleatoria() {
        // Fecha fija
        LocalDate fechaFija = LocalDate.parse("2023-11-11", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Agrega hasta 30 días aleatorios
        int diasAleatorios = (int) (Math.random() * 45); // 30 días de rango original + 15 días adicionales
        return fechaFija.plusDays(diasAleatorios);
    }

    public void imprimirResultadosFinales() {
        ordenarListasEnOrdenDescendente();
        String mensaje = "\nResultados Finales del Torneo\n";
        for (int i = 0; i < equipos.size(); i++) {
            mensaje += equipos.get(i) + ": " + puntuaciones.get(i) + " puntos\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void imprimirCampeonTorneo() {
        ordenarListasEnOrdenDescendente();
        String mensaje = "\n¡Campeón del Torneo!\n";
        int posicion = 0;
        mensaje += equipos.get(posicion) + ": " + puntuaciones.get(posicion) + " puntos";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void imprimirInfoEnfrentamientos() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        StringBuilder infoEnfrentamientos = new StringBuilder("\nInformación de Enfrentamientos\n");
        for (Enfrentamiento enfrentamiento : enfrentamientos) {
            infoEnfrentamientos.append("Equipo Local: ").append(enfrentamiento.equipoLocal).append("\n");
            infoEnfrentamientos.append("Equipo Visitante: ").append(enfrentamiento.equipoVisitante).append("\n");
            infoEnfrentamientos.append("Puntos Local: ").append(enfrentamiento.puntosLocal).append("\n");
            infoEnfrentamientos.append("Puntos Visitante: ").append(enfrentamiento.puntosVisitante).append("\n");
            infoEnfrentamientos.append("Estado: ").append(enfrentamiento.estado).append("\n");
            infoEnfrentamientos.append("Estadio: ").append(enfrentamiento.estadio).append("\n");
    
            // Formatear la fecha solo si es un objeto de tipo LocalDate
            if (enfrentamiento.fecha instanceof LocalDate) {
                infoEnfrentamientos.append("Fecha: ").append(dateFormat.format(enfrentamiento.fecha)).append("\n");
            }
    
            infoEnfrentamientos.append("Juez: ").append(enfrentamiento.juez).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, infoEnfrentamientos.toString());
    }

    private void ordenarListasEnOrdenDescendente() {
        Collections.sort(equipos, (a, b) -> Integer.compare(puntuaciones.get(equipos.indexOf(b)),
                puntuaciones.get(equipos.indexOf(a))));
        Collections.sort(puntuaciones, Collections.reverseOrder());
    }

    private static class Enfrentamiento {
        private String equipoLocal;
        private String equipoVisitante;
        private int puntosLocal;
        private int puntosVisitante;
        private EstadoEnfrentamiento estado;
        private String estadio;
        private LocalDate fecha;
        private String juez;

        public Enfrentamiento(String equipoLocal, String equipoVisitante, int puntosLocal, int puntosVisitante,
                EstadoEnfrentamiento estado, String estadio, LocalDate fecha2, String juez) {
            this.equipoLocal = equipoLocal;
            this.equipoVisitante = equipoVisitante;
            this.puntosLocal = puntosLocal;
            this.puntosVisitante = puntosVisitante;
            this.estado = estado;
            this.estadio = estadio;
            this.fecha = fecha2;
            this.juez = juez;
        }
    }
}