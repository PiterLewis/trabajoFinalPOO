package BattleTerminal4;

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
        // Verifica si el mapa ya ha alcanzado el tamaño mínimo permitido
    if (filas <= 4 || columnas <= 4) {
        System.out.println("El tablero ha alcanzado el tamaño mínimo de 4x4 y no puede reducirse más.");
        return;
    }
    System.out.println("¡El tablero se reduce de tamaño!");
    // Determinar las filas y columnas a bloquear
    int margenSuperior = filas - filas;     // Primera fila (0)
    int margenInferior = filas - 1;         // Última fila
    int margenIzquierdo = columnas - columnas; // Primera columna (0)
    int margenDerecho = columnas - 1;       // Última columna

    // Bloquear casillas en el margen superior
    for (int j = 0; j < columnas; j++) {
        if (tablero[margenSuperior][j] == null) { // Si no hay jugador en la casilla
            casillas[margenSuperior][j].setBackground(Color.MAGENTA); // Pintar la casilla de morado
        }
    }
    // Bloquear casillas en el margen inferior
    for (int j = 0; j < columnas; j++) {
        if (tablero[margenInferior][j] == null) { // Si no hay jugador en la casilla
            casillas[margenInferior][j].setBackground(Color.MAGENTA);
        }
    }
    // Bloquear casillas en el margen izquierdo
    for (int i = 0; i < filas; i++) {
        if (tablero[i][margenIzquierdo] == null) {
            casillas[i][margenIzquierdo].setBackground(Color.MAGENTA);
        }
    }
    // Bloquear casillas en el margen derecho
    for (int i = 0; i < filas; i++) {
        if (tablero[i][margenDerecho] == null) {
            casillas[i][margenDerecho].setBackground(Color.MAGENTA);
        }
    }
    // Actualizar las dimensiones lógicas del tablero
    filas -= 1;
    columnas -= 1;

    // Verifica el nuevo tamaño del tablero
    System.out.println("Nuevo tamaño del tablero: " + filas + "x" + columnas);
    }

    public void imprimirTablero() {
        System.out.println("Actualizando tablero en pantalla...");
        // Actualiza visualmente el tablero

        
    }
}
