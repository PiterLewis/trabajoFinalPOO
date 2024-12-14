class Jugador extends Entidad {
    private String personaje;
    private Arma arma;
    private boolean habilidadEspecialDisponible;
    private int vidaMaxima;
    private int movimientosExtra;

    public Jugador(String nombre, int vida, Integer[] posicion, String personaje) {
        super(nombre, vida, posicion);
        this.personaje = personaje;
        this.habilidadEspecialDisponible = true;
        this.vidaMaxima = vida; // La vida inicial también es la máxima
        this.movimientosExtra = 0;
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

    public void setHabilidadEspecialDisponible(boolean disponible) {
        this.habilidadEspecialDisponible = disponible;
    }

    public boolean getHabilidadEspecialDisponible() {
        return habilidadEspecialDisponible;
    }

    public void setVida(int nuevaVida) {
        if (nuevaVida > vidaMaxima) {
            nuevaVida = vidaMaxima;
        }
        super.setVida(nuevaVida);
    }

    public int getMovimientosExtra() {
        return movimientosExtra;
    }

    public void setMovimientosExtra(int movimientosExtra) {
        this.movimientosExtra = movimientosExtra;
    }
}
