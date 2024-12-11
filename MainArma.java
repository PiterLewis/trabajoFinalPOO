package practicaFinal;
import java.util.Random;

public class MainArma {
	public static Arma generarArmaAleatoria() {
        Random random = new Random();
        int tipo = random.nextInt(4); // 0: Legendaria, 1: Mítica, 2: Épica, 3: Común
        int danioBase = random.nextInt(100) + 10; // Daño base entre 10 y 109
        String[] nombres = {"Espada de Fuego", "Arco del Dragón", "Martillo del Trueno", "Daga de Sombras"};
        String nombre = nombres[random.nextInt(nombres.length)];

        switch (tipo) {
            case 0:
                return new ArmaLegendaria(nombre, danioBase);
            case 1:
                return new ArmaMitica(nombre, danioBase);
            case 2:
                return new ArmaEpica(nombre, danioBase);
            default:
                return new ArmaComun(nombre, danioBase);
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Generar y mostrar detalles de varias armas
        for (int i = 0; i < 5; i++) {
            Arma arma = generarArmaAleatoria();
            arma.mostrarDetalles();
        }
    }

}