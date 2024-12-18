package BattleTerminal;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

public class Tablero extends JFrame {
    private char[][] casillas;
    private int size;
    private JButton[][] botones;

    
    public Tablero(int size) {
        this.size = size;
        casillas = new char[size][size];
        botones = new JButton[size][size]; 
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
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                botones[i][j].setText(String.valueOf(casillas[i][j]));
                botones[i][j].setBackground(Color.WHITE);
            }
        }
    
        for (Jugador jugador : jugadores) {
            int[] pos = jugador.getPosicion();
            if (pos[0] >= 0 && pos[0] < size && pos[1] >= 0 && pos[1] < size) {
                botones[pos[0]][pos[1]].setBackground(Color.GREEN);
                botones[pos[0]][pos[1]].setText(String.valueOf(jugador.getNombre().charAt(0)));
                colorearAdyacentes(pos[0], pos[1]);
            } else {
                System.out.println("Error: Posición inválida para jugador " + jugador.getNombre());
            }
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
        File archivo = new File(nombreFichero); // Crear archivo en la ruta especificada
    
        try (FileWriter writer = new FileWriter(archivo, true);
             PrintWriter printWriter = new PrintWriter(writer)) {
    
            printWriter.println(texto); // Escribir texto en el archivo
            System.out.println("Texto volcado al fichero: " + texto);
    
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + archivo.getAbsolutePath());
            e.printStackTrace();
        }
    }
    

    

    public int getBoardSize() {
        return size;
    }

    public void reducirTablero(List<Jugador> jugadores) {
        // Reducir el tamaño del tablero, pero no menos de 4x4
        size = Math.max(4, size - 1);
    
        // Ajustar posiciones de los jugadores para que estén dentro del nuevo tamaño
        for (Jugador jugador : jugadores) {
            int[] pos = jugador.getPosicion();
            pos[0] = Math.min(pos[0], size - 1); // Ajustar posición X si está fuera del nuevo límite
            pos[1] = Math.min(pos[1], size - 1); // Ajustar posición Y si está fuera del nuevo límite
            jugador.setPosicion(pos[0], pos[1]);
        }
    
        // Actualizar las dimensiones del tablero visual
        for (int i = 0; i < size; i++) {
            botones[0][i].setVisible(false);
            botones[size][i].setVisible(false);
            botones[i][0].setVisible(false);
            botones[i][size].setVisible(false);
        }
    
        System.out.println("El tablero se ha reducido a " + size + "x" + size);
    
        // Asignar armas nuevas a los jugadores después de la reducción
        asignarArmasJugadores(jugadores);
    }
    

    private void asignarArmasJugadores(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            if (jugador.estaVivo()) {
            // Ejemplo de asignación basada en posiciones reducidas
            Arma nuevaArma = generarArmaAleatoria();
            jugador.setArma(nuevaArma);
            System.out.println("Se ha asignado un arma a " + jugador.getNombre() + ": " + nuevaArma);
            }
    }
}

    private Arma generarArmaAleatoria() {
        // Generar un arma aleatoria para el jugador
        Arma[] armasDisponibles = {new Cuchillo(), new Escopeta(), new Fusil(), new CanonPlasma(), new RifleFrancotirador()};
        Random random = new Random();
        return armasDisponibles[random.nextInt(armasDisponibles.length)];
    }
}
