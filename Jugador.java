// Clase Jugador
class Jugador extends Entidad {
    private String personaje;
    private Arma arma;
    private Boolean habilidadEspecialDisponible;

    public Jugador(String nombre, Integer vida, Integer[] posicion, String personaje) {
        super(nombre, vida, posicion);
        this.personaje = personaje;
        this.habilidadEspecialDisponible = true;
    }

    public void usarHabilidadEspecial() {
        if (habilidadEspecialDisponible) {
            System.out.println("Habilidad especial usada: " + personaje);
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
}
