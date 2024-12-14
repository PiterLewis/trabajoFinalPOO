public class Explorador extends Jugador {
    
    public Explorador(String nombre, int vidaMaxima) {
        super(nombre, vidaMaxima);
    }
    
    @Override
    public void usarHabilidad() {
        System.out.println("Usando habilidad de Explorador");
    }

}
