package DespachoComidas;

import java.util.ArrayList;
import java.util.List;

public abstract class GestorEstaciones {
    protected List<Comida> comidas;
    protected String nombre = "Estacion: ";

    public GestorEstaciones(){
        this.comidas = new ArrayList<>();
    }
    public String getNombre() { return this.nombre; }
    public List<Comida> getComidas(){ return List.copyOf(this.comidas); }

    public abstract void add(Comida comida);

}
