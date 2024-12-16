package BattleTerminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String file
        // Introducción al juego
        System.out.println("Bienvenido a Battle Terminal!");
        System.out.println("Este es un juego de batalla por turnos en el que cada jugador tiene una serie de acciones.");

        // Solicitar el número de jugadores
        int numJugadores;
        do {
            System.out.print("¿Cuántos jugadores van a participar? (Entre 1 y 4): ");
            numJugadores = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
        } while (numJugadores < 1 || numJugadores > 4);

        // Crear lista de jugadores
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Ingrese el nombre del Jugador " + (i + 1) + ": ");
            String nombre = sc.nextLine();

            // Seleccionar tipo de jugador
            System.out.println("Selecciona el tipo de jugador para " + nombre + ":");
            System.out.println("1. Soldado");
            System.out.println("2. Explorador");
            System.out.println("3. Médico");
            System.out.println("4. Ingeniero");

            int tipo = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            Jugador jugador = crearJugador(nombre, tipo);
            jugadores.add(jugador);
        }

        // Crear el tablero
        Tablero tablero = new Tablero(12);

        // Ubicar a los jugadores en posiciones aleatorias
        Random rand = new Random();
        for (Jugador jugador : jugadores) {
            int x = rand.nextInt(tablero.getBoardSize());
            int y = rand.nextInt(tablero.getBoardSize());
            jugador.setPosicion(x, y);  // Asignar posición aleatoria
        }

        // Mostrar la GUI inicial
        tablero.mostrarTableroGUI(jugadores);

        // Crear la partida
        Partida partida = new Partida(jugadores, tablero);
        partida.iniciarJuego();

        // Ciclo de turnos
        int ronda = 1;
        while (jugadores.size() > 1) {
            System.out.println("\n--- Ronda " + ronda + " ---");
            tablero.volcarTextoAFichero("--- Ronda " + ronda + " ---", "volcado.txt");

            // Actualizar GUI y mostrar tablero en cada turno
            tablero.actualizarGUI(jugadores);

            List<Jugador> jugadoresEliminados = new ArrayList<>();
            for (Jugador jugador : jugadores) {
                if (jugador.estaVivo()) {
                    System.out.println("\nTurno de " + jugador.getNombre());
                    tablero.volcarTextoAFichero("Turno de " + jugador.getNombre(), "volcado.txt");

                    partida.realizarAccion(jugador, sc);

                    // Actualizar GUI y volcar estado al fichero
                    tablero.actualizarGUI(jugadores);
                    tablero.volcarTextoAFichero("Tablero después del turno de " + jugador.getNombre(), "volcado.txt");

                    if (!jugador.estaVivo()) {
                        System.out.println(jugador.getNombre() + " ha sido eliminado.");
                        tablero.volcarTextoAFichero(jugador.getNombre() + " ha sido eliminado.", "volcado.txt");
                        jugadoresEliminados.add(jugador);
                    }
                }
            }

            // Eliminar jugadores muertos
            jugadores.removeAll(jugadoresEliminados);

            // Reducir el tablero cada 3 rondas
            if (ronda % 3 == 0) {
                tablero.reducirTablero();
                tablero.actualizarGUI(jugadores);
                tablero.volcarTextoAFichero("El tablero se ha reducido.", "volcado.txt");
            }

            ronda++;
        }

        // Mostrar al ganador
        partida.mostrarGanador();
        tablero.volcarTextoAFichero("El ganador es: " + (jugadores.size() == 1 ? jugadores.get(0).getNombre() : "Nadie"), "volcado.txt");
    }

    private static Jugador crearJugador(String nombre, int tipo) {
        Jugador jugador = null;

        // Crear un arma básica
        Arma cuchillo = new Arma("Cuchillo", "Arma cuerpo a cuerpo", 10, "Un cuchillo afilado para combate cuerpo a cuerpo");

        switch (tipo) {
            case 1:
                jugador = new Jugador(nombre, Soldado.vida(), cuchillo, new Habilidad(Soldado.habilidad(), false));
                break;
            case 2:
                jugador = new Jugador(nombre, Explorador.vida(), cuchillo, new Habilidad(Explorador.habilidad(), false));
                break;
            case 3:
                jugador = new Jugador(nombre, Medico.vida(), cuchillo, new Habilidad(Medico.habilidad(), false));
                break;
            case 4:
                jugador = new Jugador(nombre, Ingeniero.vida(), cuchillo, new Habilidad(Ingeniero.habilidad(), false));
                break;
            default:
                System.out.println("Tipo de jugador no válido.");
                break;
        }
        return jugador;
    }
}
