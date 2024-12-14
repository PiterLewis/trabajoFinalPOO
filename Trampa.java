// Clase Trampa que hereda de Objeto
public class Trampa extends Objeto {
    private int dano;

    public Trampa(int dano, int x, int y) {
        super("Trampa", x, y);
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    @Override
    public void usar(Jugador jugador) {
        jugador.recibirDano(dano);
        System.out.println(jugador.getNombre() + " ha recibido " + dano + " de daño al activar una trampa.");
    }
}
