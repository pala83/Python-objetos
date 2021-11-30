package DespachoComidas;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final List<Comida> conjuntoComidas;
    private int nroMesa;
    private String mozo;

    public Pedido(int nroMesa, String mozo){
        this.nroMesa = nroMesa;
        this.mozo = mozo;
        this.conjuntoComidas = new ArrayList<>();
    }
    public List<Comida> getConjuntoComidas() {
        return List.copyOf(this.conjuntoComidas);
    }
    public void addComida(Comida nueva) {
        this.conjuntoComidas.add(nueva);
    }

    public int getNroMesa() {
        return this.nroMesa;
    }
    public void setNroMesa(int nroMesa) {
        this.nroMesa = nroMesa;
    }
    public String getMozo() { return this.mozo; }
    public void setMozo(String mozo) {
        this.mozo = mozo;
    }
}
