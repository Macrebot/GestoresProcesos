package procesos;

import java.text.DecimalFormat;

public class Proceso {
    
    // Variables que vendrán declaradas en la creación del objeto
    private char nombreProceso;
    private int tiempoLlegada;
    private int tiempoEjecucion;
    
    // Variables a calcular a partir de las ya declaradas
    private int tiempoEspera = 0;
    private int tiempoRetorno = 0;

    // Calculado a partir de tiempoRetorno / tiempoEjecucion sin control de decimales
    private String indicePenalizacionDecimales = "";

    // Convercion de indicePenalizacionDecimales a 2 decimales
    private double indicePenalizacion = 0; 
    
    // Objeto para declarar el número de decimales que puede guardar indicePenalizacion
    DecimalFormat df = new DecimalFormat("#.00");

    public Proceso (char nombreProceso, int tiempoLlegada, int tiempoEjecucion){
        
        // Valores declarados
        this.nombreProceso = nombreProceso;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    // Métodos para la gestión del proceso
    // Getters
    public char getNombreProceso (){ return nombreProceso; }
    public int getTiempoLlegada () { return tiempoLlegada; }
    public int getTiempoEjecucion () { return tiempoEjecucion; }

    public int getTiempoEspera () { return tiempoEspera; }
    public int getTiempoRetorno () { return tiempoRetorno; }
    public double getIndicePenalizacion () { return indicePenalizacion; }
    
    // Setters
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
