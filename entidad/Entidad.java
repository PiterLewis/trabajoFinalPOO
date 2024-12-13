package BattleTerminal;

// Clase abstracta Entidad
public abstract class Entidad {
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int[] posicion; // Coordenadas {fila, columna}

    // Constructor
    public Entidad(int vida, int ataque, int defensa, int[] posicion) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.posicion = posicion;
    }

    // Métodos comunes
    public boolean esVivo() {
        return vida > 0;
    }

    public void recibirDaño(int daño) {
        int dañoReducido = Math.max(0, daño - defensa);
        vida -= dañoReducido;
        if (vida < 0) {
            vida = 0;
        }
    }

    // Métodos abstractos
    public abstract void mover(int direccion);

    public abstract void usarHabilidad();
}
