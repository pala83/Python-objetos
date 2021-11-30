package DespachoComidas.Criterios;

import DespachoComidas.Comida;

public class CriterioAnd implements Criterio{
    private Criterio c1, c2;

    public CriterioAnd(Criterio c1, Criterio c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public boolean cumple(Comida comida) {
        return (this.c1.cumple(comida)&&this.c2.cumple(comida));
    }
}
