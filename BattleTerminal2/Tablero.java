package BattleTerminal2;

import javax.swing.*;
import java.awt.*;

public class Tablero {
    private int filas;
    private int columnas;
    private JButton[][] casillas;
    private JFrame frame;
    private Jugador[][] tablero; // Arreglo lógico para jugadores

    public Tablero(int tamaño) {
        this.filas = tamaño;
        this.columnas = tamaño;

        frame = new JFrame("Battle Royale");
        frame.setLayout(new GridLayout(filas, columnas));
        casillas = new JButton[filas][columnas];
        tablero = new Jugador[filas][columnas]; // Inicializar el tablero lógico

        inicializarCasillas();
    }

    private void inicializarCasillas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new JButton();
                casillas[i][j].setBackground(Color.LIGHT_GRAY);
                frame.add(casillas[i][j]);
            }
        }
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actualizarPosicionJugador(Jugador jugador, int[] posicion) {
        int[] posicionAnterior = jugador.getPosicion();

        // Limpiar la posición anterior
        if (posicionAnterior != null) {
            casillas[posicionAnterior[0]][posicionAnterior[1]].setBackground(Color.LIGHT_GRAY);
            tablero[posicionAnterior[0]][posicionAnterior[1]] = null;
        }

        // Actualizar la nueva posición
        int fila = posicion[0];
        int columna = posicion[1];
        tablero[fila][columna] = jugador;
        casillas[fila][columna].setBackground(Color.GREEN);
        jugador.mover(posicion);
    }

    public boolean posicionValida(int[] posicion) {
        int fila = posicion[0];
        int columna = posicion[1];
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public void reducirMapa() {
        System.out.println("¡El tablero se reduce de tamaño!");
        // Implementación pendiente
    }

    public void imprimirTablero() {
        System.out.println("Actualizando tablero en pantalla...");
        // Actualiza visualmente el tablero
    }
}
