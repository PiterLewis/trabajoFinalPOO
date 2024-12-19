package BattleTerminal5;

public class Soldado extends Personaje {

    public Soldado() {
        super("Soldado", 150, new Fusil("Fusil de Asalto", 80));
    }

    @Override
    public void activarHabilidadEspecial(Jugador jugador) {
        System.out.println(jugador.getNombre() + " activa Contraataque: Parte del daño será devuelto.");
    }
}
