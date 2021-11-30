package DespachoComidas;

import java.sql.Time;

public class ComidaSimple extends Comida {
    private int calorias;
    private int precio;
    private Time tPreparacion;

    public ComidaSimple(String nombre, String tipo, String modoPreparacion, int calorias,
                        int precio, Time tPreparacion){
        super(nombre, tipo, modoPreparacion);
        this.calorias = calorias;
        this.precio = precio;
        this.tPreparacion = tPreparacion;
    }
    @Override
    public int getCalorias() {
        return this.calorias;
    }
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
    @Override
    public int getPrecio() {
        return this.precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    @Override
    public Time getPreparacion() {
        return this.tPreparacion;
    }
    public void setPreparacion(Time tPreparacion) {
        this.tPreparacion = tPreparacion;
    }
}
