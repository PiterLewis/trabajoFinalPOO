public class Contraataque extends HabilidadEspecial {
    private Integer danio;
    
    public Contraataque(Integer danio) {
        this.danio = danio;
    }
    
    public Integer getDanio() {
        return danio;
    }
    
    @Override
    public String toString() {
        return "Contraataque (Daño: " + danio + ")";
    }

}
