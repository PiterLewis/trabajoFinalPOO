abstract class Entidad {
    protected String nombre;
    protected int vida;
    protected Integer[] posicion; // [x, y]

    public Entidad(String nombre, int vida, Integer[] posicion) {
        this.nombre = nombre;
        this.vida = vida;
        this.posicion = posicion;
    }

    public void mover(Integer[] nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    public void recibirDano(int cantidad) {
        this.vida = Math.max(this.vida - cantidad, 0);
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public Integer[] getPosicion() {
        return posicion;
    }

    public void setVida(int nuevaVida) {
        this.vida = nuevaVida;
    }
}
