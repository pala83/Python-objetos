package DespachoComidas.Criterios;

import DespachoComidas.Comida;

public class CriterioMenorCaloria implements Criterio{
    private int calorias;

    public CriterioMenorCaloria(int cal){
        calorias = cal;
    }

    public int getCalorias() { return this.calorias; }
    public void setCalorias(int calorias) { this.calorias = calorias; }

    @Override
    public boolean cumple(Comida comida) {
        return comida.getCalorias() < this.calorias;
    }
}
