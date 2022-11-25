package procesos;

public class Proceso {
    
    // Variables que vendrán declaradas en la creación del objeto
    private char nombreProceso;
    private int tiempoLlegada;
    private int tiempoEjecucion;
    
    // Variables a calcular a partir de las ya declaradas
    private int tiempoEspera = 0;
    private int tiempoRetorno = 0;
    private double indicePenalizacion = 0; // Calculada a partir de tiempoRetorno / tiempoLlegada.

    public Proceso (char nombreProceso, int tiempoLlegada, int tiempoEjecucion){
        
        // Valores declarados
        nombreProceso = this.nombreProceso;
        tiempoLlegada = this.tiempoLlegada;
        tiempoEjecucion = this.tiempoEjecucion;
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
        nombreProceso = this.nombreProceso;
    }

    public void setTiempoLlegada (int tiempoLlegada) {
        tiempoLlegada = this.tiempoLlegada;
    }

    public void setTiempoEjecucion (int tiempoEjecucion){
        tiempoEjecucion = this.tiempoEjecucion;
    }

    // Variables a calcular a partir de las ya declaradas
    public void setTiempoEspera (int tiempoEspera) {
        tiempoEspera = this.tiempoEspera;
    }

    public void setTiempoRetorno (int tiempoRetorno) {
        tiempoRetorno = this.tiempoRetorno;
    }

    public void setIndicePenalizacion () {
        indicePenalizacion = (double)tiempoRetorno / (double)tiempoEjecucion;
    }

}
