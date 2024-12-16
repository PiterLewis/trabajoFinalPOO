package BattleTerminal2;

public class Fusil extends Arma {
    public Fusil() {
        super("Fusil", 40);  // Valores por defecto
    }

    public Fusil(String nombre, Integer danioBase) {
        super(nombre, danioBase);
    }
}
