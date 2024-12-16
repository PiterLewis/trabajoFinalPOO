package BattleTerminal;

import java.util.Scanner;  // Importación necesaria para usar Scanner

public class Jugador {
    private String nombre;
    private int vida;
    private Arma arma;
    private Habilidad habilidad;
    private int[] posicion;

    public Jugador(String nombre, int vida, Arma arma, Habilidad habilidad) {
        this.nombre = nombre;
        this.vida = vida;
        this.arma = arma;
        this.habilidad = habilidad;
        this.posicion = new int[]{0, 0};  // Posición inicial
    }

    // Método para obtener el arma del jugador
    public Arma getArma() {
        return arma;
    }

    // Método para recoger un arma
    public void recogerArma(Arma arma, Scanner sc) {
        System.out.println("¿Deseas recoger el arma " + arma.getNombre() + "? (s/n)");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            this.arma = arma;  // Asignar el arma al jugador
            System.out.println("Has recogido el arma: " + arma.getNombre());
        } else {
            System.out.println("Has decidido no recoger el arma.");
        }
    }

    // Método para recibir daño
    public void recibirDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;  // Asegurarse de que la vida no sea negativa
        }
        System.out.println(nombre + " ha recibido " + dano + " puntos de daño. Vida restante: " + this.vida);
    }

    public void verificarEliminacionPorTormenta(Tablero tablero) {
        int x = posicion[0];
        int y = posicion[1];

        // Si el jugador está fuera del tamaño visible del tablero
        if (x >= tablero.getSize() || y >= tablero.getSize()) {
            System.out.println(nombre + " ha quedado fuera del tablero visible y su vida ha bajado a 0 debido a la tormenta. ¡Ha sido eliminado!");
            vida = 0;  // El jugador es eliminado por la tormenta
        }
    }

    public void setPosicion(int x, int y) {
        this.posicion[0] = x;
        this.posicion[1] = y;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public int getVida() {
        return vida;
    }

    public void reducirVida(int cantidad) {
        this.vida -= cantidad;
    }
}
