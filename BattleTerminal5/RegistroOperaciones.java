package BattleTerminal5;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistroOperaciones {

    private static final int MAX_OPERACIONES = 1000;
    private static List<String> operaciones = new ArrayList<>();

    public static void registrar(String operacion) {
        // Añade la operación al final del registro
        if (operaciones.size() >= MAX_OPERACIONES) {
            operaciones.remove(0); // Elimina la operación más antigua si excede el límite
        }
        operaciones.add(operacion);
    }

    public static void volcarAFichero(String rutaFichero) throws IOException {
        File archivo = new File(rutaFichero);
    
        if (!archivo.exists()) {
            archivo.createNewFile(); // Crear el archivo si no existe
        }
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String operacion : operaciones) {
                bw.write(operacion);
                bw.newLine(); // Escribir línea por línea
            }
        }
    
        System.out.println("Las operaciones se han volcado al archivo: " + archivo.getCanonicalPath());
    }
    
}