package BattleTerminal4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Clase para gestionar la partida

public class Partida {
 private List<Jugador> jugadores;
 private Tablero tablero;
 private Scanner scanner;
 private int ronda;

 public void iniciarJuego() {
     jugadores = new ArrayList<>();
     tablero = new Tablero(12); // Tamaño inicial del tablero
     scanner = new Scanner(System.in);
     ronda = 1;

     // Crear jugadores
     System.out.println("¿Cuántos jugadores participarán? (2-4)");
     int numeroJugadores = scanner.nextInt();

     for (int i = 1; i <= numeroJugadores; i++) {
         System.out.println("Elige un personaje para el jugador " + i + ":");
         System.out.println("1. Soldado\n2. Explorador\n3. Médico\n4. Ingeniero");
         int eleccion = scanner.nextInt();

         Personaje personaje;
         switch (eleccion) {
             case 1: 
                 personaje = new Soldado();
                 break;
             case 2: 
                 personaje = new Explorador();
                 break;
             case 3: 
                 personaje = new Medico();
                 break;
             case 4: 
                 personaje = new Ingeniero();
                 break;
             default: 
                 throw new IllegalStateException("Selección no válida.");
         }
         Jugador jugador = new Jugador("Jugador " + i, personaje);
         int[] posicionInicial = {i - 1, i - 1}; // Posición inicial
         jugador.mover(posicionInicial);
         jugadores.add(jugador);
         tablero.actualizarPosicionJugador(jugador, posicionInicial);
     }

     // Inicia la partida
     System.out.println("\n¡Inicia el juego!\n");
     gestionarTurnos();
 }

 public void gestionarTurnos() {
     Boolean juegoActivo = true;

     while (juegoActivo) {
         System.out.println("\n--- Ronda " + ronda + " ---");
         for (Jugador jugador : jugadores) {
             System.out.println(jugador.getNombre() + " - Vida: " + jugador.getVida());
         }

         for (Jugador jugador : jugadores) {
             if (!jugador.estaVivo()) continue;

             System.out.println("\nTurno de " + jugador.getNombre() + ":");
             System.out.println("1. Mover\n2. Atacar\n3. Usar habilidad especial");
             int accion = scanner.nextInt();

             switch (accion) {
                 case 1:
                   moverJugador(jugador);
                   break;
                 case 2: 
                  atacarJugador(jugador);
                  break;
                 case 3:
                  jugador.usarHabilidadEspecial();
                    break;
                 default:
                  System.out.println("Acción no válida.");
                  break;
             }

             tablero.imprimirTablero();
             if (juegoTerminado()) {
                 juegoActivo = false;
                 break;
             }
         }

         ronda++;
         tablero.reducirMapa();
     }

     System.out.println("\n¡El juego ha terminado!");

     System.out.println("Jugadores restantes:");
    }


 private void moverJugador(Jugador jugador) {
     System.out.println("Introduce la nueva posición (fila columna):");
     int nuevaFila = scanner.nextInt();
     int nuevaColumna = scanner.nextInt();
     int[] nuevaPosicion = {nuevaFila, nuevaColumna};

     if (!tablero.posicionValida(nuevaPosicion) || !esMovimientoValido(jugador.getPosicion(), nuevaPosicion)) {
         System.out.println("Movimiento no válido. Solo puedes moverte a casillas contiguas.");
         return;
     }

    tablero.actualizarPosicionJugador(jugador, nuevaPosicion);
 }

 private boolean esMovimientoValido(int[] posicionActual, int[] nuevaPosicion) {
     int distanciaFila = Math.abs(posicionActual[0] - nuevaPosicion[0]);
     int distanciaColumna = Math.abs(posicionActual[1] - nuevaPosicion[1]);
     return distanciaFila <= 1 && distanciaColumna <= 1;
 }

 private void atacarJugador(Jugador jugador) {
     System.out.println("Elige a quién atacar:");
     for (int i = 0; i < jugadores.size(); i++) {
         Jugador enemigo = jugadores.get(i);
         if (enemigo != jugador && enemigo.estaVivo()) {
             System.out.println((i + 1) + ". " + enemigo.getNombre());
         }
     }

     int eleccion = scanner.nextInt();
     Jugador enemigo = jugadores.get(eleccion - 1);
     jugador.atacar(enemigo);
 }

 private boolean juegoTerminado() {
     long jugadoresVivos = jugadores.stream().filter(Jugador::estaVivo).count();
     return jugadoresVivos <= 1;
 }

}
