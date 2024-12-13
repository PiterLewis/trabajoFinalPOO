package BattleTerminal;

public class Ingeniero extends Jugador {
    // Constructor
    public Ingeniero(String nombre, Coordenada posicion) {
        super(110, 25, 35, posicion, nombre);
    }

    // Implementación de la habilidad especial: Colocar trampa
    @Override
    public void usarHabilidad() {
        System.out.println("El ingeniero coloca una trampa explosiva.");
    }
}
