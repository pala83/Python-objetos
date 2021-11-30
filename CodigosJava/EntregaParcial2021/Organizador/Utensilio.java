package Organizador;

import Organizador.Politicas.Politica;

import java.util.ArrayList;
import java.util.List;

public class Utensilio extends Elemento{

    private String origen;
    private int precio;
    private int peso;
    private int dureza;
    private final List<String> caracteristicas;

    public Utensilio(String nombre, String origen, int precio, int peso, int dureza){
        super(nombre);
        this.origen = origen;
        this.precio = precio;
        this.peso = peso;
        this.dureza = dureza;
        this.caracteristicas = new ArrayList<>();
    }

    @Override
    public int getCantidad() {
        return 1;
    }

    @Override
    public String getOrigen() { return this.origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    @Override
    public int getPrecio() { return this.precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    @Override
    public int getPeso() { return this.peso; }
    public void setPeso(int peso) { this.peso = peso; }
    @Override
    public int getDureza() { return this.dureza; }
    public void setDureza(int dureza) { this.dureza = dureza; }

    public void addCaracteristica(String car){
        if (!this.caracteristicas.contains(car))
            this.caracteristicas.add(car);
    }
    @Override
    public List<String> getCaracteristicas(){
        return List.copyOf(this.caracteristicas);
    }
    @Override
    public List<Elemento> buscar(Politica p) {
        List<Elemento> retorno = new ArrayList<>();
        if (p.cumple(this))
            retorno.add(this);
        return retorno;
    }

    @Override
    public boolean puedeExhibirse(List<Politica> politicas) {
        for (Politica p : politicas)
            if (!p.cumple(this))
                return false;
            return true;
    }

    @Override
    public Elemento getCopia(Politica p) {
        if (p.cumple(this)){
            Utensilio retorno = new Utensilio(this.getNombre(),
                    this.getOrigen(), this.getPrecio(), this.getPeso(), this.getDureza());
            for (String s : this.caracteristicas)
                retorno.addCaracteristica(s);
            return retorno;
        }
        return null;
    }
}
