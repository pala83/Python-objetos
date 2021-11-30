package DespachoComidas.Pagos;

import DespachoComidas.Comida;

public class Aumento implements AccionCobro{
    private int monto;

    public Aumento(int monto){
        this.monto = monto;
    }

    @Override
    public int aplicar(Comida c) {
        return (c.getPrecio() * (this.monto+100))/100;
    }
}
