package BattleTerminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Introducción al juego
        System.out.println("Bienvenido a Battle Terminal!");
        System.out.println("Este es un juego de batalla por turnos en el que cada jugador tiene una serie de acciones para realizar.");

        // Pedir el número de jugadores (entre 1 y 4)
        int numJugadores;
        do {
            System.out.print("¿Cuántos jugadores van a participar? (Entre 1 y 4): ");
            numJugadores = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
        } while (numJugadores < 1 || numJugadores > 4);

        // Crear jugadores
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
            sc.nextLine();  // Limpiar el buffer

            Jugador jugador = crearJugador(nombre, tipo);
            jugadores.add(jugador);
        }

        // Crear el tablero
        Tablero tablero = new Tablero(12);

        // Ubicar a los jugadores en posiciones aleatorias
        Random rand = new Random();
        for (Jugador jugador : jugadores) {
            int x = rand.nextInt(tablero.getSize());
            int y = rand.nextInt(tablero.getSize());
            jugador.setPosicion(x, y);  // Asignar posición aleatoria
        }

        // Crear la partida
        Partida partida = new Partida(jugadores, tablero);
        partida.iniciarJuego();

        // Empezar el ciclo de rondas
        int ronda = 1;
        while (jugadores.size() > 1) {
            System.out.println("\n--- Ronda " + ronda + " ---");

            // Mostrar el tablero
            tablero.mostrarTablero(jugadores);

            // Los jugadores realizan sus acciones por turnos
            List<Jugador> jugadoresEliminados = new ArrayList<>();
            for (Jugador jugador : jugadores) {
                if (jugador.estaVivo()) {
                    System.out.println("\nTurno de " + jugador.getNombre() + ":");
                    partida.realizarAccion(jugador, sc);  // El jugador realiza una acción
                    
                    // Verificar si el jugador murió
                    if (jugador.estaVivo()) {
                        System.out.println(jugador.getNombre() + " sigue vivo con " + jugador.getVida() + " de vida.");
                    } else {
                        System.out.println(jugador.getNombre() + " ha muerto.");
                        jugadoresEliminados.add(jugador);  // Añadir el jugador muerto a la lista
                    }
                }
            }

            // Eliminar jugadores muertos
            jugadores.removeAll(jugadoresEliminados);

            // Reducir el tablero cada 3 rondas
            if (ronda % 3 == 0) {
                tablero.reducirTablero();
            }

            ronda++;
        }

        // Mostrar al ganador
        partida.mostrarGanador();
    }

    private static Jugador crearJugador(String nombre, int tipo) {
        Jugador jugador = null;
        
        // Crear un arma con descripción
        Arma cuchillo = new Arma("Cuchillo", "Arma cuerpo a cuerpo", 10, "Un cuchillo afilado para combate cuerpo a cuerpo");

        switch (tipo) {
            case 1:
                jugador = new Jugador(nombre, Soldado.vida(), cuchillo, new Habilidad(Soldado.habilidad(), false));  // Soldado
                break;
            case 2:
                jugador = new Jugador(nombre, Explorador.vida(), cuchillo, new Habilidad(Explorador.habilidad(), false));  // Explorador
                break;
            case 3:
                jugador = new Jugador(nombre, Medico.vida(), cuchillo, new Habilidad(Medico.habilidad(), false));  // Médico
                break;
            case 4:
                jugador = new Jugador(nombre, Ingeniero.vida(), cuchillo, new Habilidad(Ingeniero.habilidad(), false));  // Ingeniero
                break;
            default:
                System.out.println("Tipo de jugador no válido.");
                break;
        }
        return jugador;
    }
}

