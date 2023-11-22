package uniquindio.edu;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import uniquindio.edu.co.Partidos;
import uniquindio.edu.co.Torneo;

public class Menu {
    public static void main(String[] args) {
        int opcion;
        List<Torneo> listaTorneos = new ArrayList<>();
        Partidos simulador = null;
        do{
        String menu;
        menu = 
            "-------------------------------------------"+"\n"+
            "MENU"+"\n"+"\n"+
            "1. INGRESAR DATOS DEL TORNEO\n" +
            "2. MODIFICAR DATOS DEL TORNEO\n" +
            "3. MOSTRAR INFO DEL TORNEO\n" +
            "4. MOSTRAR ENCUENTROS\n" +
            "5. MOSTRAR RESULTADOS\n" +
            "6. CAMPEON TORNEO\n" +
            "7. SALIR"+"\n";

        String opcionMenu = JOptionPane.showInputDialog(null, menu + "\nSeleccione una opción:");

        opcion = Integer.parseInt(opcionMenu);
        switch (opcion) {
            
            case 1:
                Torneo torneo = new Torneo((byte) 0, "", (byte) 0, null, null, 0, null);
                torneo.ingresarDatosTorneo();
                listaTorneos.add(torneo);
                break;
            case 2:
                if (listaTorneos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay torneos para modificar");
                break;
                }
                modificarDatosTorneo(listaTorneos);
                break;
            case 3:
                if (listaTorneos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay torneos por mostrar");
                break;
                }
                mostrarInfoTodosTorneos(listaTorneos);
                break;
                case 4:
                if (listaTorneos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay torneos para simular");
                    break;
                }
            
                // Mostrar los torneos disponibles para elegir
                StringBuilder torneosDisponibles = new StringBuilder("Seleccione el torneo para simular:\n");
                for (int i = 0; i < listaTorneos.size(); i++) {
                    torneosDisponibles.append(i + 1).append(". ").append(listaTorneos.get(i).getNombreTorneo()).append("\n");
                }
            
                int indiceTorneoSimulacion = Integer.parseInt(JOptionPane.showInputDialog(torneosDisponibles.toString())) - 1;
            
                if (indiceTorneoSimulacion >= 0 && indiceTorneoSimulacion < listaTorneos.size()) {
                    Torneo torneoSimulacion = listaTorneos.get(indiceTorneoSimulacion);
            
                    // Obtener la lista de equipos para simular y establecerla en el torneo
                    List<String> equiposParaSimular = obtenerEquiposParaSimular(torneoSimulacion.getCantMaxEquipos());
                    torneoSimulacion.setEquipos(equiposParaSimular);
            
                    // Crear un nuevo simulador con la lista de equipos del torneo seleccionado
                    simulador = new Partidos(equiposParaSimular);
            
                    // Simular el torneo
                    simulador.simularTorneo();
            
                } else {
                    JOptionPane.showMessageDialog(null, "Índice de torneo no válido.");
                }
                break;
                case 5:
                if (listaTorneos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay torneos para simular");
                    break;
                }
                simulador.imprimirTablasFinales();
                break;
            case 6:
                if (listaTorneos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay torneos para simular");
                    break;
                }
                simulador.campeon();
            case 7:
                System.out.println("Vuelva pronto!");
            default:
                System.out.println("Opción no valida");
        }
        }while (opcion!=8);

    }

    private static List<String> obtenerEquiposParaSimular(int limEquipos) {
        List<String> equipos = new ArrayList<>();
        int cantidadEquipos;
        do {
            cantidadEquipos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de equipos a simular:"));
    
            if (cantidadEquipos > limEquipos) {
                JOptionPane.showMessageDialog(null, "La cantidad de equipos es invalida.");
            }
        } while (cantidadEquipos > limEquipos);
    
        
        for (int i = 0; i < cantidadEquipos; i++) {
            String nombreEquipo;
            boolean nombreRepetido;
            do {
                nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo " + (i + 1) + ":");
                nombreRepetido = equipos.contains(nombreEquipo);
    
                if (nombreRepetido) {
                    JOptionPane.showMessageDialog(null, "El nombre del equipo ya existe. Por favor, elija otro nombre.");
                }
            } while (nombreRepetido);
    
            equipos.add(nombreEquipo);
        }
        return equipos;
    }

    public static void mostrarInfoTodosTorneos(List<Torneo> torneos) {
            for (Torneo torneo : torneos) {
                System.out.println(torneo.toString());
                System.out.println("-------------------------------------------");
            }
        }
    

    public static void modificarDatosTorneo(List<Torneo> torneos) {
        String mensaje = "";
        for (int i = 0; i < torneos.size(); i++) {
            Torneo torneoIndice = torneos.get(i);
            mensaje += (i + 1)+ ". "+ torneoIndice.getNombreTorneo()+"\n";
        }   
        JOptionPane.showMessageDialog(null, mensaje);
    
        int indiceTorneo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el número del torneo a modificar:")) - 1;

        if (indiceTorneo >= 0 && indiceTorneo < torneos.size()) {
            Torneo torneoSeleccionado = torneos.get(indiceTorneo);
            torneoSeleccionado.cambiarAtributos();
        } else {
            System.out.println("Índice de torneo no válido.");
        }
    }
}

