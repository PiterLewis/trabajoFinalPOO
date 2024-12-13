package BattleTerminal;

public class Soldado extends Jugador {
    // Constructor
    public Soldado(String nombre, Coordenada posicion) {
        super(150, 30, 50, posicion, nombre);
    }

    // Implementación de la habilidad especial: Contraataque
    @Override
    public void usarHabilidad() {
        // Lógica de contraataque
        System.out.println("El soldado ejecuta su contraataque!");
    }
}
