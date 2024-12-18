package BattleTerminal4;

//Clase base para objetos
public abstract class Objeto {
	protected String nombre;
	protected int[] posicion;

	public Objeto(String nombre, int[] posicion) {
     this.nombre = nombre;
     this.posicion = posicion;
	}
	
	public String getTipo() {
		return nombre;
	}
}
