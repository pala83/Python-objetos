package DespachoComidas;

public class EstacionPDefecto extends GestorEstaciones{

    public EstacionPDefecto(){
        this.nombre += "POR DEFECTO";
    }

    @Override
    public void add(Comida comida) {
        comidas.add(comida);
    }
}
