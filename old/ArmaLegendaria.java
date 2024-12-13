package practicaFinal;

public class ArmaLegendaria extends Arma {
	public ArmaLegendaria(String nombre, int danioBase) {
		super(nombre, 100, "Legendaria");
	}

	@Override
	public void mostrarDetalles() {
		System.out.println("Arma Legendaria: " + nombre + " | Daño Base: " + danioBase + " | Calidad: " + calidad);
	}

}