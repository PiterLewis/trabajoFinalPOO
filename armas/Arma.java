package BattleTerminal;

public class Arma {
    private String tipo;
    private int daño;

    public Arma(String tipo, int daño) {
        this.tipo = tipo;
        this.daño = daño;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDaño() {
        return daño;
    }
}
