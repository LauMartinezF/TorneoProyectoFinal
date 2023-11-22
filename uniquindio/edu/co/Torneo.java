package uniquindio.edu.co;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

public class Torneo {
    
    private byte cantMaxEquipos;
    private String nombreTorneo;
    private byte limEdad;
    private LocalDate fechaInicioIns;
    private LocalDate fechaCierreIns;
    private int valorInscripcion;
    private LocalDate fechaInicioTorneo;
    private List<String> equipos;
    private TipoTorneo tipoTorneo;
    
    
    
    public Torneo(byte cantMaxEquipos, String nombreTorneo, byte limEdad, LocalDate fechaInicioIns,
            LocalDate fechaCierreIns, int valorInscripcion, LocalDate fechaInicioTorneo, TipoTorneo tipoTorneo) {
        this.cantMaxEquipos = cantMaxEquipos;
        this.nombreTorneo = nombreTorneo;
        this.limEdad = limEdad;
        this.fechaInicioIns = fechaInicioIns;
        this.fechaCierreIns = fechaCierreIns;
        this.valorInscripcion = valorInscripcion;
        this.fechaInicioTorneo = fechaInicioTorneo;
        this.tipoTorneo = tipoTorneo;
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

    public void ingresarDatosTorneo(){
        String fecha1;
        String fecha2;
        String fecha3;
        String[] tiposTorneo = {TipoTorneo.LOCAL.name(), TipoTorneo.REGIONAL.name(), TipoTorneo.NACIONAL.name(), TipoTorneo.MUNDIAL.name()};
        String tipoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de torneo:", "Tipo de Torneo",
                JOptionPane.QUESTION_MESSAGE, null, tiposTorneo, tiposTorneo[0]);
        tipoTorneo = TipoTorneo.valueOf(tipoSeleccionado);
        cantMaxEquipos = Byte.parseByte(JOptionPane.showInputDialog("Ingrese el numero maximo de equipos: "));
        nombreTorneo = JOptionPane.showInputDialog("Ingrese el nombre del torneo: ");
        limEdad = Byte.parseByte(JOptionPane.showInputDialog("Ingrese el limite de edad para el torneo: "));
        fecha1 = JOptionPane.showInputDialog("Ingrese la fecha de inicio de las inscripciones (Formato: yyyy-MM-dd): ");
        DateTimeFormatter conversion = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        fechaInicioIns = LocalDate.parse(fecha1, conversion);
        do {
            fecha2 = JOptionPane.showInputDialog("Ingrese la fecha de cierre de las inscripciones (Formato: yyyy-MM-dd): ");
            DateTimeFormatter conversion2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            fechaCierreIns = LocalDate.parse(fecha2, conversion2);
            if (fechaCierreIns.isBefore(getFechaInicioIns()) || fechaCierreIns.isEqual(getFechaInicioIns()) ) {
                JOptionPane.showMessageDialog(null, "La fecha de cierre de inscripciones debe ser posterior a la fecha de inicio.");
            } else {
                setFechaCierreIns(fechaCierreIns);
                break;
            }
        } while (true);
        valorInscripcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la inscripcion: "));
        do {
            fecha3 = JOptionPane.showInputDialog("Ingrese la fecha de inicio del torneo (Formato: yyyy-MM-dd): ");
            DateTimeFormatter conversion3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            fechaInicioTorneo = LocalDate.parse(fecha3, conversion3);
            if(fechaInicioTorneo.isBefore(getFechaInicioIns()) || fechaInicioTorneo.isBefore(getFechaCierreIns()) || fechaInicioTorneo.isEqual(getFechaInicioIns()) || fechaInicioTorneo.isEqual(getFechaCierreIns())){
                JOptionPane.showMessageDialog(null, "La fecha de inicio de torneo debe ser posterior a las fechas de inicio y cierre de inscripciones");
            } else {
                setFechaCierreIns(fechaCierreIns);
                break;
            }
        }while (true);
}

