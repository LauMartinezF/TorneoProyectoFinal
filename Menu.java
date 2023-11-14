import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) {
        int opcion = -1;
        System.out.println("MENU");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");

        System.out.print("Seleccione una opción: ");
        
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Opcion: "));
        switch (opcion) {
            
            case 1:
                System.out.println("TAREA 1");
                break;
            case 2:
                System.out.println("TAREA 2");
                break;
            case 3:
                System.out.println("TAREA 3");
                break;
            default:
                System.out.println("Opción no valida");
        }
    }
}

