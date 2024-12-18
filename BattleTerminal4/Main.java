package BattleTerminal4;


public class Main {
    public static void main(String[] args) {
        // Mostrar las instrucciones del juego
        System.out.println("¡Bienvenido a Battle Terminal!\n");
        System.out.println("=== Cómo Jugar ===");
        System.out.println("1. Selecciona tu personaje.");
        System.out.println("2. Cada turno puedes moverte, recoger armas, atacar o usar habilidades especiales.");
        System.out.println("3. El último jugador en pie gana. ¡Buena suerte!\n");

        // Mostrar características de los personajes
        System.out.println("=== Personajes ===");
        System.out.println("1. Soldado: Vida 150 | Arma Boost: Fusil | Habilidad: Contraataque (30% daño devuelto).");
        System.out.println("2. Explorador: Vida 100 | Arma Boost: Escopeta | Habilidad: Movimiento rápido (2 movimientos).");
        System.out.println("3. Médico: Vida 120 | Arma Boost: Rifle de francotirador | Habilidad: Curación rápida (restaurar vida).");
        System.out.println("4. Ingeniero: Vida 110 | Arma Boost: Cañón de plasma | Habilidad: Colocar trampas (x2).\n");

        // Mostrar características de las armas
        System.out.println("=== Armas ===");
        System.out.println("- Cuchillo: Daño básico, sin restricciones.");
        System.out.println("- Fusil: Daño medio, ataque en línea recta o diagonal.");
        System.out.println("- Escopeta: Daño alto, ataque en horizontal o vertical.");
        System.out.println("- Rifle de francotirador: Daño muy alto, visión extendida, solo ataca adyacentes.");
        System.out.println("- Cañón de plasma: Ataque masivo en área (casillas contiguas).\n");
        
        // Crear una partida
        // trata de excepciones para la creación de la partida
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Partida();
            }
        });
        // Crear una partida
        Partida partida = new Partida();
        partida.iniciarJuego();
    }
}
