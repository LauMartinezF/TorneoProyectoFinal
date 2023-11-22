package uniquindio.edu.co;

/**
 * Autores:Laura Milena Flores , Jacobo Luengas , Daniela Muñoz 
 * Fecha:10/11/2023
 */

public class Persona  {

    //Atributos de la clase 
    private String nombre;
    private String apellido;
    private String celular;
    private String email;


    //Constructor de la clase Persona con todos sus atributos 
    public Persona(String nombre, String apellido, String celular, String email) {
        assert nombre != null && !nombre.isEmpty() : "El nombre es requerido";//Excpcion si el nombre es nulo o esta vacio 
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
    }

    //Metodos get y set para poder acceder a estos atributos privados 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }


    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
