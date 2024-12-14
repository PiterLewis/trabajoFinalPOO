// Movimiento Rápido
public class MovimientoRapido extends HabilidadEspecial {

    public MovimientoRapido() {
        super("Movimiento Rápido");
    }

    @Override
    public void activar(Jugador jugador) {
        System.out.println(jugador.getNombre() + " puede moverse dos veces en esta ronda.");
        jugador.setMovimientosExtra(1); // Permitir un movimiento adicional
    }
}
