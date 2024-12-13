# Battle Royale en Consola (Java)

## **Descripción del Proyecto**
Este es un proyecto básico de un videojuego **Battle Royale** desarrollado en Java y ejecutado desde la terminal. Los jugadores compiten en un tablero dinámico, tomando decisiones estratégicas por turnos. El objetivo es ser el último en pie mientras el área jugable se reduce.

---

## **Cómo jugar**

### 1. **Inicio del juego:**
- Cada jugador selecciona un personaje.
- El tablero inicial es de 12x12 (puede ajustarse).
- Los jugadores y objetos iniciales se colocan aleatoriamente en el tablero.

### 2. **Acciones por turno:**
Cada jugador puede realizar una acción:
- **Moverse:** Cambiar a una casilla adyacente (arriba, abajo, izquierda, derecha).
- **Recoger:** Levantar armas u objetos en la casilla actual.
- **Atacar:** Si un jugador está en una casilla adyacente.  
- **Usar habilidad:** Activar una habilidad especial (si está disponible). Opciones:
  - **Curarse (+50 de vida):** Restaurar salud.
  - **Escudo:** Eres inmune al próximo ataque.
  - **Colocar trampa:** Dejar una trampa en la casilla adyacente.

### 3. **Batallas:**
- Solo puedes atacar si el enemigo está justo a la izquierda, derecha, arriba o abajo.
- Si ganas, ocupas la casilla del enemigo derrotado.

### 4. **Reducción del tablero:**
- Al final de cada ronda completa, el tablero se reduce:
  - Las filas y columnas exteriores desaparecen, obligando a los jugadores a moverse al centro.

### 5. **Finalización del juego:**
- El juego termina cuando solo queda un jugador o equipo.

---

## **Detalles del Juego**

### **Jugadores**
Cada jugador selecciona uno de los siguientes personajes, con estadísticas y habilidades únicas. Además, cada personaje tiene un arma inicial asignada y obtiene un 15% de bonificación al daño si recoge su arma correspondiente en el mapa.

1. **Soldado:**
   - **Vida:** 150
   - **Ataque:** 30
   - **Defensa:** Alta
   - **Arma asignada:** Fusil
   - **Habilidad especial:** Contraataque (devolver parte del daño recibido).

2. **Explorador:**
   - **Vida:** 100
   - **Ataque:** 20
   - **Defensa:** Baja
   - **Arma asignada:** Cuchillo
   - **Habilidad especial:** Movimiento rápido (dos movimientos por ronda).

3. **Médico:**
   - **Vida:** 120
   - **Ataque:** 15
   - **Defensa:** Media
   - **Arma asignada:** Rifle de francotirador
   - **Habilidad especial:** Curación rápida (restaurar vida propia o de un aliado).

4. **Ingeniero:**
   - **Vida:** 110
   - **Ataque:** 25
   - **Defensa:** Baja
   - **Arma asignada:** Trampa explosiva
   - **Habilidad especial:** Colocar trampas que dañan a enemigos.

---

### **Armas**
Armas disponibles en el tablero que los jugadores pueden recoger:

1. **Cuchillo:** Daño bajo, siempre disponible.
2. **Fusil:** Puede atacar en horizontal, vertical o diagonal.
3. **Escopeta:** Puede atacar en horizontal o vertical y tiene más daño que el fusil.
4. **Rifle de francotirador:** Altísimo daño a larga distancia. Permite atacar sin estar en el mismo cuadrante (atacar a cuadrante contiguo) y luego moverse.
5. **Cañón de plasma:** Ataque masivo en área (arma rara).

---

### **Mapas**
El tablero inicial es de 12x12 y se reduce gradualmente:

- **12x12:** Inicio del juego.
- **10x10:** Después de 2 rondas.
- **8x8:** Después de 4 rondas.
- **6x6:** Después de 6 rondas.
- **4x4:** Después de 8 rondas.

---

### **Organización del Código**

| Clase                | Descripción                                |
|----------------------|--------------------------------------------|
| `Entidad`            | Clase abstracta base para jugadores y enemigos. |
| `Jugador`            | Hereda de `Entidad`. Representa un jugador.  |
| `Arma`               | Clase para las armas.                      |
| `Mapa`               | Gestión del tablero y reducción.           |
| `Game`               | Controla el flujo de las rondas.           |
| `Combate`            | Gestión de los enfrentamientos.            |

---

## **Métodos por Clase**

### **Clase `Entidad` (Abstracta)**
- **`mover(int direccion)`**: Permite a la entidad moverse en el tablero (arriba, abajo, izquierda, derecha).
- **`atacar(Entidad objetivo)`**: Realiza un ataque a otra entidad.
- **`usarHabilidad()`**: Activa la habilidad especial de la entidad.
- **`recibirDaño(int daño)`**: Reduce la vida de la entidad según el daño recibido.

### **Clase `Jugador` (Hereda de `Entidad`)**
- **`recogerArma(Arma arma)`**: Recoge un arma de la casilla actual y aplica bonificación si es su arma asignada.
- **`usarObjetoEspecial()`**: Ejecuta acciones especiales como curación o trampas.

### **Clase `Arma`**
- **`getTipo()`**: Devuelve el tipo de arma.
- **`getDaño()`**: Devuelve el daño base del arma.
- **`usar()`**: Realiza una acción de ataque con el arma.

### **Clase `Mapa`**
- **`generarTablero(int size)`**: Inicializa el tablero con un tamaño dado.
- **`colocarJugadores(List<Entidad> entidades)`**: Ubica jugadores y objetos aleatoriamente en el tablero.
- **`reducirTablero()`**: Reduce el tamaño del tablero eliminando filas y columnas exteriores.
- **`imprimirMapa()`**: Muestra el estado actual del tablero en la consola.

### **Clase `Game(Main)`**
- **`iniciarJuego()`**: Configura y comienza el juego.
- **`siguienteTurno()`**: Controla el flujo de las acciones de cada jugador por turno.
- **`verificarGanador()`**: Comprueba si hay un ganador.

### **Clase `Combate`**
- **`iniciarCombate(Entidad atacante, Entidad defensor)`**: Maneja la lógica del combate entre dos entidades.
- **`calcularDaño(Entidad atacante, Entidad defensor)`**: Aplica el daño calculado de un ataque.
- **`resultadoCombate()`**: Determina el ganador del combate y actualiza las posiciones.

---
