import java.time.LocalDate;

public class Torneo {
    private byte cantMaxEquipos;
    private String nombreTorneo;
    private byte limEdad;
    private LocalDate fechaInicioIns;
    private LocalDate fechaCierreIns;
    private int valorInscripcion;
    private LocalDate fechaInicioTorneo;
    
    public Torneo(byte cantMaxEquipos, String nombreTorneo, byte limEdad, LocalDate fechaInicioIns,
            LocalDate fechaCierreIns, int valorInscripcion, LocalDate fechaInicioTorneo) {
        this.cantMaxEquipos = cantMaxEquipos;
        this.nombreTorneo = nombreTorneo;
        this.limEdad = limEdad;
        this.fechaInicioIns = fechaInicioIns;
        this.fechaCierreIns = fechaCierreIns;
        this.valorInscripcion = valorInscripcion;
        this.fechaInicioTorneo = fechaInicioTorneo;
    }

    //GETTERS
    public byte getCantMaxEquipos() {
        return cantMaxEquipos;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public byte getLimEdad() {
        return limEdad;
    }

    public LocalDate getFechaInicioIns() {
        return fechaInicioIns;
    }

    public LocalDate getFechaCierreIns() {
        return fechaCierreIns;
    }

    public int getValorInscripcion() {
        return valorInscripcion;
    }

    public LocalDate getFechaInicioTorneo() {
        return fechaInicioTorneo;
    }

    //SETTERS
    public void setCantMaxEquipos(byte cantMaxEquipos) {
        this.cantMaxEquipos = cantMaxEquipos;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public void setLimEdad(byte limEdad) {
        this.limEdad = limEdad;
    }

    public void setFechaInicioIns(LocalDate fechaInicioIns) {
        this.fechaInicioIns = fechaInicioIns;
    }

    public void setFechaCierreIns(LocalDate fechaCierreIns) {
        this.fechaCierreIns = fechaCierreIns;
    }

    public void setValorInscripcion(int valorInscripcion) {
        this.valorInscripcion = valorInscripcion;
    }

    public void setFechaInicioTorneo(LocalDate fechaInicioTorneo) {
        this.fechaInicioTorneo = fechaInicioTorneo;
    }

    

}
