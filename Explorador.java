package BattleTerminal;

public class Explorador extends Jugador {
    // Constructor
    public Explorador(String nombre, Coordenada posicion) {
        super(100, 20, 30, posicion, nombre);
    }

    // Implementación de la habilidad especial: Movimiento rápido
    @Override
    public void usarHabilidad() {
        System.out.println("El explorador usa su movimiento rápido, puede moverse dos veces.");
    }
}
