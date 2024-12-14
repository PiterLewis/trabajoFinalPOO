
public abstract class Arma extends Objeto{
	protected String tipo;
    protected Integer danio;

    public Arma(String tipo, Integer danio) {
        this.tipo = tipo;
        this.danio = danio;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getDanio() {
        return danio;
    }

    @Override
    public String toString() {
        return tipo + " (Daño: " + danio + ")";
    }

	
}
