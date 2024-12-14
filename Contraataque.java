// Contraataque
public class Contraataque extends HabilidadEspecial {
    private static final double PORCENTAJE_DANO_DEVUELTO = 0.3;

    public Contraataque() {
        super("Contraataque");
    }

    @Override
    public void activar(Jugador jugador) {
        System.out.println(jugador.getNombre() + " ha activado Contraataque.");
        // Se implementará en combate para devolver el daño
    }

    public int calcularDanoDevuelto(int danoRecibido) {
        return (int) (danoRecibido * PORCENTAJE_DANO_DEVUELTO);
    }
}
