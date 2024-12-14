import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Jugador;

public class Partida {
	private List<Jugador> jugadoresHumanos;
    private List<Jugador> jugadoresMaquina;
    private Integer nivelDificultad; // 1: Fácil, 2: Medio, 3: Difícil

    public Partida(int nivelDificultad) {
        this.jugadoresHumanos = new ArrayList<>();
        this.jugadoresMaquina = new ArrayList<>();
        this.nivelDificultad = nivelDificultad;
    }

    public void agregarJugadorHumano(Jugador jugador) {
        jugadoresHumanos.add(jugador);
    }

    public void agregarJugadorMaquina(Jugador jugador) {
        jugadoresMaquina.add(jugador);
    }

    public void iniciar() {
        System.out.println("\n--- INICIO DE LA BATALLA ---");

        Random random = new Random();
        while (!jugadoresHumanos.isEmpty() && !jugadoresMaquina.isEmpty()) {
            // Selección aleatoria de jugadores para pelear
        	Jugador humano = jugadoresHumanos.get(random.nextInt(jugadoresHumanos.size()));
        	Jugador maquina = jugadoresMaquina.get(random.nextInt(jugadoresMaquina.size()));

            // Turno del humano
            if (humano.estaVivo()) {
                maquina.reducirSalud(humano.getHerramienta().danioBase);
                System.out.println(humano.getNombre() + " ataca a " + maquina.getNombre() + " con " +
                        humano.getHerramienta().calidad + ". Salud de " + maquina.getNombre() + ": " +
                        maquina.getSalud());
            }

            // Turno de la máquina
            if (maquina.estaVivo()) {
                humano.reducirSalud(maquina.getHerramienta().danioBase);
                System.out.println(maquina.getNombre() + " ataca a " + humano.getNombre() + " con " +
                        maquina.getHerramienta().calidad + ". Salud de " + humano.getNombre() + ": " +
                        humano.getSalud());
            }

            // Eliminar jugadores derrotados
            for (int i = 0; i < jugadoresHumanos.size(); i++) {
                if (!jugadoresHumanos.get(i).estaVivo()) {
                    jugadoresHumanos.remove(i);
                    i--;  // Ajustar el índice después de eliminar un jugador
                }
            }
            
         // Eliminar jugadores derrotados - Máquina
            for (int i = 0; i < jugadoresMaquina.size(); i++) {
                if (!jugadoresMaquina.get(i).estaVivo()) {
                    jugadoresMaquina.remove(i);
                    i--;  // Ajustar el índice después de eliminar un jugador
                }
            }
        }

        // Determinar el ganador
        if (jugadoresHumanos.isEmpty()) {
            System.out.println("\n¡La máquina gana la batalla!");
        } else {
            System.out.println("\n¡Los jugadores humanos ganan la batalla!");
        }

        System.out.println("\n--- FIN DE LA BATALLA ---");
    }

    public void guardarResultado(String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write("--- RESULTADO DE LA BATALLA ---\n");
            writer.write("Nivel de Dificultad: " + nivelDificultad + "\n");
            writer.write("Jugadores Humanos:\n");
            for (Jugador jugador : jugadoresHumanos) {
                writer.write(jugador + "\n");
            }
            writer.write("Jugadores Máquina:\n");
            for (Jugador jugador : jugadoresMaquina) {
                writer.write(jugador + "\n");
            }
            writer.write("\n--- FIN DEL RESULTADO ---\n");
            System.out.println("Resultado guardado en: " + archivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el resultado: " + e.getMessage());
        }
    }

}