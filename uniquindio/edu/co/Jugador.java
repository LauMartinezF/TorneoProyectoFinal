package uniquindio.edu.co;

import java.time.LocalDate;
import java.time.Period;

/*
 * Autores:
 * Fecha:
 * Licencia:
 * Esta clase Heredara de la clase persona algunos atributos y sera la encargada de validar la informacion 
 * de cada uno de los jugadores antes de registrarlos en el torneo 
 */

public class Jugador extends Persona extends GeneroTorneoEnum {

    //Atributo de la clase Jugador 
    private  LocalDate fechaNacimiento;
    private String genero;


    //Constructor 
    public Jugador(String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento,String genero) {
        super(nombre, apellido, email, celular);
        assert fechaNacimiento != null : "La fecha de nacimiento es requerida";//Excepcion si no ponen la fecha de nacimiento 
        this.fechaNacimiento = fechaNacimiento;
    }

    //Metodo get y set para poder acceder a estos atributos privados desde otras clases 
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;

    }


        public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    /**
     * Permite calcula la edad que tiene un jugador en una fecha dada.
     * @param fecha Fecha contra la cual se desea calcular la edad del jugador.
     * @return La edad que tiene en años en la fecha dada.
     */

    public byte calcularEdad(LocalDate fecha){
    return (byte) Period.between(fechaNacimiento, fecha).getYears();
    }

 
       public String nombreCompleto() {
        return getNombre()+ " "+getApellido();
       }


       public String validarGeneroParaTorneo(String generoTorneo) {
        boolean esValido=false;
        if (genero.equalsIgnoreCase(generoTorneo)) {
            esValido=true;
            String mensaje="El genero es valido para que pueda participar en ese tipo de torneo "+esValido+"Valido";
            return mensaje;
            
        }
    }

   
    }

    
      


    
    




    
}
