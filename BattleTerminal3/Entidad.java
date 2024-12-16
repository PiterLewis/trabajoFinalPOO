package BattleTerminal;

public abstract class Entidad {
    protected String nombre;
    protected int vida;
    protected int[] posicion; // [x, y]

    public Entidad(String nombre, int vida, int x, int y) {
        this.nombre = nombre;
        this.vida = vida;
        this.posicion = new int[] {x, y};
    }

    public abstract void recibirDano(int cantidad);

    public boolean estaVivo() {
        return vida > 0;
    }

    public void mover(int x, int y) {
        this.posicion[0] = x;
        this.posicion[1] = y;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }
}
