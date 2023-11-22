package uniquindio.edu.co;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

class Enfrentamiento {
    private String equipoLocal;
    private String equipoVisitante;
    private String nombreJuez;
    private int golesLocal;
    private int golesVisitante;
    private LocalDateTime fechaHora;
    private EstadoEnfrentamiento estado;

    public Enfrentamiento(String equipoLocal, String equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fechaHora = LocalDateTime.now(); // Simulación de fechas para los partidos
        this.estado = EstadoEnfrentamiento.PENDIENTE;
        
    }

    
    public String obtenerFecha() {
        // Definir el formato deseado
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaHora.format(formatoFecha);
    }

    public void simular() {
        if (estado == EstadoEnfrentamiento.PENDIENTE) {
            Random golesL = new Random();
            Random golesV = new Random();
            this.golesLocal = golesL.nextInt(5);
            this.golesVisitante = golesV.nextInt(5);
            this.estado = EstadoEnfrentamiento.FINALIZADO;
        }
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getNombreJuez() {
        return nombreJuez;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public EstadoEnfrentamiento getEstado() {
        return estado;
    }

    public int getPuntosLocal() {
        return obtenerPuntos(golesLocal, golesVisitante);
    }

    public int getPuntosVisitante() {
        return obtenerPuntos(golesVisitante, golesLocal);
    }

    public String getResultado() {
        return equipoLocal + " vs " + equipoVisitante + ": " +
               golesLocal + "-" + golesVisitante + "     Estado: " + estado;
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

    public int calcularPuntosFinales() {
        return getPuntosLocal() + getPuntosVisitante();
    }

    @Override
    public String toString() {
        return "Partido entre " + equipoLocal + " y " + equipoVisitante + " - Fecha y Hora: " +  obtenerFecha();
    }
}
