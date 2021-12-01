package DespachoComidas;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ComidaCompleja extends Comida{
    private final List<Comida> comidas;

    public ComidaCompleja(String nombre, String tipo, String modoPreparacion){
        super(nombre, tipo, modoPreparacion);
        this.comidas = new ArrayList<>();
    }
    public void addComida(Comida c){
        this.comidas.add(c);
    }
    public List<Comida> getComidas(){
        return List.copyOf(this.comidas);
    }

    @Override
    public int getPrecio() {
        int retorno=0;
        for (Comida c: this.comidas)
            retorno+=c.getPrecio();
        return retorno;
    }

    @Override
    public int getCalorias() {
        int retorno=0;
        for (Comida c: this.comidas)
            retorno+=c.getCalorias();
        return retorno;
    }

    @Override
    public Time getPreparacion() {
        long retorno = 0;
        for (Comida c: this.comidas)
            retorno += c.getPreparacion().getTime();
        Time aux = new Time(retorno);
        return aux;
    }
}
