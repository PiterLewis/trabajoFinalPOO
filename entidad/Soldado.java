package BattleTerminal.entidad;

public class Soldado extends Jugador {

    public Soldado(String nombre) {
        super(nombre, 150, 30, "Fusil");
    }

    @Override
    public void usarHabilidad() {
        System.out.println(getNombre() + " usa Contraataque, devolviendo parte del daño recibido.");
        // Implementación específica del contraataque
    }
}
