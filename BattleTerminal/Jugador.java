package BattleTerminal;

public class Jugador {
    private String nombre;
    private int vida;
    private int[] posicion;  // [x, y]
    private Arma arma;
    private Habilidad habilidad;

    public Jugador(String nombre, int vida, Arma arma, Habilidad habilidad) {
        this.nombre = nombre;
        this.vida = vida;
        this.posicion = new int[]{-1, -1};  // Inicialmente fuera del tablero
        this.arma = arma;
        this.habilidad = habilidad;
    }

    public void recibirDano(int cantidad) {
        vida -= cantidad;
        System.out.println(nombre + " ha recibido " + cantidad + " de daño. Vida restante: " + vida);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void setPosicion(int x, int y) {
        this.posicion = new int[]{x, y};
    }

    public int getVida() {
        return vida;
    }

    public Arma getArma() {
        return arma;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void activarHabilidad() {
        if (!habilidad.isDisponible()) {
            habilidad.setDisponible(true);
            System.out.println(habilidad.getNombre() + " está ahora activada.");
        } else {
            System.out.println("La habilidad ya está activada.");
        }
    }
}

