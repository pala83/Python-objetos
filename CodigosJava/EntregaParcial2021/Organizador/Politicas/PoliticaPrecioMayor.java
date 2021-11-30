package Organizador.Politicas;

import Organizador.Elemento;

public class PoliticaPrecioMayor implements Politica{
    private int precio;

    public PoliticaPrecioMayor(int precio){
        this.precio = precio;
    }

    @Override
    public boolean cumple(Elemento e) {
        return e.getPrecio()>precio;
    }
}
