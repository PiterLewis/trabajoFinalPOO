// Subclase de objeto: Arma
public abstract class Arma extends Objeto {
    protected Integer dano;

    public Arma(String tipo, Integer[] posicion, Integer dano) {
        super(tipo, posicion);
        this.dano = dano;
    }

    public Integer getDano() {
        return dano;
    }

    @Override
    public void usar(Entidad entidad) {
        System.out.println("Usando " + tipo + " para atacar.");
    }
}
