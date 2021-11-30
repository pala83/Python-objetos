package DespachoComidas.Criterios;

import DespachoComidas.Comida;

import java.sql.Time;

public class CriterioMenorTiempo implements Criterio{
    private Time tiempo;

    public CriterioMenorTiempo(Time tiempo){
        this.tiempo = tiempo;
    }

    public Time getTiempo() { return this.tiempo; }
    public void setTiempo(Time tiempo) { this.tiempo = tiempo; }

    @Override
    public boolean cumple(Comida comida) {
        return comida.getPreparacion().getTime() < this.tiempo.getTime();
    }
}
