

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) {
        int opcion;
        List<Torneo> listaTorneos = new ArrayList<>();
        do{
        String menu;
        menu = 
            "-------------------------------------------"+"\n"+
            "MENU"+"\n"+"\n"+
            "1. INGRESAR DATOS DEL TORNEO\n" +
            "2. MODIFICAR DATOS DEL TORNEO\n" +
            "3. MOSTRAR INFO DEL TORNEO\n" +
            "4. SALIR"+"\n";

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
                System.out.println("Vuelva pronto!");
            default:
                System.out.println("Opción no valida");
        }
        }while (opcion!=5);

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

