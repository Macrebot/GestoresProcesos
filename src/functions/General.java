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

    /* Arreglo que se usará para mostrar una tabla con todos los
    valores de todos los procesos */
    protected char tablaGeneral[][];

    /* Arreglo que se usará para mostrar el orden en el que
    cada proceso se estará ejecutando */
    protected ArrayList< ArrayList <Character>> tabla;

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
        int procesosN = sc.nextInt();

        /* Creación de la tabla en la que se mostrarán todos los
        valores, ya que ahora sabemos cuantos procesos van a haber*/
        tablaGeneral = new char[procesosN][6];

        // Creación de las variables para cada proceso
        char nombreProceso;
        int tiempoLlegada;
        int tiempoEjecucion;

        // Se crea el arreglo con la cantidad de procesos que desea tener
        procesos = new Proceso[procesosN];
        for (int i = 0; i < procesosN; i++) {

            System.out.print("Introduzca el nombre del proceso (carácter): ");
            nombreProceso = sc.next().charAt(0);

            System.out.print("Introduzca el tiempo de llegada del proceso: ");
            tiempoLlegada = sc.nextInt();

            System.out.print("Introduzca el tiempo de ejecución del proceso: ");
            tiempoEjecucion = sc.nextInt();

            procesos[i] = new Proceso(nombreProceso, tiempoLlegada, tiempoEjecucion);
            System.out.println("Proceso " + (i+1) + " creado con éxito.");
        }
        
        System.out.println("Lista de procesos creada con éxito.");
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

}
