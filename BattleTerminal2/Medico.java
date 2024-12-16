package BattleTerminal2;

public class Medico extends Personaje {
    public Medico() {
        super("Médico", 120, new RifleFrancotirador());
    }

    @Override
    public void activarHabilidadEspecial(Jugador jugador) {
        jugador.recibirDano(-50); // Cura 50 puntos de vida
        System.out.println(jugador.getNombre() + " activa Curación Rápida: Recupera 50 puntos de vida.");
    }
}
