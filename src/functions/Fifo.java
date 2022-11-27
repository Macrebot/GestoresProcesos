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
        for (int i = 0; i < 6; i++) {

            // Comprueba que el proceso ejecutándose no ha acabado
            if(tiempoEjecucionRestante < 1 && procesoEjecutandose != -1) {

                // Se calcula el índice de penalización del proceso
                procesos[procesoEjecutandose].setIndicePenalizacion();

                procesoEjecutandose = -1; // Declara que no hay procesos ejecutándose
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

                    // Declara el tiempo de ejecución que tardará el proceso en terminar
                    tiempoEjecucionRestante = procesos[procesoEjecutandose].getTiempoEjecucion();

                    // Guarda el proceso en ejecución en su espacio en la tabla
                    tabla[i][j] = procesos[procesoEjecutandose].getNombreProceso();


                } else { // Si hay un proceso ejecutándose, se agrega al final de la fila
                    procesosEnFila.addLast(j);
                }


                /* Cuando termina el ciclo, el proceso actualmente ejecutándose
                incrementa en 1 su tiempo de retorno */
                procesos[procesoEjecutandose].setTiempoRetorno(
                    procesos[procesoEjecutandose].getTiempoRetorno() + 1);

            }
            
            // Decrementa en uno el tiempo restante al terminar el ciclo en i
            tiempoEjecucionRestante--;

        }
        
    }

    public void impresionTablaGeneral () {
        System.out.println("Proceso\tTiempo de Llegada\t" +
            "Tiempo de ejecución\tTiempo de Espera\tTiempo de" +
            " retorno\tÍndice de penalización\n");
        for (Proceso iterable : procesos) {
            System.out.println(iterable.getNombreProceso() + "\t|\t" +
                iterable.getTiempoLlegada() + "\t\t|\t" +
                iterable.getTiempoEjecucion() + "\t\t|\t" + 
                iterable.getTiempoEspera() + "\t\t|\t" +
                iterable.getTiempoRetorno() + "\t\t|\t" +
                iterable.getIndicePenalizacion() + "\t\t|\n");
        }
        System.out.println();

        for (int j = 0; j < procesosN; j++){

            for (int i = 0; i < tiempoEjecucionTotal; i++) {
                System.out.print(tabla[i][j]);
            }
            System.out.println();

        }
    }
    
}
