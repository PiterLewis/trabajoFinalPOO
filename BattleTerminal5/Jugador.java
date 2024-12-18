package BattleTerminal5;

public class Jugador extends Entidad {
    private Personaje personaje;
    private Arma arma;

    public Jugador(String nombre, Personaje personaje) {
        super(nombre, personaje.getVidaInicial(), new int[]{0, 0});
        this.personaje = personaje;
        this.arma = personaje.getArmaInicial();
    }

    public void mover(int[] nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    public void atacar(Jugador enemigo) {
        if (arma != null) {
            int dano = arma.getDano();
            enemigo.recibirDano(dano);
            System.out.println(nombre + " ataca a " + enemigo.getNombre() + " con " + arma.getNombre());
        }
    }

    public void usarHabilidadEspecial() {
        personaje.activarHabilidadEspecial(this);
    }

    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }
}
