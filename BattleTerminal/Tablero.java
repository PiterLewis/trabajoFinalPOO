package BattleTerminal;

import java.util.List;  // Añadir esta importación
import java.util.ArrayList;  // Añadir esta importación
import java.util.Arrays;  // Añadir esta importación
import java.util.Random;
import java.util.Scanner;

class Tablero {
    private int dimensiones;
    private String[][] casillas;
    private List<Arma> armas;

    public Tablero(int dimensiones) {
        this.dimensiones = dimensiones;
        this.casillas = new String[dimensiones][dimensiones];
        this.armas = new ArrayList<>(); // Inicialización de lista
        inicializarTablero();
        generarArmasAleatorias();
    }

    private void inicializarTablero() {
        for (int i = 0; i < dimensiones; i++) {
            for (int j = 0; j < dimensiones; j++) {
                casillas[i][j] = " . ";
            }
        }
    }

    private void generarArmasAleatorias() {
        Random random = new Random();
        int cantidadArmas = dimensiones / 2;

        for (int i = 0; i < cantidadArmas; i++) {
            int fila = random.nextInt(dimensiones);
            int columna = random.nextInt(dimensiones);
            Arma arma = switch (random.nextInt(4)) {
                case 0 -> new Fusil();
                case 1 -> new Escopeta();
                case 2 -> new RifleFrancotirador();
                default -> new CanonPlasma();
            };
            arma.posicion = new int[]{fila, columna};
            armas.add(arma);
        }
    }

    public void imprimirTablero() {
        System.out.println("  ");
        for (int i = 0; i < dimensiones; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        for (int i = 0; i < dimensiones; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < dimensiones; j++) {
                System.out.print(casillas[i][j]);
            }
            System.out.println();
        }
    }

    public void actualizarPosicionJugador(Jugador jugador, int[] nuevaPosicion) {
        if (jugador.getPosicion() != null) {
            int[] posicionActual = jugador.getPosicion();
            casillas[posicionActual[0]][posicionActual[1]] = " . ";
        }
        casillas[nuevaPosicion[0]][nuevaPosicion[1]] = " " + jugador.getLetraRepresentativa() + " ";
        jugador.mover(nuevaPosicion);

        // Verificar si hay un arma en la nueva posición
        for (Arma arma : armas) {
            if (Arrays.equals(arma.posicion, nuevaPosicion)) {
                System.out.println("\n¡Has encontrado un arma: " + arma.getNombre() + "! (Daño: " + arma.getDano() + ")");
                System.out.println("¿Quieres equiparla? (1. Sí / 2. No)");
                Scanner scanner = new Scanner(System.in);
                int eleccion = scanner.nextInt();
                if (eleccion == 1) {
                    jugador.equiparArma(arma);
                }
                armas.remove(arma);
                break;
            }
        }
    }

    public void reducirMapa() {
        dimensiones--;
        String[][] nuevoTablero = new String[dimensiones][dimensiones];

        for (int i = 0; i < dimensiones; i++) {
            for (int j = 0; j < dimensiones; j++) {
                nuevoTablero[i][j] = casillas[i][j];
            }
        }
        casillas = nuevoTablero;
        System.out.println("\n¡El mapa se ha reducido!");
    }

    public boolean posicionValida(int[] nuevaPosicion) {
        return nuevaPosicion[0] >= 0 && nuevaPosicion[0] < dimensiones &&
               nuevaPosicion[1] >= 0 && nuevaPosicion[1] < dimensiones;
    }
}
