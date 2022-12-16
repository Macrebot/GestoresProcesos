package main;

import java.util.ArrayList;
import java.util.Scanner;

import functions.Fifo;

public class Administracion {
    Scanner sc = new Scanner(System.in);

    // * ARREGLOS
    /* Creación de los arreglos que guardarán todos los objetos de los distintos
    algoritmos */
    private ArrayList<Fifo> listaFifos = new ArrayList<Fifo>();

    // todo: Arrays que aún no están en uso porque no existen los algoritmos
    /* 
        private ArrayList<Sjf> listaSjf;
        private ArrayList<Srtf> listaSrtf;
        private ArrayList<Fcfs> listaFcfs;
     */
    
    // * ATRIBUTOS
    private int decision = 0; // varible para guardar deciciones temporales durante la ejecución

    // * MÉTODOS
    // Método para limpiar la consola
    public void limpiarConsola() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    // Método para imprimir por pantalla todos los gestores creados
    public void mostrarGestores() {
        // todo: poder escoger entre diferentes tipos de gestores

        if (listaFifos == null || listaFifos.size() < 0) {

            System.out.println("No tienes Gestores FIFO creados");
            
        } else {
            
            // Imprime todos los Gestores FIFO
            System.out.println("Gestores FIFO");

            /* Por cada elemento tipo FIFO que haya en la
            tabla, imprimirá una tabla con los datos y procesos */
            for (Fifo iterable : listaFifos) {
                iterable.impresionTablaGeneral();
            }
        }

        // todo: Imprime todos los Gestores FCFS

        // todo: Imprime todos los Gestores SJF

        // todo: Imprime todos los Gestores SRFT

    }

    // Método para mostrar solamente los Gestores FIFO
    public void mostrarFifo() {
	for(int i = 0; i < listaFifos.size(); i++){
	    System.out.println((i + 1) + ". " + listaFifos.get(i).getNombre() + "\nCreado el: " + listaFifos.get(i).getFecha());
	}
    }

    // todo: Método para mostrar solamente los Gestores FCFS
    public void mostrarFcfs() {
    }

    // todo: Método para mostrar solamente los Gestores SJF
    public void mostrarSjf() {
    }

    // todo: Método para mostrar solamnete los Gestores SRFT
    public void mostrarSrft() {
    }

    // Método para crear un nuevo gestor
    public void crearGestor() {
        Fifo objetoFifo = new Fifo();

        // Algoritmo de organización
        objetoFifo.ordenarFifo();
        
        // Calcular las medias del objeto
        objetoFifo.setTiempoEsperaMedio();
        objetoFifo.setTiempoRetornoMedio();
        objetoFifo.setIndicePenalizacionMedio();

        objetoFifo.setProcesoPeorTratado();

        System.out.println("Ejecucion del crearGestor()");
        listaFifos.add(objetoFifo);
    }

    public void crearGestor(String nombre){
        listaFifos.add(new Fifo(nombre));
    }

    // todo: Método para editar un Gestor ya existente
    public void editarGestor() {

    }

    // Método para borrar un gestor de la lista
    public void borrarGestor() {

        decision = 0;

        /* Comprueba que el número en decisión concuerde con la cantidad de
          tipos de Gestores que hay */
        while (decision < 1 || decision > 4){ // 
            
            System.out.println("1. FIFO\n2. FCFS\n3. SJF\n4. SRFT\n");
            System.out.println("Que tipo de Gestor quiere eliminar?:");
            decision = sc.nextInt();
        }
        
        switch (decision) {
            // Borrar Gestor de tipo FIFO
            case 1:
                decision = 0;
                while (decision < 1 || decision > listaFifos.size()) {

                    mostrarFifo();
                    System.out.println("Qué Gestor quiere eliminar?:");
                    decision = sc.nextInt() - 1;

                }

                // Busca el Gestor con ese identificador y lo elimina
                listaFifos.remove(decision);

                break;

            // todo: Borrar Gestor de tipo FCFS
            case 2:
                break;

            // todo: Borrar Gestor de tipo SJF
            case 3:
                break;

            // todo: Borrar Gestor de tipo SRFT
            case 4:
                break;

        }

    }


    /* Método para acceder desde borrarGestor() para borrar específicamente el
    gestor del tipo selecionado en borrarGestor() */
    public void seleccionarBorrarGestor(int tipo) {

    }
    
}
