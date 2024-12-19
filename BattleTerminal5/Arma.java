package BattleTerminal5;

public abstract class Arma extends Objeto {
    protected Integer dano;
    

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