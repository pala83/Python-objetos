package Organizador.Politicas;

import Organizador.Elemento;

public class PoliticaCaracteristica implements Politica{
    private String caract;

    public PoliticaCaracteristica(String caract){
        this.caract = caract;
    }

    @Override
    public boolean cumple(Elemento e) {
        return e.getCaracteristicas().contains(caract);
    }
}
