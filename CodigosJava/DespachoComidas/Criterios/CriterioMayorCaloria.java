package DespachoComidas.Criterios;

import DespachoComidas.Comida;

public class CriterioMayorCaloria implements Criterio{
    private int calorias;

    public CriterioMayorCaloria(int cal){
        calorias = cal;
    }

    public int getCalorias() { return this.calorias; }
    public void setCalorias(int calorias) { this.calorias = calorias; }

    @Override
    public boolean cumple(Comida comida) {
        return comida.getCalorias() > this.calorias;
    }
}