    public void cambiarAtributos(){
        int opcion;
        do{
        String menu2;
        menu2 = 
            "-----------------------------------------------"+"\n"+
            "ATRIBUTOS"+"\n"+"\n"+
            "1. Cantidad de equipos"+"\n"+
            "2. Nombre del torneo"+"\n"+
            "3. Limite de edad"+"\n"+
            "4. Fecha del inicio de inscripciones"+"\n"+
            "5. Fecha del cierre de inscripciones"+"\n"+
            "6. Valor de la inscripcion"+"\n"+
            "7. Fecha de inicio del torneo"+"\n"+"\n";

    String opcionMenu2 = JOptionPane.showInputDialog(null, menu2 + "\nSeleccione una opción:");
        opcion = Integer.parseInt(opcionMenu2);
        switch (opcion) {
            case 1:
                setCantMaxEquipos(Byte.parseByte(JOptionPane.showInputDialog("Ingrese el numero maximo de equipos: ")));
                break;
            case 2:
                setNombreTorneo(JOptionPane.showInputDialog("Ingrese el nuevo nombre del torneo: "));
                break;
            case 3:
                setLimEdad(Byte.parseByte(JOptionPane.showInputDialog("Ingrese el limite de edad para el torneo: ")));
                break;
            case 4:
                String fecha1 = JOptionPane.showInputDialog("Ingrese la nueva fecha de inicio de inscripciones (Formato: yyyy-MM-dd): ");  
                setFechaInicioIns(LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                break;
            case 5:
                do {
                    String fecha2 = JOptionPane.showInputDialog("Ingrese la nueva fecha de cierre de inscripciones (Formato: yyyy-MM-dd): ");
                    setFechaCierreIns(LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    if(fechaCierreIns.isBefore(getFechaInicioIns()) || fechaCierreIns.isEqual(getFechaInicioIns())){
                        JOptionPane.showMessageDialog(null, "La fecha de cierre de inscripciones debe ser posterior a la fecha de inicio.");
                    } else {
                        setFechaCierreIns(fechaCierreIns);
                        break;
                    }
                } while (true);
                break;
            case 6:
                setValorInscripcion(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor actualizado de la inscripcion: ")));
                break;
            case 7:
            do {
                String fecha3 = JOptionPane.showInputDialog("Ingrese la nueva fecha de inicio de torneo (Formato: yyyy-MM-dd): ");
                setFechaInicioTorneo(LocalDate.parse(fecha3, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                if(fechaInicioTorneo.isBefore(getFechaInicioIns()) || fechaInicioTorneo.isBefore(getFechaCierreIns()) || fechaInicioTorneo.isEqual(getFechaInicioIns()) || fechaInicioTorneo.isEqual(getFechaCierreIns())){
                    JOptionPane.showMessageDialog(null, "La fecha de inicio de torneo debe ser posterior a las fechas de inicio y cierre de inscripciones");
                } else {
                    setFechaInicioTorneo(fechaInicioTorneo);
                    break;
                }
            }while (true);
                break;
            default:
                System.out.println("Opción no valida");
        }
        }while (opcion < 1 || opcion > 7);

    }

    public String toString() {
        String infoTorneo;
        infoTorneo = "\n" + "-----------------------" + "\n" + "Cantidad maxima de equipos: " + cantMaxEquipos + "\n"
                + "Nombre del torneo: " + nombreTorneo + "\n" + "Limite de edad: " + limEdad + "\n"
                + "Fecha inicio de inscripciones: " + fechaInicioIns + "\n" + "Fecha cierre de inscripciones: "
                + fechaCierreIns + "\n" + "Valor de inscripcion: " + valorInscripcion + "\n"
                + "Fecha inicio de torneo: " + fechaInicioTorneo + "\n" + "Tipo de Torneo: " + tipoTorneo + "\n"
                + "--------------------------" + "\n";
        String info = JOptionPane.showInputDialog(null, infoTorneo);
        return info;
    }


    public List<String> getEquipos() {
        return equipos;
    }



    public void setEquipos(List<String> equipos) {
        this.equipos = equipos;
    }

}
