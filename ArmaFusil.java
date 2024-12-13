// Clase ArmaFusil
package com.utad.poo.proyectofinaldefinitivo;

public class ArmaFusil extends Arma {

    public ArmaFusil() {
        super("Fusil", 50); // Daño base de 50
    }

    public void atacar(Jugador atacante, Jugador objetivo) {
        if (objetivo != null) {
            int danio = getDaño();

            // Si el atacante es un soldado, bonificación del 15%
            if (atacante instanceof JugadorSoldado) {
                danio += (int) (danio * 0.15);
            }

            // Aplicar el daño al objetivo
            objetivo.setVidaActual(objetivo.getVidaActual() - danio);
            System.out.println(atacante.getNombre() + " ataca a " + objetivo.getNombre() + " con el Fusil causando " + danio + " de daño.");
        }
    }
}
