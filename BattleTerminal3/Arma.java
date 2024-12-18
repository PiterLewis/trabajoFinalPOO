package BattleTerminal;

public class Arma {
    private String nombre;
    private String tipo;
    private int dano;
    private String descripcion;
    private int[] posicion;
    private boolean recogida;

    public Arma(String nombre, String tipo, int dano, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dano = dano;
        this.descripcion = descripcion;
        this.recogida = false;  // Inicialmente no está recogida
    }

    public boolean estaRecogida() {
        return recogida;
    }

    public void marcarComoRecogida() {
        this.recogida = true;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void setPosicion(int x, int y) {
        this.posicion = new int[] {x, y};
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDano() {
        return dano;
    }
}
