package practicaFinal;

public abstract class Arma {

    //Commit de prueba 
    private String commitSanti;
	private String perro;
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
