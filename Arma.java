package practicaFinal;

public abstract class Arma {

	
	protected String nombre;
    	protected int danioBase;
    	protected String calidad;

    // Constructor
    public Arma(String nombre, int danioBase, String calidad) {
        this.nombre = nombre;
        this.danioBase = danioBase;
        this.calidad = calidad;
    }

    // Método abstracto para mostrar detalles
    public abstract void mostrarDetalles();
    
}
