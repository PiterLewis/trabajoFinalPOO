package BattleTerminal;

class Soldado extends Personaje {
    public Soldado() {
        super("Soldado", 150, new Fusil());
    }

    @Override
    public void activarHabilidadEspecial(Jugador jugador) {
        System.out.println(jugador.getNombre() + " activa Contraataque: Devolverá parte del daño recibido en el siguiente turno.");
    }
}