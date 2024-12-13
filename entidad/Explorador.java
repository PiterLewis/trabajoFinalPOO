package BattleTerminal.entidad;

public class Explorador extends Jugador {

    public Explorador(String nombre) {
        super(nombre, 100, 20, "Cuchillo");
    }

    @Override
    public void usarHabilidad() {
        System.out.println(getNombre() + " usa Movimiento Rápido y se mueve dos veces.");
        // Implementación específica del movimiento rápido
    }
}
