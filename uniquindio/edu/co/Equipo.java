package uniquindio.edu.co;

import java.util.ArrayList;

public class Equipo {

    private final String nombreEquipo;
    private final Persona representante;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Partidos> enfrentamientosEquipo;

    public Equipo (String nombreEquipo, Persona representante){
        this.nombreEquipo = nombreEquipo;
        this.representante = representante;
        this.jugadores = new ArrayList<>();
        this.enfrentamientosEquipo = new ArrayList<>();
    }

    public Equipo (String nombreEquipo){
        this.nombreEquipo = nombreEquipo;
        this.representante = null;
        this.jugadores = new ArrayList<>();
        this.enfrentamientosEquipo = new ArrayList<>();
    }
    
    //metodo para registrar en una lista todos los enfrentamientos de un equipo, 
    //primero verifica mediante un foreach si el equipo esta en cada uno de los enfrentamientos de la lista
    //si el equipo esta en el enfrentamiento, ya sea en el equipo 1 o en el equipo 2,
    //se añadira a la lista de enfrentamientos de dicho equipo 
    public void enfrentamientosPorEquipo(ArrayList<Partidos> enfrentamientos) {
        for (int i = 0; i < enfrentamientos.size(); i++) {
           Partidos enfrentamiento = enfrentamientos.get(i);
            if (enfrentamiento.getEquipo1().getNombreEquipo().equals(this.nombreEquipo) ||
             enfrentamiento.getEquipo1().getNombreEquipo().equals(this.nombreEquipo)) {
                this.enfrentamientosEquipo.add(enfrentamiento);
            }
        }
    }
    
    public void registrarJugador(Jugador jugador){
        validarJugadorExistente(jugador);
        jugadores.add(jugador);
    }

    private void validarJugadorExistente(Jugador jugador) {
        Jugador jugadorEncontrado = buscarJugador(jugador);
        boolean existeJugador = jugadorEncontrado != null;
        assert !existeJugador : "El jugador ya esta registrado";
    }

    public Jugador buscarJugador(Jugador jugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            if (j.getNombre().equals(jugador.getNombre()) && j.getApellido().equals(jugador.getApellido())) {
                return j; // Devuelve el jugador si coincide en nombre y apellido
            }
        }
        return null; // Retorna null si no se encuentra ningún jugador que coincida
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public Persona getRepresentante() {
        return representante;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Partidos> getEnfrentamientosEquipo() {
        return enfrentamientosEquipo;
    }

    

}