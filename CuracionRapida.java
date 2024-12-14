public class CuracionRapida extends HabilidadEspecial {
    private Integer curacion;
    
    public CuracionRapida(Integer curacion) {
        this.curacion = curacion;
    }
    
    public Integer getCuracion() {
        return curacion;
    }
    
    @Override
    public String toString() {
        return "CuracionRapida (Curacion: " + curacion + ")";
    }

}
