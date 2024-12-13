package practicaFinal;

public class Personaje {
    private String nombre;
    private int salud;
    private boolean esHumano;
    private Arma herramienta;

    public Personaje(String nombre, int salud, boolean esHumano, Arma herramienta) {
        this.nombre = nombre;
        this.salud = salud;
        this.esHumano = esHumano;
        this.herramienta = herramienta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void reducirSalud(int danio) {
        this.salud -= danio;
        if (this.salud < 0) {
            this.salud = 0;
        }
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    public boolean esHumano() {
        return esHumano;
    }

    public Arma getHerramienta() {
        return herramienta;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", salud=" + salud +
                ", esHumano=" + esHumano +
                ", herramienta=" + herramienta.getClass().getSimpleName() +
                ", calidad=" + herramienta.calidad +
                '}';
    }
}