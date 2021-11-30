package DespachoComidas.Pagos;

import DespachoComidas.Comida;

public class Suma implements AccionCobro{
    private int monto;

    public Suma(int monto){
        this.monto = monto;
    }

    @Override
    public int aplicar(Comida c) {
        return c.getPrecio() + this.monto;
    }
}
