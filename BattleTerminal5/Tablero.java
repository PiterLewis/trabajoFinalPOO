package BattleTerminal5;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tablero implements Modificable{
    private int filas;
    private int columnas;
    private JButton[][] casillas;
    private JFrame frame;
    private Jugador[][] tablero; // Array lógico para jugadores

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

        // Reducir el tablero por todos los lados
        reducirPorTodosLados();

        // Actualizar las dimensiones lógicas del tablero
        filas -= 1;
        columnas -= 1;

        // Verifica el nuevo tamaño del tablero
        System.out.println("Nuevo tamaño del tablero: " + filas + "x" + columnas);
    }

    private void reducirPorTodosLados() {
        // Definir los márgenes a bloquear (para todos los lados)
        int margenSuperior = 0; // Primera fila
        int margenInferior = filas - 1; // Última fila
        int margenIzquierdo = 0; // Primera columna
        int margenDerecho = columnas - 1; // Última columna

        // Bloquear casillas en los márgenes (superior, inferior, izquierdo y derecho)
        for (int j = 0; j < columnas; j++) {
            // Bloqueamos las casillas en los márgenes superior e inferior
            casillas[margenSuperior][j].setBackground(Color.MAGENTA);  
            casillas[margenInferior][j].setBackground(Color.MAGENTA);  
        }

        for (int i = 0; i < filas; i++) {
            // Bloqueamos las casillas en los márgenes izquierdo y derecho
            casillas[i][margenIzquierdo].setBackground(Color.MAGENTA);  
            casillas[i][margenDerecho].setBackground(Color.MAGENTA);  
        }

        // Marcar las casillas de los márgenes como bloqueadas en el tablero lógico
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Bloqueamos las casillas en los márgenes
                if (i == margenSuperior || i == margenInferior || j == margenIzquierdo || j == margenDerecho) {
                    tablero[i][j] = null; // Las casillas de los márgenes quedan bloqueadas
                }
            }
        }
    }
    @Override
public void modificar() {
    Random random = new Random();
    Integer trampasPorRonda = 2; 
    Integer trampasColocadas = 0;
    

    while (trampasColocadas < trampasPorRonda) {
        // Generar coordenadas aleatorias
        Integer fila = random.nextInt(filas);
        Integer columna = random.nextInt(columnas);

        
        if (casillas[fila][columna].getBackground() != Color.LIGHT_GRAY) {
            continue;
        }

        
        if (trampasColocadas < trampasPorRonda) {

            casillas[fila][columna].setBackground(Color.RED);
            trampasColocadas++;
            System.out.println("Trampa colocada en: (" + fila + ", " + columna + ")");
        }
    }
}
    public void imprimirTablero() {
        System.out.println("Actualizando tablero en pantalla...");
        // Actualiza visualmente el tablero
    }

    public int getFilas() {
        return filas;
    }
    
    public int getColumnas() {
        return columnas;
    }    

    public boolean posicionOcupada(int fila, int columna) {
        return tablero[fila][columna] != null;
    }
    
    
}
