package practicaFinal;

public class ArmaMitica extends Arma {
	
	public ArmaMitica(String nombre, int danioBase) {
		super(nombre, 80, "Mítica");
	}

	@Override
	public void mostrarDetalles() {
		System.out.println("Arma Mítica: " + nombre + " | Daño Base: " + danioBase + " | Calidad: " + calidad);
	}

}