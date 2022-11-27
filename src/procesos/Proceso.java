package procesos;

public class Proceso {
    
    // Variables que vendrán declaradas en la creación del objeto
    private char nombreProceso;
    private int tiempoLlegada;
    private int tiempoEjecucion;
    
    // Variables a calcular a partir de las ya declaradas
    private int tiempoEspera = 0;
    private int tiempoRetorno = 0;
    private double indicePenalizacion = 0; // Calculada a partir de tiempoRetorno / tiempoEjecucion.

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
        System.out.println("Tiempo Retorno: " + tiempoRetorno + "\nTiempoEjecución: " + tiempoEjecucion);
        indicePenalizacion = (double)tiempoRetorno / (double)tiempoEjecucion;
    }

}
