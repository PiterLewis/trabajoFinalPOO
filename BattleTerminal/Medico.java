package BattleTerminal;

public class Medico extends Jugador {
    public Medico(String nombre) {
        super(nombre, 90, 
              new Arma("Rifle Francotirador", "Francotirador", 90, "Rifle de largo alcance"), 
              new Habilidad("Curación Rápida", true));
    }
}
