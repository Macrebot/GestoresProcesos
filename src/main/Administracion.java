package main;

import java.util.ArrayList;

import functions.*;

public class Administracion {

    private ArrayList<Fifo> listaFifos;
    private ArrayList<Sjf> listaSjf;
    private ArrayList<Srtf> listaSrtf;
    private ArrayList<Fcfs> listaFcfs;

    // Método para imprimir por pantalla todos los gestores creados
    public void mostrarGestores() {

        // Imprime todos los Gestores FIFO
        System.out.println("Gestores FIFO");

        /* Por cada elemento tipo FIFO que haya en la
        tabla, imprimirá una tabla con los datos y procesos */
        for (Fifo iterable : listaFifos) {
            iterable.impresionTablaGeneral();
        }

        // Imprime todos los Gestores FCFS

        // Imprime todos los Gestores SJF

        // Imprime todos los Gestores SRFT

    }

    // Método para crear un nuevo gestor
    public void crearGestor() {
        listaFifos.add(new Fifo());
    }

    public void crearGestor(String nombre){
        listaFifos.add(new Fifo(nombre));
    }

    // Método para Ver todos los Gestores detalladamente

    // Método para editar un Gestor ya existente

    // Método para borrar un gestor de la lista
    
}
