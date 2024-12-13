package BattleTerminal.entidad;

public class Ingeniero extends Jugador {

    public Ingeniero(String nombre) {
        super(nombre, 110, 25, "Trampa explosiva");
    }

    @Override
    public void usarHabilidad() {
        System.out.println(getNombre() + " coloca una trampa explosiva.");
        // Implementación específica de la trampa
    }
}
