package BattleTerminal;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Tablero extends JFrame{
    private JButton[][] botones;
    private Integer dimensiones;
    private String[][] casillas;
    private List<Arma> armas;
    private Partida partida;

    public Tablero(int dimensiones) {
        this.dimensiones = dimensiones;
        this.botones = new JButton[dimensiones][dimensiones];
        this.casillas = new String[dimensiones][dimensiones];
        this.armas = new ArrayList<>();
        this.partida = new Partida();
        inicializarGUI();
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
        Integer cantidadArmas = dimensiones / 2;
        Arma arma;

        for (int i = 0; i < cantidadArmas; i++) {
            int fila = random.nextInt(dimensiones);
            int columna = random.nextInt(dimensiones);
            int tipoArma = random.nextInt(4);

            switch(tipoArma) {
                case 0: 
                    arma = new Fusil();
                    break;
                case 1: 
                    arma = new Escopeta();
                    break;
                case 2:
                    arma = new RifleFrancotirador();
                    break;
                default:
                    arma = new CanonPlasma();
                    break;
            }
            arma.posicion = new int[]{fila, columna};
            armas.add(arma);
            actualizarCasilla(fila, columna, arma.getTipo());
        }
    }

    public void imprimirTablero() {
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < dimensiones; i++) {
            System.out.printf(" %2d ", i);
        }
        System.out.println();

        for (int i = 0; i < dimensiones; i++) {
            System.out.printf("%2d ", i);
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
                Scanner scanner = new Scanner(System.in); // Scanner centralizado
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
        List<Arma> armasActualizadas = new ArrayList<>();

        // Copiar las posiciones válidas del tablero anterior al nuevo
        for (int i = 0; i < dimensiones; i++) {
            for (int j = 0; j < dimensiones; j++) {
                nuevoTablero[i][j] = casillas[i][j];
            }
        }

        // Actualizar las posiciones de las armas dentro del nuevo tablero
        for (Arma arma : armas) {
            if (arma.posicion[0] < dimensiones && arma.posicion[1] < dimensiones) {
                armasActualizadas.add(arma);
            }
        }

        casillas = nuevoTablero;
        armas = armasActualizadas;
        System.out.println("\n¡El mapa se ha reducido!");
    }

    public boolean posicionValida(int[] nuevaPosicion) {
        return nuevaPosicion[0] >= 0 && nuevaPosicion[0] < dimensiones &&
               nuevaPosicion[1] >= 0 && nuevaPosicion[1] < dimensiones;
    }
    
    // Codigo para establecer el tablero en GUI con JButton y JFrame
    public void inicializarGUI() {
        setTitle("Battle Terminal GUI");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(dimensiones, dimensiones));

        for (int i = 0; i < dimensiones; i++) {
            for (int j = 0; j < dimensiones; j++) {
                botones[i][j] = new JButton();
                botones[i][j].addActionListener(new BotonListener(i, j));
                add(botones[i][j]);
                casillas[i][j] = "Libre"; // Inicializar casillas
            }
        }

        setVisible(true);
    }

    private class BotonListener implements ActionListener {
        private int x, y;

        public BotonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Aquí puedes manejar la lógica de lo que sucede cuando se presiona un botón
            System.out.println("Botón presionado en posición: " + x + ", " + y);
            // Lógica del juego, por ejemplo, mover una pieza o atacar
            partida.gestionarTurnos();
        }
    }

    public void actualizarCasilla(int x, int y, String estado) {
        casillas[x][y] = estado;
        botones[x][y].setText(estado);
    }

    public static void main(String[] args) {
        new Tablero(10); // Ejemplo con un tablero de 10x10
    }

}
