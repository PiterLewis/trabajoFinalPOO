package BattleTerminal;

public class Jugador extends Entidad {
    private Arma arma;
    private Habilidad habilidad;
    private int[] posicion;

    public Jugador(String nombre, int vida, Arma arma, Habilidad habilidad) {
        super(nombre, vida, 0, 0); // Posición inicial en (0,0)
        this.arma = arma;
        this.habilidad = habilidad;
        this.posicion = new int[]{0, 0}; // Asegurar posición válida
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setPosicion(int x, int y) {
        this.posicion = new int[]{x, y};
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void activarHabilidad() {
        if (!habilidad.isDisponible()) {
            habilidad.setDisponible(true);
            System.out.println("Habilidad activada: " + habilidad.getNombre());
        } else {
            System.out.println("La habilidad ya está activada.");
        }
    }
}
