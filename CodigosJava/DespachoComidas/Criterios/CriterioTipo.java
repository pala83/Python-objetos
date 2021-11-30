package DespachoComidas.Criterios;

import DespachoComidas.Comida;

public class CriterioTipo implements Criterio{
    private String tipo;

    public CriterioTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() { return this.tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public boolean cumple(Comida comida) {
        return (comida.getTipo().equals(this.tipo));
    }
}
