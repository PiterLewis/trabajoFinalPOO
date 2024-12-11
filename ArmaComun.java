package practicaFinal;

public class ArmaComun extends Arma {
	
	public ArmaComun(String nombre, int danioBase) {
		super(nombre, 40, "Común");
	}

	@Override
	public void mostrarDetalles() {
		System.out.println("Arma Común: " + nombre + " | Daño Base: " + danioBase + " | Calidad: " + calidad);
	}

}