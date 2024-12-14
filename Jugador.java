// Clase Jugador
class Jugador extends Entidad {
    private String personaje;
    private Arma arma;
    private Boolean habilidadEspecialDisponible;
    private int vidaMaxima;

    public Jugador(String nombre, Integer vida, Integer[] posicion, String personaje) {
        super(nombre, vida, posicion);
        this.personaje = personaje;
        this.habilidadEspecialDisponible = true;
        this.vidaMaxima = vida; // La vida inicial también es la máxima
    }

    public void usarHabilidadEspecial(HabilidadEspecial habilidad) {
        if (habilidadEspecialDisponible) {
            habilidad.activar(this);
            habilidadEspecialDisponible = false;
        } else {
            System.out.println("Habilidad especial no disponible.");
        }
    }

    public void equiparArma(Arma nuevaArma) {
        this.arma = nuevaArma;
    }

    public Arma getArma() {
        return arma;
    }

    public String getPersonaje() {
        return personaje;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setHabilidadEspecialDisponible(Boolean disponible) {
        this.habilidadEspecialDisponible = disponible;
    }
}
