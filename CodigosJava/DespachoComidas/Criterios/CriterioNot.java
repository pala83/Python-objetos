package DespachoComidas.Criterios;

import DespachoComidas.Comida;

public class CriterioNot implements Criterio{
    private Criterio c1;

    public CriterioNot(Criterio c1){
        this.c1 = c1;
    }

    public Criterio getC1() { return this.c1; }
    public void setC1(Criterio c1) { this.c1 = c1; }

    @Override
    public boolean cumple(Comida comida) {
        return !this.c1.cumple(comida);
    }
}
