// Clase base para objetos
abstract class Objeto {
    protected String tipo;
    protected Integer[] posicion;

    public Objeto(String tipo, Integer[] posicion) {
        this.tipo = tipo;
        this.posicion = posicion;
    }

    public abstract void usar(Entidad entidad);

    public String getTipo() {
        return tipo;
    }

    public Integer[] getPosicion() {
        return posicion;
    }
}
