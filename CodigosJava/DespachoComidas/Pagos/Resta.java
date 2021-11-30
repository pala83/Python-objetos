package DespachoComidas.Pagos;

import DespachoComidas.Comida;

public class Resta implements AccionCobro{
    private int monto;

    public Resta(int monto){
        this.monto = monto;
    }

    @Override
    public int aplicar(Comida c) {
        return c.getPrecio() - this.monto;
    }
}
