package uniquindio.edu.co;

public class Juez extends Persona{

    //Atributos de la clase 

    private String licencia;

    //Constructor 
    public Juez(String nombre, String apellido, String celular, String email,String licencia) {
        super(nombre, apellido, celular, email);
        this.licencia=licencia;
    }


    //Metodos Get y Set 
    public String getLicencia() {
        return licencia;
    }


    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    

  



    


    
}
