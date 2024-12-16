package BattleTerminal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = "volcado.txt";
        File file = new File(nombreArchivo);

        try (FileWriter fileWriter = new FileWriter(file, true); 
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // Introducción al juego
            printWriter.println("Bienvenido a Battle Terminal!");
            System.out.println("Bienvenido a Battle Terminal!");

            printWriter.println("Este es un juego de batalla por turnos en el que cada jugador tiene una serie de acciones.");
            System.out.println("Este es un juego de batalla por turnos en el que cada jugador tiene una serie de acciones.");

            // Solicitar el número de jugadores
            int numJugadores;
            do {
                printWriter.print("¿Cuántos jugadores van a participar? (Entre 1 y 4): ");
                System.out.print("¿Cuántos jugadores van a participar? (Entre 1 y 4): ");
                numJugadores = sc.nextInt();
                sc.nextLine();
            } while (numJugadores < 1 || numJugadores > 4);

            // Crear lista de jugadores
            List<Jugador> jugadores = new ArrayList<>();
            for (int i = 0; i < numJugadores; i++) {
                printWriter.print("Ingrese el nombre del Jugador " + (i + 1) + ": ");
                System.out.print("Ingrese el nombre del Jugador " + (i + 1) + ": ");
                String nombre = sc.nextLine();

                printWriter.println("Selecciona el tipo de jugador para " + nombre + ":");
                System.out.println("Selecciona el tipo de jugador para " + nombre + ":");

                printWriter.println("1. Soldado\n2. Explorador\n3. Médico\n4. Ingeniero");
                System.out.println("1. Soldado\n2. Explorador\n3. Médico\n4. Ingeniero");

                int tipo = sc.nextInt();
                sc.nextLine();
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
                jugador.setPosicion(x, y);
            }

            // Mostrar la GUI inicial
            tablero.mostrarTableroGUI(jugadores);

            // Crear la partida
            Partida partida = new Partida(jugadores, tablero);
            partida.iniciarJuego();

            // Ciclo de turnos
            int ronda = 1;
            while (jugadores.size() > 1) {
                printWriter.println("\n--- Ronda " + ronda + " ---");
                System.out.println("\n--- Ronda " + ronda + " ---");
                tablero.volcarTextoAFichero("--- Ronda " + ronda + " ---", nombreArchivo);

                List<Jugador> jugadoresEliminados = new ArrayList<>();
                for (Jugador jugador : jugadores) {
                    if (jugador.estaVivo()) {
                        printWriter.println("\nTurno de " + jugador.getNombre());
                        System.out.println("\nTurno de " + jugador.getNombre());
                        tablero.volcarTextoAFichero("Turno de " + jugador.getNombre(), nombreArchivo);

                        partida.realizarAccion(jugador, sc);
                        tablero.actualizarGUI(jugadores);

                        if (!jugador.estaVivo()) {
                            printWriter.println(jugador.getNombre() + " ha sido eliminado.");
                            System.out.println(jugador.getNombre() + " ha sido eliminado.");
                            tablero.volcarTextoAFichero(jugador.getNombre() + " ha sido eliminado.", nombreArchivo);
                            jugadoresEliminados.add(jugador);
                        }
                    }
                }
                jugadores.removeAll(jugadoresEliminados);

                if (ronda % 3 == 0) {
                    tablero.reducirTablero();
                    tablero.actualizarGUI(jugadores);
                    tablero.volcarTextoAFichero("El tablero se ha reducido.", nombreArchivo);
                }
                ronda++;
            }

            // Mostrar al ganador
            String ganador = jugadores.size() == 1 ? jugadores.get(0).getNombre() : "Nadie";
            printWriter.println("El ganador es: " + ganador);
            System.out.println("El ganador es: " + ganador);
            tablero.volcarTextoAFichero("El ganador es: " + ganador, nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al manejar el archivo: " + e.getMessage());
        }
    }

    private static Jugador crearJugador(String nombre, int tipo) {
        Arma cuchillo = new Arma("Cuchillo", "Arma cuerpo a cuerpo", 10, "Un cuchillo afilado para combate cuerpo a cuerpo");

        switch (tipo) {
            case 1:
                return new Jugador(nombre, Soldado.vida(), cuchillo, new Habilidad(Soldado.habilidad(), false));
            case 2:
                return new Jugador(nombre, Explorador.vida(), cuchillo, new Habilidad(Explorador.habilidad(), false));
            case 3:
                return new Jugador(nombre, Medico.vida(), cuchillo, new Habilidad(Medico.habilidad(), false));
            case 4:
                return new Jugador(nombre, Ingeniero.vida(), cuchillo, new Habilidad(Ingeniero.habilidad(), false));
            default:
                System.out.println("Tipo de jugador no válido.");
                return null;
        }
    }
}
