package DespachoComidas.Criterios;

import DespachoComidas.Comida;

public class CriterioModPrep implements Criterio{
    private String modPreparacion;

    public CriterioModPrep(String modPreparacion){
        this.modPreparacion = modPreparacion;
    }

    public String getModPreparacion() { return this.modPreparacion; }
    public void setModPreparacion(String modPreparacion) { this.modPreparacion = modPreparacion; }

    @Override
    public boolean cumple(Comida comida) {
        return comida.getModoPreparacion().equals(this.modPreparacion);
    }
}
