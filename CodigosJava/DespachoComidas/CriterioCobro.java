package DespachoComidas;

import DespachoComidas.Criterios.Criterio;
import DespachoComidas.Pagos.AccionCobro;

public class CriterioCobro {
    private Criterio criterio;
    private int monto;
    private AccionCobro accion;

    public CriterioCobro(Criterio criterio, int monto, AccionCobro accion){
        this.criterio = criterio;
        this.monto = monto;
        this.accion = accion;
    }

    public Criterio getCriterio() { return this.criterio; }
    public void setCriterio(Criterio criterio) { this.criterio = criterio; }
    public int getMonto() { return this.monto; }
    public void setMonto(int monto) { this.monto = monto; }
    public AccionCobro getAccion() { return this.accion; }
    public void setAccion(AccionCobro accion) { this.accion = accion; }

}
