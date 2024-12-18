package BattleTerminal;

public class Ingeniero extends Jugador {
    public Ingeniero(String nombre) {
        super(nombre, 80, 
              new Arma("Cañón de Plasma", "Explosivo", 100, "Dispara proyectiles de plasma"), 
              new Habilidad("Colocar trampas", true));
    }
}
