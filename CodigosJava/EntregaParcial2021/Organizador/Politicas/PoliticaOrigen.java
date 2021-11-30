package Organizador.Politicas;

import Organizador.Elemento;

public class PoliticaOrigen implements Politica{
    private String origen;

    public PoliticaOrigen(String origen){
        this.origen = origen;
    }

    @Override
    public boolean cumple(Elemento e) {
        return e.getOrigen().equals(origen);
    }
}
