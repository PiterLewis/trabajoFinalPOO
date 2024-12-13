package BattleTerminal.entidad;

public class Medico extends Jugador {

    public Medico(String nombre) {
        super(nombre, 120, 15, "Rifle de francotirador");
    }

    @Override
    public void usarHabilidad() {
        System.out.println(getNombre() + " usa Curación Rápida, restaurando vida.");
        // Implementación específica de la curación
    }
}
