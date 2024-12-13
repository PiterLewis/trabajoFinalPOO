package BattleTerminal;

public class Jugador extends Entidad {
    protected String nombre;  // Nombre del jugador (opcional)
    protected Arma arma;      // Arma equipada

    // Constructor
    public Jugador(int vida, int ataque, int defensa, Coordenada posicion, String nombre) {
        super(vida, ataque, defensa, posicion);
        this.nombre = nombre;
        this.arma = null;  // Al principio no tiene arma
    }

    // Implementación de métodos abstractos
    @Override
    public void mover(int direccion) {
        // Lógica de movimiento según la dirección (0: Arriba, 1: Abajo, 2: Izquierda, 3: Derecha)
        switch (direccion) {
            case 0: // Arriba
                this.posicion.setY(this.posicion.getY() - 1);
                break;
            case 1: // Abajo
                this.posicion.setY(this.posicion.getY() + 1);
                break;
            case 2: // Izquierda
                this.posicion.setX(this.posicion.getX() - 1);
                break;
            case 3: // Derecha
                this.posicion.setX(this.posicion.getX() + 1);
                break;
        }
    }

    @Override
    public void usarHabilidad() {
        // La habilidad del jugador puede implementarse en las subclases
    }

    // Método para recoger un arma
    public void recogerArma(Arma arma) {
        this.arma = arma;
        this.ataque += arma.getDaño();  // Incrementar el ataque con el arma recogida
    }

    public String getNombre() {
        return nombre;
    }

    public Arma getArma() {
        return arma;
    }
}
