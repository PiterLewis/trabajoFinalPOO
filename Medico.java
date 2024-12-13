package BattleTerminal;

public class Medico extends Jugador {
    // Constructor
    public Medico(String nombre, Coordenada posicion) {
        super(120, 15, 40, posicion, nombre);
    }

    // Implementación de la habilidad especial: Curación rápida
    @Override
    public void usarHabilidad() {
        System.out.println("El médico usa su curación rápida para restaurar vida.");
    }
}
