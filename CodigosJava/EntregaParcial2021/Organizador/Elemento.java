package Organizador;

import Organizador.Politicas.Politica;

import java.util.List;

public abstract class Elemento {
    private String nombre;

    public Elemento(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public abstract int getPeso();
    public abstract int getDureza();
    public abstract String getOrigen();
    public abstract List<String> getCaracteristicas(); // servicio 3
    public abstract int getPrecio(); // servicio 1
    public abstract int getCantidad(); // servicio 2

    public abstract List<Elemento> buscar(Politica p);//servicio 4
    public abstract boolean puedeExhibirse(List<Politica> politicas); // servicio 5
    public abstract Elemento getCopia(Politica p); // servicio 6
}
