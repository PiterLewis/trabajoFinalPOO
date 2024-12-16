package BattleTerminal;

public class Trampa {

    private int dano;

    public Trampa(int dano) {
        this.dano = dano;
    }

    public void activar(Jugador jugador) {
        jugador.recibirDano(dano);
        System.out.println("Trampa activada! " + jugador.getNombre() + " recibe " + dano + " de daño.");
    }
}
