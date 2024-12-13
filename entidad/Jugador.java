package BattleTerminal;

public class Jugador extends Entidad {
    private String nombre;
    private Arma armaAsignada;
    private Arma armaActual;

    // Constructor
    public Jugador(String nombre, int vida, int ataque, int defensa, int[] posicion, Arma armaAsignada) {
        super(vida, ataque, defensa, posicion);
        this.nombre = nombre;
        this.armaAsignada = armaAsignada;
        this.armaActual = null; // Inicialmente no tiene un arma equipada
    }

    // Métodos sobrescritos
    @Override
    public void mover(int direccion) {
        switch (direccion) {
            case 0 -> posicion[0]--; // Arriba
            case 1 -> posicion[0]++; // Abajo
            case 2 -> posicion[1]--; // Izquierda
            case 3 -> posicion[1]++; // Derecha
        }
    }

    @Override
    public void usarHabilidad() {
        // Lógica específica según el tipo de jugador (implementación en subclases si es necesario)
        System.out.println(nombre + " ha usado su habilidad especial.");
    }

    // Métodos adicionales
    public void recogerArma(Arma arma) {
        this.armaActual = arma;
        if (arma.getTipo().equals(armaAsignada.getTipo())) {
            System.out.println(nombre + " ha recogido su arma asignada. Obtiene un bono de daño.");
            this.ataque += this.ataque * 0.15; // 15% de bonificación de daño
        }
    }
}
