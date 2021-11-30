package Organizador.Politicas;

import Organizador.Elemento;

public class PoliticaPrecioEntre implements Politica{
    private int p1,p2;

    public PoliticaPrecioEntre(int p1, int p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean cumple(Elemento e) {
        return p1<e.getPrecio() && e.getPrecio()<p2;
    }
}
