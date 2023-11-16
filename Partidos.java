import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partidos {
    private String nombreEstadio;
    private String ubicacion;
    private LocalDate fechaEnfrentamiento;
    private ArrayList<Equipos> equipos;
    
    public Partidos(String nombreEstadio, String ubicacion, LocalDate fechaEnfrentamiento, ArrayList<Equipos> equipos) {
        this.nombreEstadio = nombreEstadio;
        this.ubicacion = ubicacion;
        this.fechaEnfrentamiento = fechaEnfrentamiento;
        this.equipos = equipos;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFechaEnfrentamiento() {
        return fechaEnfrentamiento;
    }

    public void setFechaEnfrentamiento(LocalDate fechaEnfrentamiento) {
        this.fechaEnfrentamiento = fechaEnfrentamiento;
    }

    public ArrayList<Equipos> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipos> equipos) {
        this.equipos = equipos;
    }

    public static List<String> generarPartidos(List<String> equipos) {
        List<String> combinaciones = new ArrayList<>();
        
        for (int i = 0; i < equipos.size() - 1; i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                String equipoLocal = equipos.get(i);
                String equipoVisitante = equipos.get(j);
                Random ran1 = new Random(); 
                Random ran2 = new Random(); 
                int golesLocal = ran1.nextInt(5);
                int golesVisitante = ran2.nextInt(5);
                String combinacion = "Partido: " + equipoLocal + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante;
                combinaciones.add(combinacion);
            }
        }
        return combinaciones;
    }

    public static void simularPartidos(List<String> combinaciones) {
        for (String combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }
}


