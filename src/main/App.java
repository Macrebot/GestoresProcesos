package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
	    Administracion admin = new Administracion();
        boolean salir = false;
        int menu = -1;

        admin.limpiarConsola();
        
        // Constante para mostrar el menú de opciones
        final String opciones =   "1. Crear Nuevo Gestor rápido\n" + 
                            "2. Crear Nuevo Gestor detallado\n" + 
                            "3. Ver todos los Gestores detalladamente\n" + 
                            // todo: añadir vista simplificada de los gestores
                            "4. Editar algún Gestor\n" + 
                            "5. Borrar algún Gestor\n" + 
                            "6. Salir del programa\n";

        // Comienza la ejecución del programa
        System.out.println("BIENVENIDO AL SISTEMA DE GESTIÓN DE PROCESOS\nCREADO POR MACREBOT\n");
        while (!salir){

            // Muestra las opciones para hacer. Si escoge una opción inexistente, se repetirá el proceso
            while (menu < 1 || menu > 6) {

                System.out.println(opciones);
                System.out.println("Que opción desea realizar?: ");
                menu = sc.nextInt();

                admin.limpiarConsola();

            }

            // Ejecución de la opción decidida
            switch (menu) {

                // Crear Nuevo Gestor Rápido
                case 1:
                    admin.crearGestor();
                    admin.limpiarConsola();
                    break;

                // Crear Nuevo Gestor detallado
                case 2:
                    System.out.println("Introduce el nombre del Gestor");
                    admin.crearGestor(sc.nextLine());
                    admin.limpiarConsola();
                    break;

                // Ver todos los gestores detalladamente
                case 3:
                    admin.mostrarGestores();
                    break;

                // Editar algún Gestor
                case 4:
                    admin.editarGestor();
                    admin.limpiarConsola();
                    break;

                // Borrar algún Gestor
                case 5:
                    admin.borrarGestor();
                    admin.limpiarConsola();
                    break;

                // Salir del Programa
                case 6:
                    salir = true;
                    break;
                
                default:
                    System.out.println("INCORRECTO, introduzca una opción válida.\n");
                    break;
            }

            menu = -1;
        }


        sc.close();
    }
}
