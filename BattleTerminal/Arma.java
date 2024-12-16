package BattleTerminal;

public class Arma {
    private String nombre;
    private String tipo;
    private int dano;
    private String descripcion;  // Descripción opcional del arma

    public Arma(String nombre, String tipo, int dano, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dano = dano;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDano() {
        return dano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + "), Daño: " + dano;
    }
}
