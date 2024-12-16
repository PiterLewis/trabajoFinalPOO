package BattleTerminal;

import java.util.List;

public class Tablero {
    private char[][] casillas;
    private int size;

    public Tablero(int size) {
        this.size = size;
        casillas = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                casillas[i][j] = '.';  // Inicialmente vacías
            }
        }
    }

    public void mostrarTablero(List<Jugador> jugadores) {
        // Limpiar el tablero
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = '.';  // Limpiar el tablero
            }
        }

        // Colocar a los jugadores en el tablero
        for (Jugador jugador : jugadores) {
            int[] pos = jugador.getPosicion();
            casillas[pos[0]][pos[1]] = jugador.getNombre().charAt(0);  // Mostrar la inicial del jugador
        }

        // Mostrar el tablero actualizado
        System.out.println("Tablero actual:");
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void reducirTablero() {
        size = Math.max(4, size - 1);  // Reducir el tamaño pero no menor a 4x4
        casillas = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                casillas[i][j] = '.';
            }
        }
        System.out.println("El tablero se ha reducido a " + size + "x" + size);
    }

    public int getSize() {
        return size;
    }
}

