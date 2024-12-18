package BattleTerminal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        // Pedir el número de jugadores (entre 2 y 6)
        int numJugadores = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("¿Cuántos jugadores van a participar? (Entre 2 y 6): ");
            try {
                numJugadores = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                if (numJugadores >= 2 && numJugadores <= 6) {
                    entradaValida = true; // Salir del bucle si el número es válido
                } else {
                    System.out.println("Número inválido. Por favor, introduce un número entre 2 y 6.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, introduce un número entre 2 y 6.");
                sc.nextLine(); // Limpiar el buffer para evitar bucle infinito
            }
        }

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
        List<Jugador> jugadoresEliminados = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            int x = rand.nextInt(tablero.getSize());
            int y = rand.nextInt(tablero.getSize());

            // Verificar si la posición es válida (dentro de los límites del tablero)
            if (x >= tablero.getSize() || y >= tablero.getSize()) {
                System.out.println(jugador.getNombre() + " ha sido eliminado por intentar ubicarse fuera de los límites del tablero.");
                jugadoresEliminados.add(jugador); // Eliminar al jugador de la partida
            } else {
                jugador.setPosicion(x, y);  // Asignar posición válida
            }
        }

        // Eliminar los jugadores que estaban fuera de los límites
        jugadores.removeAll(jugadoresEliminados);

        // Crear la partida
        Partida partida = new Partida(jugadores, tablero);
        partida.iniciarJuego();

        // Empezar el ciclo de rondas
        int ronda = 1;
        while (jugadores.stream().filter(Jugador::estaVivo).count() > 1) {  // Mientras haya más de 1 jugador vivo
            System.out.println("\n--- Ronda " + ronda + " ---");

            // Mostrar el tablero
            tablero.mostrarTablero(jugadores);

            // Los jugadores realizan sus acciones por turnos
            jugadoresEliminados.clear();
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
                tablero.reducirTablero(jugadores);  // Pasar la lista de jugadores aquí
            }

            // Guardar la ronda en el archivo BattleTerminal.txt
            guardarRondaEnArchivo(ronda, jugadores, tablero);

            ronda++;
        }

        // Verificar si hay un ganador o si no hay jugadores vivos
        long jugadoresVivos = jugadores.stream().filter(Jugador::estaVivo).count();
        if (jugadoresVivos == 1) {
            Jugador ganador = jugadores.stream().filter(Jugador::estaVivo).findFirst().get();
            System.out.println("¡La batalla ha terminado! El ganador es " + ganador.getNombre() + "!");
        } else if (jugadoresVivos == 0) {
            System.out.println("La batalla ha terminado sin un vencedor claro. Todos los jugadores han caído.");
        } else {
            System.out.println("La batalla ha terminado sin un vencedor claro.");
        }
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

    private static void guardarRondaEnArchivo(int ronda, List<Jugador> jugadores, Tablero tablero) {
        // Obtener la fecha y hora actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String fechaHora = now.format(formatter);

        // Ruta del archivo
        String rutaArchivo = "BattleTerminal.txt";
        File archivo = new File(rutaArchivo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            // Escribir la fecha y hora, número de ronda
            writer.write("Fecha y hora: " + fechaHora);
            writer.newLine();
            writer.write("Ronda " + ronda);
            writer.newLine();

            // Escribir el estado de los jugadores
            writer.write("Estado de los jugadores:");
            writer.newLine();
            for (Jugador jugador : jugadores) {
                writer.write(jugador.getNombre() + " - " + (jugador.estaVivo() ? "Vivo" : "Muerto") + " - Vida: " + jugador.getVida());
                writer.newLine();
            }

            // Escribir el estado del tablero
            writer.write("Estado del tablero:");
            writer.newLine();

            // Capturar el tablero en una variable y escribirlo en el archivo
            StringBuilder tableroString = new StringBuilder();
            for (int i = 0; i < tablero.getSize(); i++) {
                for (int j = 0; j < tablero.getSize(); j++) {
                    tableroString.append(tablero.getCasilla(i, j)).append(" ");  // Capturamos el estado de la casilla
                }
                tableroString.append("\n");
            }

            writer.write(tableroString.toString());  // Escribir el tablero en el archivo
            writer.newLine();
            writer.newLine();

            // Imprimir la ruta en la terminal
            System.out.println("La ronda ha sido guardada en: " + archivo.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error al guardar la ronda en el archivo: " + e.getMessage());
        }
    }

}

