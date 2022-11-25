package main;

import java.util.ArrayList;

import functions.*;

public class Administracion {

    private ArrayList<Fifo> listaFifos;
    private ArrayList<Sjf> listaSjf;
    private ArrayList<Srtf> listaSrtf;
    private ArrayList<Fcfs> listaFcfs;

    private int decision = 0; // varible para guardar deciciones temporales durante la ejecución

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

    // Método para mostrar solamente los Gestores FIFO
    public void mostrarFifo() {
	for(int i = 0; i < listaFifos.size(); i++){
	    System.out.println((i + 1) + ". " + listaFifos[i].getNombre + "\nCreado el: " + listaFifo[i].getFecha());
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
        listaFifos.add(new Fifo());
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
	    System.out.pritln("Que tipo de Gestor quiere eliminar?:");
	    decision = sc.nextInt();
	}
	
	switch (decision) {
	    case 1:
		mostrarFifo();
		System.out.println("Qué Gestor quiere eliminar?:");
		decision = sc.nextInt() - 1;

		// Elimina
		listaFifos[decision].

		break;

	}


	mostrarGestores();
	System.out.println("Que Gestor quiere borrar?:");
	decision = sc.nextInt();
    }
    
}
