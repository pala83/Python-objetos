package Organizador.Politicas;

import Organizador.Elemento;

public class PoliticaOr implements Politica{
    private Politica p1, p2;

    public PoliticaOr(Politica p1, Politica p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean cumple(Elemento e) {
        return p1.cumple(e) || p2.cumple(e);
    }
}
