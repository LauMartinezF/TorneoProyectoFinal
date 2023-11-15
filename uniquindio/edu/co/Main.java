package uniquindio.edu.co;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Jugador jugador = new Jugador("Carolina", "Perez", "@Gmail", "321581", LocalDate.of(2024, 8, 27), "Masculino");
        System.out.println(jugador.validarGeneroParaTorneo("MASCULINO"));
    }

    }
    

