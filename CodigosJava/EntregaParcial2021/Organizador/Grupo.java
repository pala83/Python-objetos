package Organizador;

import Organizador.Politicas.Politica;

import java.util.ArrayList;
import java.util.List;

public class Grupo extends Elemento{
    private final List<Elemento> elementos;

    public Grupo(String nombre){
        super(nombre);
        this.elementos = new ArrayList<>();
    }

    public void addElemento(Elemento elem){
        this.elementos.add(elem);
    }
    public List<Elemento> getElementos(){
        return List.copyOf(this.elementos);
    }
    @Override
    public int getPeso() {
        if (!this.elementos.isEmpty()){
            int suma = 0;
            for (Elemento elem: this.elementos)
                suma+= elem.getPeso();
            return suma;
        }
        return 0;
    }
    @Override
    public int getDureza() {
        if (!this.elementos.isEmpty()){
            int minDureza = this.elementos.get(1).getDureza();
            for (Elemento elem: this.elementos){
                if (elem.getDureza()<minDureza)
                    minDureza = elem.getDureza();
            }
            return minDureza;
        }
        return 0;
    }
    @Override
    public String getOrigen() {
        if (!this.elementos.isEmpty())
            return this.elementos.get(1).getOrigen();
        return null;
    }
    @Override
    public List<String> getCaracteristicas() {
        List<String> retorno = new ArrayList<>();
        for (Elemento elem: this.elementos){
            if (!elem.getCaracteristicas().isEmpty()){
                for (String carac: elem.getCaracteristicas()){
                    if (!retorno.contains(carac))
                        retorno.add(carac);
                }
            }
        }
        return retorno;
    }
    @Override
    public int getPrecio() {
        if (!this.elementos.isEmpty()){
            int suma = 0;
            for (Elemento elem: this.elementos)
                suma+= elem.getPrecio();
            return suma;
        }
        return 0;
    }

    @Override
    public int getCantidad() {
        int retorno = 0;
        for (Elemento e: this.elementos)
            retorno+=e.getCantidad();
        return retorno;
    }

    @Override
    public List<Elemento> buscar(Politica p) {
        List<Elemento> retorno = new ArrayList<>();
        if (p.cumple(this))
            retorno.add(this);
        if (!this.elementos.isEmpty())
            for (Elemento e: this.elementos)
                retorno.addAll(e.buscar(p));
        return retorno;
    }

    @Override
    public boolean puedeExhibirse(List<Politica> politicas) {
        for (Politica p : politicas){
            if (!p.cumple(this))
                return false;
            if (!this.elementos.isEmpty()){
                for (Elemento e : this.elementos)
                    if (!p.cumple(e))
                        return false;
            }
        }
        return true;
    }

    @Override
    public Elemento getCopia(Politica p) {
        Grupo g1 = new Grupo(this.getNombre());
        for (Elemento e : this.elementos){
            Elemento aux = e.getCopia(p);
            if (aux!= null){
                g1.addElemento(aux);
            }
        }
        if (g1.getCantidad()>0)
            return g1;
        else return null;
    }
}
