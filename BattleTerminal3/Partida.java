package BattleTerminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partida {
    private List<Jugador> jugadores;
    private Tablero tablero;

    public Partida(List<Jugador> jugadores, Tablero tablero) {
        this.jugadores = jugadores;
        this.tablero = tablero;
    }

    public void iniciarJuego() {
        System.out.println("\u00a1La partida ha comenzado!");
    }

    public void realizarAccion(Jugador jugador, Scanner sc) {
        // Mostrar información del jugador
        System.out.println("\nTurno de " + jugador.getNombre() + ":");
        System.out.println("Vida: " + jugador.getVida());
        System.out.println("Arma: " + jugador.getArma().getNombre() + " - " + jugador.getArma().getDescripcion() + " - Daño: " + jugador.getArma().getDano());

        // Determinar si hay jugadores cercanos
        boolean puedeAtacar = hayJugadoresCercanos(jugador);

        // Mostrar el menú de acción
        int accion = -1;
        do {
            System.out.println("Selecciona una acción:");
            System.out.println("1. Moverse");
            if (puedeAtacar) {
                System.out.println("2. Atacar");
            }

            if (sc.hasNextInt()) {
                accion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                if (accion == 1) {
                    moverJugador(jugador, sc);
                    // Verificar si el jugador ha encontrado un arma al moverse
                    Arma armaEncontrada = tablero.obtenerArmaEnPosicion(jugador.getPosicion()[0], jugador.getPosicion()[1]);
                    if (armaEncontrada != null) {
                        System.out.println("¡Has encontrado una nueva arma: " + armaEncontrada.getNombre() + "!");
                        System.out.println("Descripción: " + armaEncontrada.getDescripcion());
                        System.out.println("Daño: " + armaEncontrada.getDano());
                        jugador.recogerArma(armaEncontrada, sc);
                    }
                } else if (accion == 2 && puedeAtacar) {
                    atacarJugador(jugador, sc);  // Llamada al método atacarJugador
                } else {
                    System.out.println("Acción no válida. Intenta de nuevo.");
                    accion = -1;
                }
            } else {
                System.out.println("Entrada no válida. Introduce un número.");
                sc.nextLine(); // Limpiar el buffer
            }
        } while (accion == -1);
    }

    private void moverJugador(Jugador jugador, Scanner sc) {
        char direccion = ' ';
        boolean direccionValida = false;
        do {
            System.out.println("Selecciona la dirección para moverte (W: Arriba, S: Abajo, A: Izquierda, D: Derecha): ");
            String input = sc.nextLine().toUpperCase();

            if (input.length() == 1) {
                direccion = input.charAt(0);
                direccionValida = direccion == 'W' || direccion == 'S' || direccion == 'A' || direccion == 'D';
            }

            if (!direccionValida) {
                System.out.println("Dirección no válida. Intenta de nuevo.");
            }
        } while (!direccionValida);

        int[] posicion = jugador.getPosicion();
        switch (direccion) {
            case 'W':
                if (posicion[0] > 0) posicion[0]--;
                break;
            case 'S':
                if (posicion[0] < tablero.getSize() - 1) posicion[0]++;
                break;
            case 'A':
                if (posicion[1] > 0) posicion[1]--;
                break;
            case 'D':
                if (posicion[1] < tablero.getSize() - 1) posicion[1]++;
                break;
        }

        String direccionTexto = switch (direccion) {
            case 'W' -> "Arriba";
            case 'S' -> "Abajo";
            case 'A' -> "Izquierda";
            case 'D' -> "Derecha";
            default -> "";
        };

        System.out.println(jugador.getNombre() + " se ha movido hacia " + direccionTexto + ".");
    }

    private boolean hayJugadoresCercanos(Jugador atacante) {
        int[] posicionAtacante = atacante.getPosicion();
        for (Jugador j : jugadores) {
            if (j != atacante && j.estaVivo()) {
                int[] posicion = j.getPosicion();
                boolean esContiguo = Math.abs(posicion[0] - posicionAtacante[0]) <= 1 &&
                                     Math.abs(posicion[1] - posicionAtacante[1]) <= 1;
                if (esContiguo) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método para atacar a un jugador
    private void atacarJugador(Jugador atacante, Scanner sc) {
        List<Jugador> jugadoresCercanos = new ArrayList<>();
        for (Jugador j : jugadores) {
            if (j != atacante && j.estaVivo()) {
                int[] posicion = j.getPosicion();
                int[] posicionAtacante = atacante.getPosicion();
                if (Math.abs(posicion[0] - posicionAtacante[0]) <= 1 &&
                    Math.abs(posicion[1] - posicionAtacante[1]) <= 1) {
                    jugadoresCercanos.add(j);
                }
            }
        }

        if (jugadoresCercanos.isEmpty()) {
            System.out.println("No hay jugadores cercanos para atacar.");
        } else {
            System.out.println("Selecciona a qué jugador deseas atacar:");
            for (int i = 0; i < jugadoresCercanos.size(); i++) {
                System.out.println((i + 1) + ". " + jugadoresCercanos.get(i).getNombre());
            }

            int opcion = -1;
            do {
                if (sc.hasNextInt()) {
                    opcion = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer
                    if (opcion > 0 && opcion <= jugadoresCercanos.size()) {
                        Jugador objetivo = jugadoresCercanos.get(opcion - 1);
                        atacar(atacante, objetivo);
                    } else {
                        System.out.println("Opción no válida.");
                    }
                } else {
                    System.out.println("Entrada no válida.");
                    sc.nextLine(); // Limpiar el buffer
                }
            } while (opcion == -1);
        }
    }

    private void atacar(Jugador atacante, Jugador objetivo) {
        int dano = atacante.getArma().getDano();
        objetivo.recibirDano(dano);
        System.out.println(atacante.getNombre() + " ha atacado a " + objetivo.getNombre() + " con " + atacante.getArma().getNombre() + " causando " + dano + " puntos de daño.");
    }

    public void mostrarGanador() {
        Jugador ganador = null;
        for (Jugador j : jugadores) {
            if (j.estaVivo()) {
                ganador = j;
                break;
            }
        }

        if (ganador != null) {
            System.out.println("¡El ganador es " + ganador.getNombre() + "!");
        } else {
            System.out.println("No hay ganador.");
        }
    }
}
