package functions;

import java.util.ArrayList;
import procesos.Proceso;

public class Fifo extends General{

    public Fifo () {
        super();
    }

    public Fifo (String nombre) {
        super(nombre, "Fifo");
    }

    public void ordenarFifo () {
        tabla.add(new ArrayList<Character>());

        /* Un bucle que recorrerá toda la tabla para simular la
        ejecución de los procesos */

        // Bucle que recorrerá horizontalmente la tabla
        for (int i = 0; i < 6; i++) {

            if(tiempoEjecucionRestante < 1) {

                // Se calcula el índice de penalización del proceso
                procesos[procesoEjecutandose].setIndicePenalizacion();

                procesoEjecutandose = -1; // Declara que no hay procesos ejecutándose
            }

            // Bucle que recorrerá verticalmente la tabla
            for (int j = 0; j < procesos.length; j++) {

                // Si encuentra un proceso que debería comenzar a ejecutarse
                if (procesos[j].getTiempoLlegada() == i) {
                    procesosEnFila.addLast(j);
                    
                }
                    // Si no hay procesos ya ejecutándose
                if (procesoEjecutandose < 0){

                    // Toma el primer valor en fila para ejecutarlo
                    procesoEjecutandose = procesosEnFila.getFirst();

                    // Declara el tiempo de espera que tuvo que hacer para ejecutarse
                    procesos[j].setTiempoEspera(i - procesos[j].getTiempoLlegada());

                    // Declara el tiempo de ejecución que tardará el proceso en terminar
                    tiempoEjecucionRestante = procesos[j].getTiempoEjecucion();


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
        for (char[] iterable : tablaGeneral) {
            System.out.println(iterable);
        }
    }
    
}
