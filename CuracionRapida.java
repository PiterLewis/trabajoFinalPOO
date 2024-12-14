// Curación Rápida
public class CuracionRapida extends HabilidadEspecial {

    public CuracionRapida() {
        super("Curación Rápida");
    }

    @Override
    public void activar(Jugador jugador) {
        int vidaRestaurada = jugador.getVidaMaxima();
        jugador.setVida(vidaRestaurada);
        System.out.println(jugador.getNombre() + " se ha curado completamente (" + vidaRestaurada + " HP). ");
    }
}
