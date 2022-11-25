package main;

import java.util.ArrayList;
import java.util.Scanner;
import functions.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
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

            // Muestra los Gestores creados, si no hay, muestra que no hay ninguno creado
            // Gestores FIFO creados

            // Gestores FCFS creados

            // Gestores SJF creados

            // Gestores SRFT creados


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

                    break;
            
                default:
                    break;
            }

                    
        }



    }
}
