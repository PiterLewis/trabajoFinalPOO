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
    // Obtenemos la posición actual del jugador
    int[] posicionAnterior = jugador.getPosicion();

    // Limpia la casilla anterior en el tablero
    if (posicionAnterior != null) { // Asegúrate de que no sea la primera vez que se mueve
        casillas[posicionAnterior[0]][posicionAnterior[1]].setBackground(null); // Elimina el color de la casilla anterior
        tablero[posicionAnterior[0]][posicionAnterior[1]] = null; // Limpia la referencia lógica
    }

    // Actualiza la posición del jugador en el tablero
    int fila = nuevaPosicion[0];
    int columna = nuevaPosicion[1];
    tablero[fila][columna] = jugador;

    // Cambia el color de la nueva casilla para indicar la presencia del jugador
    casillas[fila][columna].setBackground(Color.GREEN);

    // Actualiza la posición del jugador
    jugador.mover(nuevaPosicion);
    }

    public boolean posicionValida(int[] posicion) {
        int fila = posicion[0];
        int columna = posicion[1];
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public void reducirMapa() {
        System.out.println("¡El tablero se reduce de tamaño!");
        // Aquí podrías reducir el tamaño lógico del mapa (no la GUI)
        int limiteSuperior = 0;
        int limiteInferior = filas - 1;
        int limiteIzquierdo = 0;
        int limiteDerecho = columnas - 1;

        // Bloquear el borde superior e inferior
        for (int columna = 0; columna < columnas; columna++) {
            bloquearCasilla(limiteSuperior, columna); // Bloqueo en el borde superior
            bloquearCasilla(limiteInferior, columna); // Bloqueo en el borde inferior
        }

        // Bloquear el borde izquierdo y derecho
        for (int fila = 0; fila < filas; fila++) {
            bloquearCasilla(fila, limiteIzquierdo); // Bloqueo en el borde izquierdo
            bloquearCasilla(fila, limiteDerecho);  // Bloqueo en el borde derecho
        }
    }
    
    private void bloquearCasilla(int fila, int columna) {
        // Verifica si la casilla está dentro de los límites del tablero
        if (posicionValida(new int[]{fila, columna})) {
            casillas[fila][columna].setBackground(Color.MAGENTA); // Pinta la casilla de morado
            tablero[fila][columna] = null; // Bloquea la casilla en la lógica
        }
    }
    public void imprimirTablero() {
        System.out.println("Actualizando tablero en pantalla...");
        // Esta implementación puede ser simplemente un mensaje,
        // ya que la GUI refleja visualmente el estado.
    }
}


/* SE BORRA EL RASTRO; DISPARA CON NULL; ARMAS DROPEADAS; IDENTIFICADOR DE CADA JUGADOR; DISTINTO COLOR PARA CADA JUGADOR (j1 rosa, j2 azul, j3 verde, j4 morado
CASILLA ADYACENTE ATACAR; REDUCIR TABLERO FUNCIONALIDAS PENDIENTE DE IMPLEMENTACION;*/
