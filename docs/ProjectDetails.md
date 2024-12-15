# Battle Terminal | Battle Royale en Consola (Java)

## **Descripción del Proyecto**
Este es un proyecto básico de un videojuego **Battle Royale** desarrollado en Java y ejecutado desde la terminal. Los jugadores compiten en un tablero dinámico, tomando decisiones estratégicas por turnos. El objetivo es ser el último en pie mientras el área jugable se reduce.

---

## **Cómo jugar**

### 1. **Inicio del juego:**
- Aparece un menú por consola que explica la manera de introducción del proyecto.
- Al pasar al siguiente menú aparece una breve descripción del objetivo del juego, y las funciones de cada personaje y arma.
- Se pregunta el número de jugadores que van a jugar.
- Cada jugador selecciona un personaje.
- El tablero inicial es de 12x12.
- Los jugadores y objetos iniciales se colocan aleatoriamente en el tablero.

### 2. **Acciones por turno:**
Cada jugador puede realizar una acción:
- **Moverse:** Cambiar a una casilla adyacente (arriba, abajo, izquierda, derecha).
- **Recoger:** Si al moverse a otra casilla hay un arma, abrir un menú donde se pregunte al jugador si desea cambiar el arma.
- **Atacar:** Si un jugador está en una casilla adyacente.  
- **Usar habilidad:** Activar una habilidad especial (si está disponible). Opciones:
  - **Curarse (+50 de vida):** Restaurar salud.
  - **Escudo:** Eres inmune cuando te ataquen la próxima vez.
  - **Colocar trampa (-60 de vida):** Dejar una trampa en tu casilla.

### 3. **Batallas:**
- En cada ronda se le imprime a cada jugador por consola el mapa, sólo verá a los enemigos que estén en una casilla adyacente. Se especificará el arma que porta.
- Solo puedes atacar si el enemigo está justo a la izquierda, derecha, arriba o abajo.
- Si matas al otro jugador, ocupas la casilla del enemigo derrotado.

### 4. **Reducción del tablero:**
- Al final de cada 2 rondas completas, el tablero se reduce.
- Las filas y columnas exteriores desaparecen. Si un jugador se encuentra en casillas eliminadas, automaticamente ese jugador muere.

### 5. **Finalización del juego:**
- El juego termina cuando solo queda un jugador.

---

## **Detalles del Juego**

### **Jugadores**
Cada jugador selecciona uno de los siguientes personajes, con estadísticas y habilidades únicas. Además, cada personaje tiene un arma inicial asignada y obtiene un 15% de bonificación al daño si recoge su arma correspondiente en el mapa.

1. **Soldado:**
   - **Vida:** 150
   - **Arma boost:** Fusil
   - **Habilidad especial:** Contraataque (devolver parte (30%) del daño recibido).

2. **Explorador:**
   - **Vida:** 100
   - **Arma boost:** Escopeta
   - **Habilidad especial:** Movimiento rápido (dos movimientos en la siguiente ronda).

3. **Médico:**
   - **Vida:** 120
   - **Arma boost:** Rifle de francotirador
   - **Habilidad especial:** Curación rápida (restaurar vida propia (al 100%)).

4. **Ingeniero:**
   - **Vida:** 110
   - **Arma boost:** Cañón de plasma
   - **Habilidad especial:** Colocar 2 trampas que dañan a enemigos.

---

### **Armas**
Armas disponibles en el tablero que los jugadores pueden recoger:

1. **Cuchillo:** Daño bajo, siempre disponible.
2. **Fusil:** Puede atacar en horizontal, vertical o diagonal.
3. **Escopeta:** Puede atacar en horizontal o vertical y tiene más daño que el fusil.
4. **Rifle de francotirador:** Altísimo daño a larga distancia. Aumenta en 1 el numero de casillas que visualiza a los enemigos, pero solo puede atacar si está adyacente a su casilla.
5. **Cañón de plasma:** Ataque masivo en área (casillas contiguas al ataque).

---

### **Habilidades especiales**
Habilidades especiales, aparecen por el mapa, a cada personaje se le activa su habilidad especial correspondiente:

1. **Curarse (+50 de vida):** Suma a la salud +50 puntos, hasta el maximo que será igual a la vida incial de la partida.
2. **Escudo:** Eres inmune cuando te ataquen la próxima vez.
3. **Colocar trampa (-60 de vida):** Dejar una trampa en tu casilla, cuando un jugador la pise, le restará 60 de vidas, avisando de quien ha puesto esa trampa.

---

### **Mapas**
El tablero inicial es de 12x12 y se reduce gradualmente:

- **12x12:** Inicio del juego.
- **10x10:** Después de 2 rondas.
- **8x8:** Después de 4 rondas.
- **6x6:** Después de 6 rondas.
- **4x4:** Después de 8 rondas.

---
