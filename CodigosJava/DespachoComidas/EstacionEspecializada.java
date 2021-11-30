package DespachoComidas;

import DespachoComidas.Criterios.Criterio;

import java.util.ArrayList;
import java.util.List;

public class EstacionEspecializada extends GestorEstaciones {
    private Criterio especialidad;
    private String esp;

    public EstacionEspecializada(Criterio especialidad, String esp){
        this.especialidad = especialidad;
        this.esp = esp;
    }

    public void setEsp(String esp) { this.esp = esp; }

    public void cambiarEspecialidad(Criterio nuevo, String nuevaEsp) {
        this.especialidad = nuevo;
        this.esp = nuevaEsp;
        List<Comida> nueva = new ArrayList<>();
        for (Comida c: comidas){
            if (especialidad.cumple(c))
                nueva.add(c);
        }
        this.comidas = nueva;
    }

    @Override
    public String getNombre() {
        return super.getNombre() + this.esp;
    }

    @Override
    public void add(Comida comida) {
        if (this.especialidad.cumple(comida))
            this.comidas.add(comida);
    }
}
