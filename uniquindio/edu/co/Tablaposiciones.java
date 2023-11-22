package uniquindio.edu.co;
import java.util.ArrayList;
import java.util.List;

class TablaPosiciones {
    private List<String> equipos;
    private List<Integer> puntosPorEquipo;
     private List<Integer> partidosGanados;
    private List<Integer> partidosPerdidos;
    private List<Integer> partidosEmpatados;

    public TablaPosiciones(List<String> equipos) {
        this.equipos = equipos;
        this.puntosPorEquipo = new ArrayList<>();
        this.partidosGanados = new ArrayList<>();
        this.partidosPerdidos = new ArrayList<>();
        this.partidosEmpatados = new ArrayList<>();

        for (int i = 0; i < equipos.size(); i++) {
            this.puntosPorEquipo.add(0);
            this.partidosGanados.add(0);
            this.partidosPerdidos.add(0);
            this.partidosEmpatados.add(0);
        }
    }

    public List<String> getEquipos() {
        return equipos;
    }


    public void setEquipos(List<String> equipos) {
        this.equipos = equipos;
    }


    public List<Integer> getPuntosPorEquipo() {
        return puntosPorEquipo;
    }


    public void setPuntosPorEquipo(List<Integer> puntosPorEquipo) {
        this.puntosPorEquipo = puntosPorEquipo;
    }


    public void actualizarPuntuacion(String equipo, int puntos) {
        int indiceEquipo = equipos.indexOf(equipo);
        if (indiceEquipo != -1) {
            int puntosActuales = puntosPorEquipo.get(indiceEquipo);
            puntosPorEquipo.set(indiceEquipo, puntosActuales + puntos);
        }
    }

    @Override
    public String toString() {
        StringBuilder tabla = new StringBuilder();
        tabla.append(String.format("%-20s %-10s %-10s %-10s %-10s\n", "Equipo", "Puntos", "Ganados", "Perdidos", "Empatados"));
        for (int i = 0; i < equipos.size(); i++) {
            tabla.append(String.format("%-20s %-10d %-10d %-10d %-10d\n",
                    equipos.get(i), puntosPorEquipo.get(i),
                    partidosGanados.get(i), partidosPerdidos.get(i), partidosEmpatados.get(i)));
        }
        return tabla.toString();
    }
}