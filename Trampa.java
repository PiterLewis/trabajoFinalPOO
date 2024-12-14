public class Trampa extends Objeto{
    private String tipo;
    private Integer danio;
    
    public Trampa(String tipo, Integer danio) {
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
