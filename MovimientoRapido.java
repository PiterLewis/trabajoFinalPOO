public class MovimientoRapido extends HabilidadEspecial {
    private Integer velocidad;
    
    public MovimientoRapido(Integer velocidad) {
        this.velocidad = velocidad;
    }
    
    public Integer getVelocidad() {
        return velocidad;
    }
    
    @Override
    public String toString() {
        return "MovimientoRapido (Velocidad: " + velocidad + ")";
    }

}
