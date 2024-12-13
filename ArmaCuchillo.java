// Clase ArmaCuchillo
package com.utad.poo.proyectofinaldefinitivo;

public class ArmaCuchillo extends Arma {

    public ArmaCuchillo() {
        super("Cuchillo", 30); // Daño base de 30
    }

    public void atacar(Jugador atacante, Jugador objetivo) {
        if (objetivo != null) {
            int danio = getDaño();

            // Aplicar el daño directamente
            objetivo.setVidaActual(objetivo.getVidaActual() - danio);
            System.out.println(atacante.getNombre() + " ataca a " + objetivo.getNombre() + " con el Cuchillo causando " + danio + " de daño.");
        }
    }
}
