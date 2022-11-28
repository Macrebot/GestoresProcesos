package main;

import java.util.ArrayList;
import java.util.Scanner;

import functions.*;

public class Administracion {
    Scanner sc = new Scanner(System.in);

    private ArrayList<Fifo> listaFifos = new ArrayList<Fifo>();
    private ArrayList<Sjf> listaSjf;
    private ArrayList<Srtf> listaSrtf;
    private ArrayList<Fcfs> listaFcfs;

    private int decision = 0; // varible para guardar deciciones temporales durante la ejecución

    // Método para imprimir por pantalla todos los gestores creados
    public void mostrarGestores() {

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

        // Imprime todos los Gestores FCFS

        // Imprime todos los Gestores SJF

        // Imprime todos los Gestores SRFT

    }

    // Método para mostrar solamente los Gestores FIFO
    public void mostrarFifo() {
	for(int i = 0; i < listaFifos.size(); i++){
	    System.out.println((i + 1) + ". " + listaFifos.get(i).getNombre() + "\nCreado el: " + listaFifos.get(i).getFecha());
	}
    }

    // Método para mostrar solamente los Gestores FCFS
    public void mostrarFcfs() {
    }

    // Método para mostrar solamente los Gestores SJF
    public void mostrarSjf() {
    }

    // Método para mostrar solamnete los Gestores SRFT
    public void mostrarSrft() {
    }

    // Método para crear un nuevo gestor
    public void crearGestor() {
        Fifo objetoFifo = new Fifo();
        objetoFifo.ordenarFifo();
        System.out.println("Ejecucion del crearGestor()");
        listaFifos.add(objetoFifo);
    }

    public void crearGestor(String nombre){
        listaFifos.add(new Fifo(nombre));
    }

    // Método para editar un Gestor ya existente
    public void editarGestor() {

    }

    // Método para borrar un gestor de la lista
    public void borrarGestor() {

	decision = 0;
	while (decision < 1 || decision > 4){
	    
	    System.out.println("1. FIFO\n2. FCFS\n3. SJF\n4. SRFT\n");
	    System.out.println("Que tipo de Gestor quiere eliminar?:");
	    decision = sc.nextInt();
	}
	
	switch (decision) {
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

	}


    }
    
}
