package BattleTerminal;

public class RifleFrancotirador extends Arma {
    public RifleFrancotirador() {
        super("Rifle Francotirador", "Arma de fuego", 40, "Rifle de largo alcance, con gran daño y precisión");
    }

    public static String habilidad() {
        return "Disparo de precisión";
    }
}
