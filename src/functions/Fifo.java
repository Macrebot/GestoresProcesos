package functions;

import java.util.ArrayList;
import procesos.Proceso;

public class Fifo extends General{

    public Fifo () {
        super();
    }

    public Fifo (String nombre) {
        super(nombre, "FIFO");
    }

    public void ordenarFifo () {
        /* Un bucle que recorrerá toda la tabla para simular la
        ejecución de los procesos */

        // Bucle que recorrerá horizontalmente la tabla
        /* TODO: el 6 debe ser cambiado por una variable que sea igual a la suma
        del tiempo de ejecución de todos los procesos */
        for (int i = 0; i < tiempoEjecucionTotal; i++) {

            // Comprueba que el proceso ejecutándose no ha acabado
            if(tiempoEjecucionRestante < 1 && procesoEjecutandose != -1) {

                // Eliminamos el proceso de la fila
                procesosEnFila.removeFirst();

                // Se calcula el índice de penalización del proceso
                procesos[procesoEjecutandose].setIndicePenalizacion();



                procesoEjecutandose = -1; // Declara que no hay procesos ejecutándose

                // Elimina el primer elemento en la tabla 
            }

            // Bucle que recorrerá verticalmente la tabla
            for (int j = 0; j < procesos.length; j++) {

                // Si encuentra un proceso que debería comenzar a ejecutarse
                if (procesos[j].getTiempoLlegada() == i) {
                    procesosEnFila.addLast(j); // Lo envía al final de la fila
                }
                    // Si no hay procesos ejecutándose
                if (procesoEjecutandose < 0){

                    // Toma el primer valor en fila para ejecutarlo
                    procesoEjecutandose = procesosEnFila.getFirst();

                    // Declara el tiempo de espera que tuvo que hacer para ejecutarse
                    procesos[procesoEjecutandose].setTiempoEspera(i - procesos[procesoEjecutandose].getTiempoLlegada());

                    // Declara el tiempo de retorno a partir del tiempo de espera
                    procesos[procesoEjecutandose].setTiempoRetorno(procesos[procesoEjecutandose].getTiempoEspera());

                    // Declara el tiempo de ejecución que tardará el proceso en terminar
                    tiempoEjecucionRestante = procesos[procesoEjecutandose].getTiempoEjecucion();

                    // Guarda el proceso en ejecución en su espacio en la tabla
                    tabla[i][procesoEjecutandose] = procesos[procesoEjecutandose].getNombreProceso();


                }
                
                // Si el proceso ejecutando tiene un tiempoEjecucionRestante igual a 1, se añade ese caracter a la tabla
                if (tiempoEjecucionRestante == 1 && procesoEjecutandose == j){
                    tabla[i][j] = procesos[procesoEjecutandose].getNombreProceso();
                }

                // Si el espacio actual está vacío...
                else if (tabla[i][j] == '\u0000'){

                    // Si el proceso ejecutándo es igual a la posición actual, escribe una W a la tabla.
                    if (procesoEjecutandose == j){
                        tabla[i][j] = 'W';

                    // Guarda que el proceso no está en ejecución, en su espacio de la tabla
                    } else {
                        tabla[i][j] = '*';
                    }
                }

            }
            
            /* Cuando termina el ciclo, el proceso actualmente ejecutándose
            incrementa en 1 su tiempo de retorno */
            procesos[procesoEjecutandose].setTiempoRetorno(
                procesos[procesoEjecutandose].getTiempoRetorno() + 1);

            // Decrementa en uno el tiempo restante al terminar el ciclo en i
            tiempoEjecucionRestante--;

        }
        
    }

}
