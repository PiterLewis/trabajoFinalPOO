package BattleTerminal4;

public class Explorador extends Personaje {
    public Explorador() {
        super("Explorador", 100, new Escopeta("Escopeta", 60));
    }

    @Override
    public void activarHabilidadEspecial(Jugador jugador) {
        System.out.println(jugador.getNombre() + " activa Movimiento Rápido: Puede moverse dos veces en un turno.");
    }
}
