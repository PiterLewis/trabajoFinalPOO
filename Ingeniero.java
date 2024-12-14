
public class Ingeniero extends Jugador {
    
    public Ingeniero(String nombre, int vidaMaxima) {
        super(nombre, vidaMaxima);
    }
    
    @Override
    public void usarHabilidad() {
        System.out.println("Usando habilidad de Ingeniero");
    }
}
