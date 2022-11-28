package functions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import procesos.Proceso;

abstract class General {
    Scanner sc = new Scanner(System.in);

    // Variables para realizar los cálculos de los procesos
    protected int procesoEjecutandose = -1;
    protected LinkedList<Integer> procesosEnFila = new LinkedList<Integer>();
    protected int tiempoEjecucionRestante = 0;

    // Arreglo bidimensional para simular la ejecución de los procesos
    protected char tabla [][];

    protected int tiempoEjecucionTotal;

    protected int procesosN;

    // Variables para identificar el objeto
    private String nombre;
    private String tipo;
    private LocalDateTime fechaCreacion;

    // Variables para las medias de los tiempos
    private int tiempoEsperaMedio;
    private int tiempoRetornoMedio;

    // El proceso peor tratado será el que tenga un mayor índice de penalización
    private char procesoPeorTratado;

    // Declaración del arreglo para los procesos
    protected Proceso procesos [];

    // Método para crear la lista de los procesos
    private void creacionProcesos () {
        // Creación del arreglo que guardará los procesos
        System.out.println("¿Cuántos procesos desea crear?:");
        procesosN = sc.nextInt();

        // Creación de las variables para cada proceso
        char nombreProceso;
        int tiempoLlegada;
        int tiempoEjecucion;
        tiempoEjecucionTotal = 0;

        // Se crea el arreglo con la cantidad de procesos que desea tener
        procesos = new Proceso[procesosN];

        // Se crea uno por uno los procesos
        for (int i = 0; i < procesosN; i++) {

            System.out.print("Introduzca el nombre del proceso (carácter): ");
            nombreProceso = sc.next().charAt(0);

            System.out.print("Introduzca el tiempo de llegada del proceso: ");
            tiempoLlegada = sc.nextInt();

            System.out.print("Introduzca el tiempo de ejecución del proceso: ");
            tiempoEjecucion = sc.nextInt();
            tiempoEjecucionTotal += tiempoEjecucion;

            procesos[i] = new Proceso(nombreProceso, tiempoLlegada, tiempoEjecucion);
            System.out.println("Proceso " + (i+1) + " creado con éxito.\n");
        }
        
        /* Creación del tamaño de la tabla, que será de alta el número de procesos tenga
        y de ancha el total de tiempo de ejecución entre todos los procesos*/
        tabla = new char[tiempoEjecucionTotal + 1][procesosN];
        
        System.out.println("Lista de procesos creada con éxito.\n");
    }
    
    // Constructor con valores por defecto
    General (){
        nombre = "default";
        tipo = "default";
        fechaCreacion = LocalDateTime.now();

        creacionProcesos();
    }

    // Constructor con los valores asignados por el usuario
    General (String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        fechaCreacion = LocalDateTime.now();

        creacionProcesos();
    }

    // Getters del objeto identificativo
    public LocalDateTime getFecha(){ return fechaCreacion; }

    public String getTipo() { return tipo; }

    public String getNombre() { return nombre; }

    // Setter del nombre identificativo
    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    // Métodos para las variables del Gestor de Procesos
    public int getTiempoEsperaMedio () { return tiempoEsperaMedio; }
    public int getTiempoRetornoMedio () { return tiempoRetornoMedio; }

    public char getProcesoPeorTratado () { return procesoPeorTratado; }

    // Creación de la lista para calcular las medias
    private int[] crearLista (int tipoLista) {

        int [] listaNumeros = new int [procesos.length];
        int contador = 0;

        /* Dependiendo de el número, en la lista se guardarán los
        tiempos de espera o los tiempos de ejecución */
        switch (tipoLista) {
            case 1:
                for (Proceso proceso : procesos) {
                    listaNumeros[contador] = proceso.getTiempoEspera();
                    contador++;
                }
            case 2:
                for (Proceso proceso : procesos) {
                    listaNumeros[contador] = proceso.getTiempoEjecucion();
                    contador++;
                }
            default: break;
        }

        return listaNumeros;
    }

    // Cálculo para las medias de los tiempos
    private int hacerMedia (int listaNumeros[]) {
        int tiempoMedio = 0;
        for (int i : listaNumeros) {
            tiempoMedio += i;
        }
        return tiempoMedio /= listaNumeros.length;
    }

    // Métodos para calcular las medias de los tiempos
    public void setTiempoEsperaMedio (){
        tiempoEsperaMedio = hacerMedia(crearLista(1));
    }

    public void setTiempoRetornoMedio (int tiemposRetorno[]) {
        tiempoRetornoMedio = hacerMedia(crearLista(2));
    }

    // Cálculo del proceso peor tratado
    public void setProcesoPeorTratado () {
        double max = 0;
        char nombreMayor = '0';
        for (Proceso proceso : procesos) {
            if (proceso.getIndicePenalizacion() > max) {
                max = proceso.getIndicePenalizacion();
                nombreMayor = proceso.getNombreProceso();
            }
        }
        procesoPeorTratado = nombreMayor;
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
                String.format("%.2f", iterable.getIndicePenalizacion()) + "\t\t|\n");
        }
        System.out.println();

        // Impresión de la tabla en la que se simula la ejecución de los procesos
        for (int j = 0; j < procesosN; j++){

            for (int i = 0; i < tiempoEjecucionTotal; i++) {
                System.out.print(tabla[i][j] + " | ");
            }
            System.out.println();

        }
        System.out.println();
    }
}
