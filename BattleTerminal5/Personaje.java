package BattleTerminal5;

//Clase base para personajes
public abstract class Personaje implements Modificable{
 protected String nombre;
 protected Integer vidaInicial;
 protected Integer vidaActual;
 protected Arma armaInicial;
 protected Integer ataque;

 public Personaje(String nombre, int vidaInicial, Arma armaInicial) {
     this.nombre = nombre;
     this.vidaInicial = vidaInicial;
     this.armaInicial = armaInicial;
 }

 public abstract void activarHabilidadEspecial(Jugador jugador);

 public int getVidaInicial() {
     return vidaInicial;
 }

 public Arma getArmaInicial() {
     return armaInicial;
 }

 public Integer getVidaActual() {
	        return vidaActual;
	    }

	public void setVidaActual(Integer vidaActual) {
	 if (vidaActual > vidaInicial) {
	        this.vidaActual = vidaInicial;
	        } else if (vidaActual < 0) {
	            this.vidaActual = 0; // Aseguramos que la vida no sea negativa
	        } else {
	            this.vidaActual = vidaActual;
	        }
	    }
 public String getNombre() {
     return nombre;
 }
 
 public String toString() {
	        return nombre + " (Vida: " + vidaActual + ", Ataque: " + ataque + ")";
	    }
	
	@Override
	public void modificar() {
			// Aumentar la vida del personaje en 50 puntos
			this.vidaActual += 50;
			System.out.println("La vida del personaje " + nombre + " ha aumentado en 50 puntos. Nueva vida: " + vidaActual);
		}
}
