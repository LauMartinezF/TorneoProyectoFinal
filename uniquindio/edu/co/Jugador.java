package uniquindio.edu.co;

import java.time.LocalDate;

/*
 * Autores:Laura Flores , Jacobo Luengas , Daniela Muñoz 
 * Fecha:
 * Licencia:
 * Esta clase Heredara de la clase persona algunos atributos y sera la encargada de validar la informacion 
 * de cada uno de los jugadores antes de registrarlos en el torneo 
 */

public class Jugador extends Persona {

    //Atributos de la clase 

    private LocalDate fechaNacimiento;
    private String genero;
   
    //Constructor 

       public Jugador(String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento, String genero) {
        super(nombre, apellido, email, celular);
        assert fechaNacimiento != null : "La fecha de nacimiento es requerida";
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }


    // Métodos getter y setter para acceder a los atributos
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

 

  //Metodo para validar el genero de la persona es acorde al del torneo 

    public String validarGeneroParaTorneo(String generoTorneo) {
        boolean esValido = generoTorneo.equalsIgnoreCase(genero);
        String mensaje = "El género es " + (esValido ? "válido" : "inválido") + " para participar en este tipo de torneo.";
        return mensaje;
    }

}