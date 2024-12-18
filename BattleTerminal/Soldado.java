package BattleTerminal;

public class Soldado extends Jugador {
    public Soldado(String nombre) {
        super(nombre, 100, 
              new Arma("Fusil", "Arma de fuego", 50, "Fusil automático estándar"), 
              new Habilidad("Disparo preciso", false));
    }
}
