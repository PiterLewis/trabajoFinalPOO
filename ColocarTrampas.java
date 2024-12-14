public class ColocarTrampas extends HabilidadEspecial {
    private Integer dano;
    
    public ColocarTrampas(Integer dano) {
        this.dano = dano;
    }
    
    public Integer getDano() {
        return dano;
    }
    
    @Override
    public String toString() {
        return "ColocarTrampa (Daño: " + dano + ")";
    }

}
