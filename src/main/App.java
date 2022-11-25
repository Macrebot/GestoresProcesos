package main;

import java.util.ArrayList;
import java.util.Scanner;
import functions.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
	    Administracion admin = new Administracion();
        boolean dc = true;
        int menu = -1;
        
        String opciones =   "1. Crear Nuevo Gestor rápido\n" + 
                            "2. Crear Nuevo Gestor detallado\n" + 
                            "3. Ver todos los Gestores detalladamente\n " + 
                            "4. Editar algún Gestor\n" + 
                            "5. Borra algún Gestor\n" + 
                            "6. Salir del programa\n";

        System.out.println("BIENVENIDO AL SISTEMA DE GESTIÓN DE PROCESOS\nCREADO POR MACREBOT\n");
        while (dc){

            // Muestras las opciones para hacer. Si escoge una opción inexistente, se repetirá el proceso
            while (menu < 1 || menu > 6) {

                System.out.println(opciones);
                System.out.println("Que opción desea realizar?: ");
                menu = sc.nextInt();
                if (menu < 1 || menu > 6) {
                    System.out.println("Incorrecto, introduzca una opción válida.");
                }
            }

            // Ejecución de la opción decidida
            switch (menu) {
                case 1:
                    admin.crearGestor();
                    break;

                case 2:
                    System.out.println("Introduce el nombre del Gestor");
                    admin.crearGestor(sc.nextLine());
                    break;

                case 3:
                    admin.mostrarGestores();
                    break;

                case 4:
                    admin.editarGestor();
                    break;

                case 5:
                    System.out.println("Introduce el nombre del Gestor a eliminar.");
                    admin.borrarGestor();
                    break;

                case 6:
                    dc = false;
                    break;
                
                default:
                    break;
            }

        menu = -1;
        }


        sc.close();
    }
}
