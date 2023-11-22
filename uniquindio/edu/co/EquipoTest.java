package uniquindio.edu.co;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class EquipoTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(EquipoTest.class.getName());


    /**
     * @author: Laura Florez, Jacobo Luengas , Daniela Muñoz 
     * Se hace la prueba para probar el metodo registrar Jugador de la clase Equipo
     * 
     */


    @Test
    public void registrarEquipoTest(){
        LOG.info("Inicio de prueba para registrar equipo: ");
        //Se almacenan los datos de prueba 
        Persona representante=new Persona("Maicol", "Buitrago", "3215873454", "maicolBuitrago@gmail.com");
        Jugador jugador=new Jugador("Luis", "Morales", "luisMorales23@gmail.com", "321512321", LocalDate.of(2005, 8, 22), "Masculino");
        Equipo equipo=new Equipo("Tigres Negros",representante);

        equipo.registrarJugador(jugador);

        //Verificacion de datos , si la iformacion no esta correcta sale una excepcion 
        assertTrue(equipo.getJugadores().contains(jugador));
        assertEquals(1, equipo.getJugadores().size());
        LOG.info("Fin de prueba el jugador "+jugador.getNombre()+" "+jugador.getApellido()+ " ha sido registrado con exito");

    }


   

        

}


    
    