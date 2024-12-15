package BattleTerminal;

class Ingeniero extends Personaje {
    public Ingeniero() {
        super("Ingeniero", 110, new CanonPlasma());
    }

    @Override
    public void activarHabilidadEspecial(Jugador jugador) {
        System.out.println(jugador.getNombre() + " activa Colocar trampas: Ha colocado dos trampas en el tablero.");
    }
}
