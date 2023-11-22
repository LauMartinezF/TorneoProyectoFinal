package uniquindio.edu.co;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class TestJueces {

    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(EquipoTest.class.getName());
    
    /*
     * Clase para probar el funcionamiento del metodo para determinar a cada juez en que partido le corresponde estar 
     */


      @Test
    public void obtenerPartidosPorJuezTest() {

        LOG.info("Inicio de prueba para saber que partido le corresponde estar a cada juez ");

        // Lista de equipos
        List<String> equipos = Arrays.asList("Tigres Negros", "Verdolaga", "Los canicas", "Milers");

        // Crear instancia de la clase Partidos
        Partidos partidos = new Partidos(equipos);

        // Crear instancia de un Juez
        Juez juez = new Juez("Jorge", "Cuellar", "3002526789", "jorgeCuellar234@gmail.com", "src141");

        // Llamar al método obtenerPartidosPorJuez
        List<Enfrentamiento> partidosDelJuez = partidos.obtenerPartidosPorJuez(juez);

        // Verificar que la lista no sea nula y realizar cualquier otra verificación necesaria
        assertNotNull(partidosDelJuez);

        // Imprimir información sobre los enfrentamientos asociados al juez
        for (Enfrentamiento enfrentamiento : partidosDelJuez) {
            LOG.info("El juez " + juez.getNombre() + " está asignado al enfrentamiento: " + enfrentamiento.toString());
        }

        LOG.info("Fin de prueba ");
      
    }
}