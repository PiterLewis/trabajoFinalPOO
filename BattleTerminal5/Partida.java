package BattleTerminal5;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Partida {
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Scanner scanner;
    private Integer ronda;
    private String resumenRonda = ""; 

    public void iniciarJuego() {
        jugadores = new ArrayList<>();
        tablero = new Tablero(12); // Tamaño inicial del tablero
        scanner = new Scanner(System.in);
        ronda = 1;

        // Crear jugadores
        System.out.println("¿Cuántos jugadores participarán? (2-4)");
        Integer numeroJugadores = scanner.nextInt();
        scanner.nextLine(); // Limpiar el búfer después de leer el número

        Random random = new Random(); // Generador de números aleatorios

        for (int i = 1; i <= numeroJugadores; i++) {
            // Pedir el nombre del jugador
            System.out.println("Introduce el nombre del jugador " + i + ":");
            String nombreJugador = scanner.nextLine().trim();

            // Elegir personaje
            System.out.println("Elige un personaje para " + nombreJugador + ":");
            System.out.println("1. Soldado\n2. Explorador\n3. Médico\n4. Ingeniero");
            int eleccion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el búfer después de leer la elección

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

            Jugador jugador = new Jugador(nombreJugador, personaje);

            // Generar una posición inicial aleatoria
            Integer fila, columna;
            do {
                fila = random.nextInt(tablero.getFilas());
                columna = random.nextInt(tablero.getColumnas());
            } while (tablero.posicionOcupada(fila, columna)); // Reintentar si la posición está ocupada

            int[] posicionInicial = {fila, columna};
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
            resumenRonda += "--- Ronda" + ronda + "---\n";
            for (Jugador jugador : jugadores) {
                System.out.println(jugador.getNombre() + " - Vida: " + jugador.getVida());
                resumenRonda += jugador.getNombre() + "- Vida" + jugador.getVida();
            }

            for (Jugador jugador : jugadores) {
                

                System.out.println("\nTurno de " + jugador.getNombre() + ":");
                resumenRonda += "Turno de " + jugador.getNombre() + "\n";
                System.out.println("1. Mover\n2. Usar habilidad especial");

                // Solo muestra la opción de atacar si hay enemigos cercanos
                List<Jugador> enemigosCercanos = obtenerEnemigosCercanos(jugador);
                if (!enemigosCercanos.isEmpty()) {
                    System.out.println("3. Atacar");
                }

                // Limpiar el buffer de cualquier salto de línea no consumido
                int accion = -1;
                boolean accionValida = false;

                // Asegurarnos de que la entrada sea válida
                do {
                    if (scanner.hasNextInt()) {
                        accion = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el salto de línea residual
                        if (accion >= 1 && accion <= 3) {
                            accionValida = true;
                        } else {
                            System.out.println("Acción no válida. Por favor, ingresa una opción entre 1 y 3.");
                        }
                    } else {
                        // Si no se ingresa un número, limpiamos el buffer y pedimos de nuevo
                        scanner.nextLine();
                        System.out.println("Entrada no válida. Por favor, ingresa un número.");
                    }
                } while (!accionValida);

                switch (accion) {
                    case 1:
                        moverJugador(jugador);
                        resumenRonda += jugador.getNombre() + " se movió.\n";
                        break;
                    case 2:
                        jugador.usarHabilidadEspecial();
                        resumenRonda += jugador.getNombre() + " usó su habilidad especial.\n";
                        break;
                    case 3:
                        if (!enemigosCercanos.isEmpty()) {
                            atacarJugador(jugador, enemigosCercanos);
                            resumenRonda += jugador.getNombre() + " atacó a un enemigo.\n";
                        } else {
                            System.out.println("No hay enemigos cerca para atacar.");
                        }
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

            if(ronda % 2 == 0){
                tablero.reducirMapa();
                tablero.modificar();
            }

            if(ronda % 5 == 0){
                curacionJugadores();
            }
            ronda++;
        }

        RegistroOperaciones.registrar(resumenRonda);
        try {
            RegistroOperaciones.volcarAFichero("volcado.txt");
        } catch (IOException e) {
            System.out.println("Error al volcar el registro de operaciones: " + e.getMessage());
        }
    }

    private void moverJugador(Jugador jugador) {
        char direccion = ' ';
        boolean direccionValida = false;
        do {
            System.out.println("Selecciona la dirección para moverte (W: Arriba, S: Abajo, A: Izquierda, D: Derecha): ");
            String input = scanner.nextLine().trim().toUpperCase(); // Leer línea y eliminar espacios adicionales

            if (input.length() == 1) {
                direccion = input.charAt(0);
                direccionValida = direccion == 'W' || direccion == 'S' || direccion == 'A' || direccion == 'D';
            }

            if (!direccionValida) {
                System.out.println("Dirección no válida. Intenta de nuevo.");
            }
        } while (!direccionValida);

        int[] posicionActual = jugador.getPosicion();
        int nuevaFila = posicionActual[0];
        int nuevaColumna = posicionActual[1];

        // Determinar la nueva posición según la dirección
        switch (direccion) {
            case 'W': // Arriba
                nuevaFila--;
                break;
            case 'S': // Abajo
                nuevaFila++;
                break;
            case 'A': // Izquierda
                nuevaColumna--;
                break;
            case 'D': // Derecha
                nuevaColumna++;
                break;
        }

        int[] nuevaPosicion = {nuevaFila, nuevaColumna};

        // Validar si el movimiento es posible
        if (!tablero.posicionValida(nuevaPosicion)) {
            System.out.println("Movimiento no válido. Estás intentando salir del tablero.");
            return;
        }

        if (!esMovimientoValido(posicionActual, nuevaPosicion)) {
            System.out.println("Movimiento no válido. Solo puedes moverte a casillas contiguas.");
            return;
        }

        // Actualizar la posición del jugador
        tablero.actualizarPosicionJugador(jugador, nuevaPosicion);

        // Mostrar dirección en texto
        String direccionTexto;
        switch (direccion) {
            case 'W':
                direccionTexto = "Arriba";
                break;
            case 'S':
                direccionTexto = "Abajo";
                break;
            case 'A':
                direccionTexto = "Izquierda";
                break;
            case 'D':
                direccionTexto = "Derecha";
                break;
            default:
                direccionTexto = "";
                break;
        }

        System.out.println(jugador.getNombre() + " se ha movido hacia " + direccionTexto + ".");
    }

    private boolean esMovimientoValido(int[] posicionActual, int[] nuevaPosicion) {
        int distanciaFila = Math.abs(posicionActual[0] - nuevaPosicion[0]);
        int distanciaColumna = Math.abs(posicionActual[1] - nuevaPosicion[1]);
        return distanciaFila <= 1 && distanciaColumna <= 1;
    }

    private List<Jugador> obtenerEnemigosCercanos(Jugador jugador) {
        List<Jugador> enemigosCercanos = new ArrayList<>();
        for (Jugador enemigo : jugadores) {
            if (enemigo != jugador && enemigo.estaVivo()) {
                int[] posicionJugador = jugador.getPosicion();
                int[] posicionEnemigo = enemigo.getPosicion();

                // Comprobar si el enemigo está a una distancia de 1 casilla (horizontal, vertical o diagonal)
                if (esDistanciaDeAtaque(posicionJugador, posicionEnemigo)) {
                    enemigosCercanos.add(enemigo);
                }
            }
        }
        return enemigosCercanos;
    }

    // Función que comprueba si dos posiciones están a una distancia de 1 casilla (horizontal, vertical o diagonal)
    private boolean esDistanciaDeAtaque(int[] posicionJugador, int[] posicionEnemigo) {
        int distanciaFila = Math.abs(posicionJugador[0] - posicionEnemigo[0]);
        int distanciaColumna = Math.abs(posicionJugador[1] - posicionEnemigo[1]);

        // Distancia de ataque es 1 casilla en cualquiera de las 8 direcciones (horizontal, vertical o diagonal)
        return (distanciaFila <= 1 && distanciaColumna <= 1);
    }

    private void atacarJugador(Jugador jugador, List<Jugador> enemigosCercanos) {
        if (enemigosCercanos.isEmpty()) {
            System.out.println("No hay enemigos cerca para atacar.");
            return;
        }

        // Mostrar los enemigos cercanos
        System.out.println("Elige a quién atacar:");
        for (int i = 0; i < enemigosCercanos.size(); i++) {
            Jugador enemigo = enemigosCercanos.get(i);
            System.out.println((i + 1) + ". " + enemigo.getNombre());
        }

        // Elegir el enemigo a atacar
        int eleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el búfer
        
        // Verificar si la elección está dentro de los límites
        if (eleccion < 1 || eleccion > enemigosCercanos.size()) {
            System.out.println("Elección no válida. Intenta de nuevo.");
            return;  // O puedes solicitar al jugador que elija nuevamente
        }

        Jugador enemigoSeleccionado = enemigosCercanos.get(eleccion - 1);

        // Realizar el ataque
        jugador.atacar(enemigoSeleccionado);
    }


    private boolean juegoTerminado() {
        long jugadoresVivos = jugadores.stream().filter(Jugador::estaVivo).count();
        return jugadoresVivos <= 1;
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

    public void curacionJugadores() {
        System.out.println("Los jugadores se curan 50hp");
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Modificable) {
                ((Modificable) jugador).modificar();
            }
        }
    }
    
}