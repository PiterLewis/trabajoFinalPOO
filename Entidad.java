package BattleTerminal;

public abstract class Entidad {
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected Coordenada posicion;

    // Constructor
    public Entidad(int vida, int ataque, int defensa, Coordenada posicion) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.posicion = posicion;
    }

    // Métodos abstractos que deben implementarse en las subclases
    public abstract void mover(int direccion);  // Moverse en el tablero
    public abstract void usarHabilidad();      // Usar habilidad especial

    // Métodos comunes
    public void atacar(Entidad objetivo) {
        int dañoReal = this.ataque - objetivo.defensa;
        if (dañoReal > 0) {
            objetivo.recibirDaño(dañoReal);
        }
    }

    public void recibirDaño(int daño) {
        this.vida = Math.max(0, this.vida - daño);  // Evitar que la vida sea negativa
    }

    public boolean esVivo() {
        return this.vida > 0;
    }

    // Getters y setters
    public Coordenada getPosicion() {
        return posicion;
    }

    public void setPosicion(Coordenada posicion) {
        this.posicion = posicion;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
}
