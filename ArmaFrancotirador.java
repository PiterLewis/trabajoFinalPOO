// Clase ArmaFrancotirador
package com.utad.poo.proyectofinaldefinitivo;

public class ArmaFrancotirador extends Arma {

    public ArmaFrancotirador() {
        super("Rifle de Francotirador", 80); // Daño base de 80
    }

    public void atacarYMover(Jugador atacante, Jugador objetivo, int dx, int dy, Mapa mapa) {
        if (objetivo != null) {
            int danio = getDaño();

            // Incremento del 20% si el atacante es del tipo Explorador (o similar)
            if (atacante instanceof JugadorArquero) {
                danio += (int) (danio * 0.2);
            }

            // Aplicar el daño al objetivo
            objetivo.setVidaActual(objetivo.getVidaActual() - danio);
            System.out.println(atacante.getNombre() + " ataca a " + objetivo.getNombre() +
                " con el Rifle de Francotirador causando " + danio + " de daño.");
        }

        // Movimiento del atacante
        atacante.mover(dx, dy, mapa);
        System.out.println(atacante.getNombre() + " se mueve después del ataque.");
    }
}
