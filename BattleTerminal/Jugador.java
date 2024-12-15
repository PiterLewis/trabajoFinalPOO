package BattleTerminal;

class Jugador extends Entidad {
    private Personaje personaje;
    private Arma arma;
    private boolean habilidadEspecialDisponible = true;

    public Jugador(String nombre, Personaje personaje) {
        super(nombre, personaje.getVidaInicial(), null);
        this.personaje = personaje;
        this.arma = personaje.getArmaInicial();
    }

    public void usarHabilidadEspecial() {
        if (habilidadEspecialDisponible) {
            personaje.activarHabilidadEspecial(this);
            habilidadEspecialDisponible = false;
        } else {
            System.out.println("La habilidad especial no está disponible todavía.");
        }
    }

    public void equiparArma(Arma nuevaArma) {
        this.arma = nuevaArma;
    }

    public void atacar(Jugador enemigo) {
        if (arma != null) {
            int dano = arma.getDano();
            if (arma.equals(personaje.getArmaInicial())) {
                dano += dano * 0.15; // Bonificación por arma del personaje
            }
            enemigo.recibirDano(dano);
            System.out.println(nombre + " atacó a " + enemigo.nombre + " con " + arma.getNombre() + " (Daño: " + dano + ").");
        } else {
            System.out.println("No tienes un arma equipada para atacar.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Arma getArma() {
        return arma;
    }

    public String getLetraRepresentativa() {
        return nombre.substring(0, 1).toUpperCase();  // Retorna la primera letra del nombre del jugador
    }
}
