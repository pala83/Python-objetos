package DespachoComidas.Pagos;

import DespachoComidas.Comida;

public class Descuento implements AccionCobro{
    private int monto;

    public Descuento(int monto){
        this.monto = monto;
    }

    @Override
    public int aplicar(Comida c) {
        return (c.getPrecio() * (100-this.monto))/100;
    }
}
