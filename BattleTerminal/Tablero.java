package BattleTerminal;

import javax.swing.*;
import java.awt.*;

public class Tablero {
    private int filas;
    private int columnas;
    private JButton[][] casillas;
    private JFrame frame;

    public Tablero(int tamaño) {
        this.filas = tamaño;
        this.columnas = tamaño;

        frame = new JFrame("Battle Royale");
        frame.setLayout(new GridLayout(filas, columnas));
        casillas = new JButton[filas][columnas];

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
        int fila = posicion[0];
        int columna = posicion[1];
        casillas[fila][columna].setBackground(Color.GREEN);

        // Pintar la casilla anterior de gris
    }

    public boolean posicionValida(int[] posicion) {
        int fila = posicion[0];
        int columna = posicion[1];
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public void reducirMapa() {
        System.out.println("¡El tablero se reduce de tamaño! (Funcionalidad pendiente de implementación)");
        // Aquí podrías reducir el tamaño lógico del mapa (no la GUI)
    }

    public void imprimirTablero() {
        System.out.println("Actualizando tablero en pantalla...");
        // Esta implementación puede ser simplemente un mensaje,
        // ya que la GUI refleja visualmente el estado.
    }
}


/* SE BORRA EL RASTRO; DISPARA CON NULL; ARMAS DROPEADAS; IDENTIFICADOR DE CADA JUGADOR; DISTINTO COLOR PARA CADA JUGADOR (j1 rosa, j2 azul, j3 verde, j4 morado
CASILLA ADYACENTE ATACAR; REDUCIR TABLERO FUNCIONALIDAS PENDIENTE DE IMPLEMENTACION;*/