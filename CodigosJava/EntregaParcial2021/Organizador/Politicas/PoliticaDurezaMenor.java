package Organizador.Politicas;

import Organizador.Elemento;

public class PoliticaDurezaMenor implements Politica{
    private int dureza;

    public PoliticaDurezaMenor(int dureza){
        this.dureza = dureza;
    }

    @Override
    public boolean cumple(Elemento e) {
        return e.getDureza()>dureza;
    }
}
