package uniquindio.edu.co;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.logging.Logger;


public class TestJueces {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(TesteEnfrentamientosEquipos.class.getName());

    // Se hace la prueba para verificar que a cada equipo se le asigna a un contrincante

    @Test
    public void simularPartidosTest() {
        LOG.info("Inicio de prueba para asignacion de jueces por partido ");

        // Lista de equipos
        List<String> equipos = Arrays.asList("Tigres Negros", "Verdolaga", "Los canicas", "Milers");

        // Crear instancia de la clase Partidos
        Partidos partidos = new Partidos(equipos);

        // Ejecutar el método para simular los enfrentamientos
        partidos.simularPartidos();

        // Obtener los enfrentamientos utilizando el método de la clase Partidos
        List<Partidos.Enfrentamiento> enfrentamientos = partidos.getEnfrentamientos();

        // Mostrar los enfrentamientos en un cuadro de diálogo utilizando JOptionPane
        mostrarEnfrentamientos(enfrentamientos);

        // Verificar que los enfrentamientos no sean nulos
        assertNotNull(enfrentamientos);

        LOG.info("Fin de prueba ");
    }

    private void mostrarEnfrentamientos(List<Partidos.Enfrentamiento> enfrentamientos) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        StringBuilder infoEnfrentamientos = new StringBuilder("\nInformación de Enfrentamientos\n");
        for (Partidos.Enfrentamiento enfrentamiento : enfrentamientos) {
            infoEnfrentamientos.append("Equipo Local: ").append(enfrentamiento.equipoLocal).append("\n");
            infoEnfrentamientos.append("Equipo Visitante: ").append(enfrentamiento.equipoVisitante).append("\n");
            infoEnfrentamientos.append("Estadio: ").append(enfrentamiento.estadio).append("\n");

            // Formatear la fecha solo si es un objeto de tipo LocalDate
            if (enfrentamiento.fecha instanceof LocalDate) {
                infoEnfrentamientos.append("Fecha: ").append(dateFormat.format(enfrentamiento.fecha)).append("\n");
            }
    
            infoEnfrentamientos.append("Juez: ").append(enfrentamiento.juez).append("\n\n");

            // Formatear la fecha solo si es un objeto de tipo LocalDate
            if (enfrentamiento.fecha instanceof LocalDate) {
                infoEnfrentamientos.append("Fecha: ").append(dateFormat.format(enfrentamiento.fecha)).append("\n");
            }
    
            infoEnfrentamientos.append("Juez: ").append(enfrentamiento.juez).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, infoEnfrentamientos.toString());
    }
}

 
    
    