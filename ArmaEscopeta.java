// Clase ArmaEscopeta
package com.utad.poo.proyectofinaldefinitivo;

public class ArmaEscopeta extends Arma {

    public ArmaEscopeta() {
        super("Escopeta", 60); // Daño base de 60
    }

    public void atacar(Jugador atacante, Jugador objetivo) {
        if (objetivo != null) {
            int danio = getDaño();

            // Bonificación si el atacante es un Explorador
            if (atacante instanceof JugadorExplorador) {
                danio += (int) (danio * 0.15);
            }

            // Aplicar el daño al objetivo
            objetivo.setVidaActual(objetivo.getVidaActual() - danio);
            System.out.println(atacante.getNombre() + " ataca a " + objetivo.getNombre() + " con la Escopeta causando " + danio + " de daño.");
        }
    }
}