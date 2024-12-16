package BattleTerminal2;

public abstract class Arma extends Objeto {
    protected Integer dano;
    private String nombre;

    public Arma(String nombre, int dano) {
        super(nombre, null);
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    public String getNombre() {
        return nombre;
    }
}