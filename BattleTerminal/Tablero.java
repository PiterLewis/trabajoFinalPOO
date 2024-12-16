package BattleTerminal;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Tablero extends JFrame {
    private char[][] casillas;
    private int size;
    private JButton[][] botones;

    public Tablero(int size) {
        this.size = size;
        casillas = new char[size][size];
        botones = new JButton[size][size]; // Matriz de botones para la GUI
        inicializarCasillas();
    }

    private void inicializarCasillas() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                casillas[i][j] = '.';
            }
        }
    }

    public void mostrarTableroGUI(List<Jugador> jugadores) {
        this.setTitle("Battle Terminal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLayout(new GridLayout(size, size));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                botones[i][j] = new JButton(String.valueOf(casillas[i][j]));
                botones[i][j].setBackground(Color.WHITE);
                this.add(botones[i][j]);
            }
        }

        actualizarGUI(jugadores);
        this.setVisible(true);
    }

    public void actualizarGUI(List<Jugador> jugadores) {
        // Limpiar la GUI
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                botones[i][j].setText(String.valueOf(casillas[i][j]));
                botones[i][j].setBackground(Color.WHITE);
            }
        }

        // Actualizar jugadores
        for (Jugador jugador : jugadores) {
            int[] pos = jugador.getPosicion();
            botones[pos[0]][pos[1]].setBackground(Color.GREEN);
            botones[pos[0]][pos[1]].setText(String.valueOf(jugador.getNombre().charAt(0)));

            // Colorear las casillas adyacentes
            colorearAdyacentes(pos[0], pos[1]);
        }
    }

    private void colorearAdyacentes(int x, int y) {
        int[][] direcciones = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Arriba, Abajo, Izquierda, Derecha
        for (int[] dir : direcciones) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < size && ny >= 0 && ny < size && botones[nx][ny].getBackground() != Color.GREEN) {
                botones[nx][ny].setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    public void volcarTextoAFichero(String texto, String nombreFichero) {
        try (FileWriter writer = new FileWriter(nombreFichero, true)) {
            writer.write(texto + "\n");
            writer.flush(); // Garantiza que se escribe el contenido
            System.out.println("Texto volcado al fichero: " + texto); // Mensaje para confirmar
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
    

    public int getBoardSize() {
        return size;
    }

    public void reducirTablero() {
       // Quitar casillas externas del GUI 
         for (int i = 0; i < size; i++) {
              botones[0][i].setVisible(false);
              botones[size - 1][i].setVisible(false);
              botones[i][0].setVisible(false);
              botones[i][size - 1].setVisible(false);
         }
    }
}
