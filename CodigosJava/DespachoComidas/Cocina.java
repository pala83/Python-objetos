package DespachoComidas;

import java.util.ArrayList;
import java.util.List;

public class Cocina {
    private final List<CriterioCobro> criteriosDeCobro;
    private String nombre;
    private Pedido pedido;
    private final List<GestorEstaciones> estaciones;

    public Cocina(String nombre, Pedido pedido) {
        GestorEstaciones nueva = new EstacionPDefecto();
        this.criteriosDeCobro = new ArrayList<>();
        this.nombre = nombre;
        this.pedido = pedido;
        this.estaciones = new ArrayList<>();
        estaciones.add(nueva);
    }

    public List<CriterioCobro> getCriteriosDeCobro() {
        return List.copyOf(this.criteriosDeCobro);
    }
    public void addCriterioDeCobro(CriterioCobro c){
        this.criteriosDeCobro.add(c);
    }

    public void addEstacion(GestorEstaciones nueva) {
        if (!nueva.getNombre().equals("Estacion: POR DEFECTO")) {
            this.estaciones.add(1, nueva);
        }
    }

    public List<GestorEstaciones> getEstaciones() {
        return List.copyOf(this.estaciones);
    }

    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Pedido getPedido() { return this.pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    public void asignarComidas(){
        for (GestorEstaciones estacion: this.estaciones){
            for (Comida c: this.pedido.getConjuntoComidas()){
                if (!c.seAcepto())
                    estacion.add(c);
                if (estacion.getComidas().contains(c))
                    c.aceptarComida();
            }
        }
    }

    public int getCostoTotal(){
        int total = 0;
        for (Comida comida : this.pedido.getConjuntoComidas()){
            for (CriterioCobro c: this.criteriosDeCobro){
                total += c.getAccion().aplicar(comida);
            }
        }
        return total;
    }
}
