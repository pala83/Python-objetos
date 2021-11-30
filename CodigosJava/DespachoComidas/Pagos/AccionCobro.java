package DespachoComidas.Pagos;

import DespachoComidas.Comida;

public interface AccionCobro {
    int aplicar(Comida c);
}
