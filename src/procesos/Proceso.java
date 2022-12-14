package procesos;

public class Proceso {

    // * ATRIBUTOS
    
    // Variables que vendrán declaradas en la creación del objeto
    private char nombreProceso;
    private int tiempoLlegada;
    private int tiempoEjecucion;
    
    // Variables a calcular a partir de las ya declaradas
    private int tiempoEspera = 0;
    private int tiempoRetorno = 0;

    // Calculado a partir de tiempoRetorno / tiempoEjecucion
    private double indicePenalizacion = 0; 
    
    // * CONSTRUCTOR

    public Proceso (char nombreProceso, int tiempoLlegada, int tiempoEjecucion){
        
        // Valores declarados
        this.nombreProceso = nombreProceso;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    // * MÉTODOS

    // * GETTERS

    // Métodos para la gestión del proceso
    public char getNombreProceso (){ return nombreProceso; }
    public int getTiempoLlegada () { return tiempoLlegada; }
    public int getTiempoEjecucion () { return tiempoEjecucion; }

    public int getTiempoEspera () { return tiempoEspera; }
    public int getTiempoRetorno () { return tiempoRetorno; }
    public double getIndicePenalizacion () { return indicePenalizacion; }
    
    // * SETTERS

    // Variables que vendrán declaradas en la creación del objeto
    public void setNombreProceso (char nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public void setTiempoLlegada (int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public void setTiempoEjecucion (int tiempoEjecucion){
        this.tiempoEjecucion = tiempoEjecucion;
    }

    // Variables a calcular a partir de las ya declaradas
    public void setTiempoEspera (int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public void setTiempoRetorno (int tiempoRetorno) {
        this.tiempoRetorno = tiempoRetorno;
    }

    public void setIndicePenalizacion () {
        /* Toma los dos valores, los combierte a ambos en Double, los divide, el resultado se envía al 
        método round del objeto Math (para delimitar los decimales) y el resultado, lo guarda en indicePenalizacion */
        indicePenalizacion = (double)tiempoRetorno / (double)tiempoEjecucion;
    }

}
