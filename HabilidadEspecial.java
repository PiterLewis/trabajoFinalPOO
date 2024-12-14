// Habilidad Base
public abstract class HabilidadEspecial {
    private String nombre;

    public HabilidadEspecial(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void activar(Jugador jugador);
}
