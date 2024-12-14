public class Medico extends Jugador {
    
    public Medico(String nombre, int vidaMaxima) {
        super(nombre, vidaMaxima);
    }
    
    @Override
    public void usarHabilidad() {
        System.out.println("Usando habilidad de Medico");
    }

}
