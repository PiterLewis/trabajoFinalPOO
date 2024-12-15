package BattleTerminal;

abstract class Arma extends Objeto {
    protected int dano;

    public Arma(String nombre, int dano) {
        super(nombre, null);
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }
}