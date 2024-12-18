package BattleTerminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tablero {
    private char[][] casillas;
    private int size;
    private List<Arma> armas;  // Lista de armas en el mapa

    public Tablero(int size) {
        this.size = size;
        casillas = new char[size][size];
        armas = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                casillas[i][j] = '.';  // Inicialmente vacías
            }
        }
        // Colocar armas aleatorias en el mapa
        colocarArmasAleatorias();
    }

    private void colocarArmasAleatorias() {
        Random random = new Random();
        String[] tiposArmas = {"CanonPlasma", "Escopeta", "Fusil", "RifleFrancotirador"};

        for (String tipo : tiposArmas) {
            for (int i = 0; i < 8; i++) {
                int x, y;
                do {
                    x = random.nextInt(size);
                    y = random.nextInt(size);
                } while (casillas[x][y] != '.');  // Verifica si la casilla está vacía

                Arma arma = new Arma(tipo + " " + (i + 1), tipo, random.nextInt(20) + 10, "Arma de tipo " + tipo);
                arma.setPosicion(x, y);
                armas.add(arma);
                casillas[x][y] = tipo.charAt(0);  // Coloca la primera letra del tipo de arma
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

    public void recogerArma(Jugador jugador) {
        int[] pos = jugador.getPosicion();
        Arma arma = obtenerArmaEnPosicion(pos[0], pos[1]);

        if (arma != null && !arma.estaRecogida()) {
            System.out.println("¡Has encontrado una nueva arma: " + arma.getNombre() + "!");
            System.out.println("Descripción: " + arma.getDescripcion());
            System.out.println("Daño: " + arma.getDano());
            arma.marcarComoRecogida();
            casillas[pos[0]][pos[1]] = '.';  // Limpiar el tablero donde estaba el arma
        } else {
            System.out.println("No hay arma en esa posición o ya ha sido recogida.");
        }
    }

    public Arma obtenerArmaEnPosicion(int x, int y) {
        for (Arma arma : armas) {
            if (arma != null && !arma.estaRecogida()) {
                if (arma.getPosicion()[0] == x && arma.getPosicion()[1] == y) {
                    return arma;
                }
            }
        }
        return null;  // No hay arma en esa posición
    }

    public int getSize() {
        return size;
    }

    public void reducirTablero(List<Jugador> jugadores) {
        size = Math.max(4, size - 1);  // Reducir el tamaño pero no menor a 4x4
        casillas = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                casillas[i][j] = '.';
            }
        }
        System.out.println("El tablero se ha reducido a " + size + "x" + size);

        // Verificar si algún jugador está fuera del tablero visible
        for (Jugador jugador : jugadores) {
            jugador.verificarEliminacionPorTormenta(this);
        }
    }
    
    public char getCasilla(int x, int y) {
        return casillas[x][y];  // Retorna el contenido de la casilla en las coordenadas (x, y)
    }

}
