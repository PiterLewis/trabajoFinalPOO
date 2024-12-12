# Battle Royale en Consola (Java)

## **Descripción del Proyecto**
Este es un proyecto básico de un videojuego **Battle Royale** desarrollado en Java y ejecutado desde la terminal. Los jugadores compiten en un tablero dinámico, tomando decisiones estratégicas por turnos. El objetivo es ser el último en pie mientras el área jugable se reduce.

---

## **Cómo jugar**
1. **Inicio del juego:**
   - Cada jugador selecciona un personaje.
   - El tablero inicial es de 8x8 (puede ajustarse).
   - Los jugadores y objetos iniciales se colocan aleatoriamente en el tablero.

2. **Acciones por turno:**
   - Cada jugador puede realizar una acción:
     - **Moverse:** Cambiar a una casilla adyacente (arriba, abajo, izquierda, derecha).
     - **Recoger:** Levantar armas u objetos en la casilla actual.
     - **Atacar:** Si un jugador está en una casilla adyacente.
     - **Usar habilidad:** Activar una habilidad especial (si está disponible).

3. **Batallas:**
   - Si dos jugadores coinciden en la misma casilla, entran en combate.
   - Los combates son por turnos hasta que uno de los jugadores pierde toda su vida.

4. **Reducción del tablero:**
   - Al final de cada ronda completa, el tablero se reduce:
     - Las filas y columnas exteriores desaparecen, obligando a los jugadores a moverse al centro.

5. **Finalización del juego:**
   - El juego termina cuando solo queda un jugador o equipo.

---

## **Detalles del Juego**

### **Jugadores**
Cada jugador selecciona uno de los siguientes personajes, con estadísticas y habilidades únicas:

1. **Soldado:**
   - Vida: Alta
   - Ataque: Medio
   - Defensa: Alta
   - **Habilidad especial:** Contraataque (devolver parte del daño recibido).

2. **Explorador:**
   - Vida: Media
   - Ataque: Bajo
   - Defensa: Baja
   - **Habilidad especial:** Movimiento rápido (dos movimientos por ronda).

3. **Médico:**
   - Vida: Media
   - Ataque: Bajo
   - Defensa: Media
   - **Habilidad especial:** Curación rápida (restaurar vida propia o de un aliado).

4. **Ingeniero:**
   - Vida: Media
   - Ataque: Medio
   - Defensa: Baja
   - **Habilidad especial:** Trampa explosiva (colocar trampas que dañan a enemigos).

---

### **Armas**
Armas disponibles en el tablero que los jugadores pueden recoger:

1. **Cuchillo:** Daño bajo, siempre disponible.
2. **Pistola:** Daño moderado, recarga rápida.
3. **Escopeta:** Daño alto a corta distancia.
4. **Rifle de francotirador:** Altísimo daño a larga distancia.
5. **Cañón de plasma:** Ataque masivo en área (arma rara).

---

### **Mapas**
El tablero inicial es de 8x8 y se reduce gradualmente:
- **8x8:** Inicio del juego.
- **6x6:** Después de 2 rondas.
- **4x4:** Después de 4 rondas.
- **2x2:** Etapa final.

---

### **Organización del Código**
| Módulo                 | Descripción                              |
|------------------------|------------------------------------------|
| `Player`               | Clase base para jugadores.               |
| `Map`                  | Gestión del tablero y reducción.         |
| `Weapon`               | Clase para las armas.                    |
| `Game`                 | Controla el flujo de las rondas.         |
| `Combat`               | Gestión de los enfrentamientos.          |

---
