package BattleTerminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a Battle Terminal!");
        System.out.println("¿Cuántos jugadores van a participar? (Entre 1 y 4): ");
        int numJugadores = sc.nextInt();
        sc.nextLine();

        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Ingrese el nombre del Jugador " + (i + 1) + ": ");
            String nombre = sc.nextLine();

            System.out.println("Selecciona el tipo de jugador: 1. Soldado 2. Explorador 3. Médico 4. Ingeniero");
            int tipo = sc.nextInt();
            sc.nextLine();

            Jugador jugador = crearJugador(nombre, tipo);
            jugadores.add(jugador);
        }

        Tablero tablero = new Tablero(12);
        Random rand = new Random();
        for (Jugador jugador : jugadores) {
            int x = rand.nextInt(tablero.getBoardSize());
            int y = rand.nextInt(tablero.getBoardSize());
            jugador.setPosicion(x, y);
            System.out.println("Posición inicial de " + jugador.getNombre() + ": [" + x + ", " + y + "]");
        }

        tablero.mostrarTableroGUI(jugadores);
    }

    private static Jugador crearJugador(String nombre, int tipo) {
        switch (tipo) {
            case 1:  
                return new Soldado(nombre);
            case 2: 
                new Explorador(nombre);
            case 3: 
                new Medico(nombre);
            case 4: 
                new Ingeniero(nombre);
            default:
                System.out.println("Tipo no válido.");
                return null;
        }
    }
}
