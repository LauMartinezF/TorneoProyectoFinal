package uniquindio.edu.co;

public class Persona {
    
    private String nombre;
    private String apellido;
    private String email;
    private String numCelular;


    // Método constructor clase persona
    public Persona (String nombre, String apellido, String email, String numCelular){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numCelular = numCelular;
    }
    

    // Getters y setters clase persona
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }
}
