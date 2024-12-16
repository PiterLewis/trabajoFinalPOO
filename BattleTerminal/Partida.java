package BattleTerminal;

import java.util.List;
import java.util.Scanner;

public class Partida {
    private List<Jugador> jugadores;
    private Tablero tablero;

    public Partida(List<Jugador> jugadores, Tablero tablero) {
        this.jugadores = jugadores;
        this.tablero = tablero;
    }

    public void iniciarJuego() {
        System.out.println("¡La partida ha comenzado!");
    }

    public void realizarAccion(Jugador jugador, Scanner sc) {
        // Mostrar información del jugador
        System.out.println("\nTurno de " + jugador.getNombre() + ":");
        System.out.println("Vida: " + jugador.getVida());
        System.out.println("Arma: " + jugador.getArma().getNombre() + " - " + jugador.getArma().getDescripcion() + " - Daño: " + jugador.getArma().getDano());

        // Mostrar habilidades disponibles
        if (jugador.getHabilidad() != null) {
            System.out.println("Habilidad: " + jugador.getHabilidad().getNombre());
            if (jugador.getHabilidad().isDisponible()) {
                System.out.println("La habilidad está activada y disponible para usar.");
            } else {
                System.out.println("La habilidad no está activada.");
            }
        }

        // Elegir acción: Moverse, Atacar o Usar habilidad
        System.out.println("Selecciona una acción:");
        System.out.println("1. Moverse (W: Arriba, S: Abajo, A: Izquierda, D: Derecha)");
        System.out.println("2. Atacar");
        System.out.println("3. Usar habilidad");

        int accion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        switch (accion) {
            case 1:
                moverJugador(jugador, sc);
                break;
            case 2:
                atacarJugador(jugador, sc);
                break;
            case 3:
                jugador.activarHabilidad();  // Activar habilidad especial
                break;
            default:
                System.out.println("Acción no válida. Esperando turno...");
                break;
        }
    }

    private void moverJugador(Jugador jugador, Scanner sc) {
        System.out.println("Selecciona la dirección para moverte (W: Arriba, S: Abajo, A: Izquierda, D: Derecha): ");
        char direccion = sc.nextLine().toUpperCase().charAt(0);

        int[] posicion = jugador.getPosicion();
        switch (direccion) {
            case 'W':  // Arriba
                if (posicion[0] > 0) posicion[0]--;
                break;
            case 'S':  // Abajo
                if (posicion[0] < tablero.getSize() - 1) posicion[0]++;
                break;
            case 'A':  // Izquierda
                if (posicion[1] > 0) posicion[1]--;
                break;
            case 'D':  // Derecha
                if (posicion[1] < tablero.getSize() - 1) posicion[1]++;
                break;
            default:
                System.out.println("Dirección no válida.");
                return;
        }

        System.out.println(jugador.getNombre() + " se ha movido hacia " + direccion + ".");
    }

    private void atacarJugador(Jugador atacante, Scanner sc) {
        System.out.println("¿A quién deseas atacar?");
        for (Jugador j : jugadores) {
            if (j != atacante && j.estaVivo()) {
                System.out.println("- " + j.getNombre());
            }
        }

        String nombreAtacado = sc.nextLine();
        for (Jugador j : jugadores) {
            if (j.getNombre().equals(nombreAtacado) && j.estaVivo()) {
                int dano = atacante.getArma().getDano();
                j.recibirDano(dano);
                System.out.println(atacante.getNombre() + " ha atacado a " + j.getNombre() + " causando " + dano + " de daño.");
                break;
            }
        }
    }

    public void mostrarGanador() {
        if (jugadores.size() == 1) {
            System.out.println("El ganador es: " + jugadores.get(0).getNombre());
        } else {
            System.out.println("¡Todos los jugadores han caído! No hay ganador.");
        }
    }
}

