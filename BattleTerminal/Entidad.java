package BattleTerminal;

public abstract class Entidad {
    protected String nombre;
    protected int vida;
    protected int[] posicion;

    public Entidad(String nombre, int vida, int x, int y) {
        this.nombre = nombre;
        this.vida = vida;
        this.posicion = new int[]{x, y};
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDano(int cantidad) {
        vida -= cantidad;
        System.out.println(nombre + " ha recibido " + cantidad + " de daño. Vida restante: " + vida);
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
