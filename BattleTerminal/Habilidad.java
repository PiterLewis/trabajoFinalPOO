package BattleTerminal;

public class Habilidad {
    private String nombre;
    private boolean disponible;

    public Habilidad(String nombre, boolean disponible) {
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void usar() {
        if (disponible) {
            System.out.println(nombre + " ha sido usada.");
            disponible = false;  // Habilidad ya no disponible tras usarse
        } else {
            System.out.println("La habilidad no está disponible.");
        }
    }
}
