package BattleTerminal;

public class Explorador extends Jugador {
    public Explorador(String nombre) {
        super(nombre, 80, 
              new Arma("Cuchillo", "Cuerpo a cuerpo", 10, "Arma ligera para combate rápido"), 
              new Habilidad("Movimiento Rápido", false));
    }
}
