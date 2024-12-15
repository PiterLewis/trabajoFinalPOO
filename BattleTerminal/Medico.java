package BattleTerminal;

class Medico extends Personaje {
    public Medico() {
        super("Médico", 120, new RifleFrancotirador());
    }

    @Override
    public void activarHabilidadEspecial(Jugador jugador) {
        jugador.recibirDano(-100); // Cura completa
        System.out.println(jugador.getNombre() + " activa Curación rápida: Ha recuperado toda su vida.");
    }
}
