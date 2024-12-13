// Clase ArmaCanonDePlasma
package com.utad.poo.proyectofinaldefinitivo;

import java.util.List;

public class ArmaCanonDePlasma extends Arma {

    public ArmaCanonDePlasma() {
        super("Cañón de Plasma", 70); // Daño base de 70
    }

    public void atacarEnArea(Jugador atacante, List<Jugador> objetivos) {
        for (Jugador objetivo : objetivos) {
            if (objetivo != null) {
                int danio = getDaño();

                // Si el atacante es un Ingeniero, bonificación del 10%
                if (atacante instanceof JugadorIngeniero) {
                    danio += (int) (danio * 0.1);
                }

                // Aplicar el daño a cada objetivo
                objetivo.setVidaActual(objetivo.getVidaActual() - danio);
                System.out.println(atacante.getNombre() + " ataca a " + objetivo.getNombre() + " con el Cañón de Plasma causando " + danio + " de daño.");
            }
        }
    }
}
