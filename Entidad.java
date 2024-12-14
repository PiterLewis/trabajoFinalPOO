// Clase base para cualquier entidad del juego
abstract class Entidad {
    protected String nombre;
    protected Integer vida;
    protected Integer[] posicion; // [x, y]

    public Entidad(String nombre, Integer vida, Integer[] posicion) {
        this.nombre = nombre;
        this.vida = vida;
        this.posicion = posicion;
    }

    public void mover(Integer[] nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    public void recibirDano(Integer cantidad) {
        this.vida = Math.max(this.vida - cantidad, 0);
    }

    public Boolean estaVivo() {
        return this.vida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getVida() {
        return vida;
    }

    public Integer[] getPosicion() {
        return posicion;
    }
}
