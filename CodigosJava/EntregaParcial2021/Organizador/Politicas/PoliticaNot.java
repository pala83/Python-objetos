package Organizador.Politicas;

import Organizador.Elemento;

public class PoliticaNot implements Politica{
    private Politica p;

    public PoliticaNot(Politica p){
        this.p = p;
    }

    @Override
    public boolean cumple(Elemento e) {
        return !p.cumple(e);
    }
}
