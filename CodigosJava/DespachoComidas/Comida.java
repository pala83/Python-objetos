package DespachoComidas;

import java.sql.Time;

public abstract class Comida {
    private String nombre;
    private String tipo;
    private String modoPreparacion;
    private boolean aceptar;

    public Comida(String nombre, String tipo, String modoPreparacion){
        this.nombre = nombre;
        this.tipo = tipo;
        this.modoPreparacion = modoPreparacion;
        this.aceptar = false;
    }

    public void aceptarComida(){this.aceptar = true;}
    public boolean seAcepto(){return this.aceptar;}
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getModoPreparacion() {
        return this.modoPreparacion;
    }
    public void setModoPreparacion(String modoPreparacion) {
        this.modoPreparacion = modoPreparacion;
    }

    public abstract int getPrecio();
    public abstract int getCalorias();
    public abstract Time getPreparacion();
}

