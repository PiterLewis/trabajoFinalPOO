package BattleTerminal;

class Explorador extends Personaje {
    public Explorador() {
        super("Explorador", 100, new Escopeta());
    }

    @Override
    public void activarHabilidadEspecial(Jugador jugador) {
        System.out.println(jugador.getNombre() + " activa Movimiento rápido: Puede moverse dos veces en la siguiente ronda.");
    }
}
