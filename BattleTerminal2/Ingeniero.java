package BattleTerminal2;

public class Ingeniero extends Personaje {
    public Ingeniero() {
        super("Ingeniero", 110, new CanionPlasma("Cañón de Plasma", 100));
    }

    @Override
    public void activarHabilidadEspecial(Jugador jugador) {
        System.out.println(jugador.getNombre() + " coloca trampas que dañan al enemigo al moverse cerca.");
    }
}
