package BattleTerminal;

public class Arma {
    private String nombre;
    private int daño;
    private String tipo;  // Por ejemplo: "Cuchillo", "Fusil", etc.

    // Constructor
    public Arma(String nombre, int daño, String tipo) {
        this.nombre = nombre;
        this.daño = daño;
        this.tipo = tipo;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
