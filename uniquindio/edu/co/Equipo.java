package uniquindio.edu.co;

import java.util.ArrayList;

public class Equipo {

    private final String nombreEquipo;
    private final Persona representante;
    private ArrayList<Jugador> jugadores;
    private static ArrayList<Equipo> listaEquipos = new ArrayList<>();
    private ArrayList <String> nombresEquipos = new ArrayList<>();

    public Equipo (String nombreEquipo, Persona representante){
        
        this.nombreEquipo = nombreEquipo;
        this.representante = representante;
        this.jugadores = new ArrayList<>();

        listaEquipos.add(this);
    }

    // Método que toma una lista de equipos y devuelve una lista de nombres
    public ArrayList<String> obtenerNombresEquipos(ArrayList<Equipo> listaEquipos) {
        ArrayList<String> nombresEquipos = new ArrayList<>();

        // Iteras sobre la lista de equipos
        for (int i = 0; i < listaEquipos.size(); i++) {
            Equipo equipo = listaEquipos.get(i);
            nombresEquipos.add(equipo.getNombreEquipo());
        }

        return nombresEquipos;
    }
    
    public void registrarJugador(Jugador jugador){
        validarJugadorExistente(jugador);
        jugadores.add(jugador);
    }

    private void validarJugadorExistente(Jugador jugador) {
        boolean existeJugador = buscarJugador(jugador).isPresent();
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

    public ArrayList<String> getNombresEquipos() {
        return nombresEquipos;
    }

    public void setNombresEquipos(ArrayList<String> nombresEquipos) {
        this.nombresEquipos = nombresEquipos;
    }

    public static ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }


    public static void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        Equipo.listaEquipos = listaEquipos;
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



}