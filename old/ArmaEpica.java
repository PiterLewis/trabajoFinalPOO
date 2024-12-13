package practicaFinal;

public class ArmaEpica extends Arma {

	public ArmaEpica(String nombre, int danioBase) {
		super(nombre, 60, "Épica");
	}

	@Override
	public void mostrarDetalles() {
		System.out.println("Arma Épica: " + nombre + " | Daño Base: " + danioBase + " | Calidad: " + calidad);
	}

}