# Organización del Código: Battle Terminal

## **Clases y Subclases**

Esta organización sigue un enfoque jerárquico, de lo abstracto a lo concreto, con el fin de facilitar futuras expansiones o modificaciones del código.

---

## **1. Clases Abstractas y Base**

### **1.1. `Entidad`**
- Representa cualquier entidad del juego (jugadores, enemigos, etc.).
- **Atributos:**
  - `nombre`: Nombre de la entidad.
  - `vida`: Puntos de vida actuales.
  - `posicion`: Coordenadas actuales en el tablero.
- **Métodos:**
  - `mover(posicionNueva)`: Cambia la posición de la entidad.
  - `recibirDano(cantidad)`: Reduce la vida de la entidad.
  - `estaVivo()`: Retorna si la vida es mayor a 0.

### **1.2. `Objeto`**
- Base para cualquier objeto interactivo en el tablero.
- **Atributos:**
  - `tipo`: Tipo de objeto (arma, trampa, etc.).
  - `posicion`: Ubicación en el tablero.
- **Métodos:**
  - `usar(entidad)`: Aplica el efecto del objeto a una entidad.

---

## **2. Clases de Jugadores y Personajes**

### **2.1. `Jugador` (Hereda de `Entidad`)
- Representa a un jugador controlado por un usuario.
- **Atributos:**
  - `personaje`: Tipo de personaje seleccionado.
  - `arma`: Arma equipada actualmente.
  - `habilidadEspecialDisponible`: Indica si la habilidad especial está lista para usarse.
- **Métodos:**
  - `usarHabilidadEspecial()`: Activa la habilidad especial del personaje.
  - `equiparArma(armaNueva)`: Cambia el arma actual.

### **2.2. `Personaje` (Clase Base para los Tipos de Personajes)**
- Define características y habilidades comunes.
- **Subclases:**
  - `Soldado`:
    - Bonificación con fusil.
    - Habilidad: Contraataque.
  - `Explorador`:
    - Bonificación con escopeta.
    - Habilidad: Movimiento rápido.
  - `Médico`:
    - Bonificación con rifle de francotirador.
    - Habilidad: Curación rápida.
  - `Ingeniero`:
    - Bonificación con cañón de plasma.
    - Habilidad: Colocar trampas.

---

## **3. Clases de Objetos y Armas**

### **3.1. `Arma` (Hereda de `Objeto`)
- Representa armas que los jugadores pueden usar.
- **Atributos:**
  - `daño`: Cantidad de daño que inflige el arma.
  - `rango`: Alcance del ataque.
  - `bonificacion`: Porcentaje de bonificación para personajes compatibles.
- **Subclases:**
  - `Cuchillo`:
    - Daño básico, sin restricciones de uso.
  - `Fusil`:
    - Ataque en línea recta y diagonal.
  - `Escopeta`:
    - Mayor daño, pero rango más limitado.
  - `RifleFrancotirador`:
    - Alto daño, mejora la visibilidad de enemigos.
  - `CanonPlasma`:
    - Ataque en área.

### **3.2. `Trampa` (Hereda de `Objeto`)
- Daña al jugador que pisa la casilla.
- **Atributos:**
  - `daño`: Cantidad de daño infligido.

---

## **4. Clases del Tablero y Gestión del Juego**

### **4.1. `Tablero`**
- Administra la representación y el estado del mapa.
- **Atributos:**
  - `dimensiones`: Tamaño actual del tablero.
  - `casillas`: Matriz que representa las casillas (vacías, ocupadas, etc.).
- **Métodos:**
  - `inicializarTablero(jugadores, objetos)`: Coloca jugadores y objetos aleatoriamente.
  - `actualizarTablero()`: Reduce las dimensiones del tablero y ajusta posiciones.
  - `imprimirMapa(jugador)`: Muestra el mapa visible al jugador.

### **4.2. `Partida`**
- Controla el flujo del juego.
- **Atributos:**
  - `jugadores`: Lista de jugadores activos.
  - `tablero`: Instancia de la clase `Tablero`.
  - `rondaActual`: Número de ronda en curso.
- **Métodos:**
  - `iniciarJuego()`: Configura el inicio de la partida.
  - `realizarTurno(jugador)`: Maneja las acciones del jugador.
  - `procesarBatallas()`: Resuelve enfrentamientos entre jugadores adyacentes.
  - `finalizarRonda()`: Reduce el tablero y verifica condiciones de victoria.
  - `mostrarGanador()`: Anuncia al ganador.

---

## **5. Utilidades y Helper Classes**

### **5.1. `InputHelper`**
- Maneja la entrada del usuario.
- **Métodos:**
  - `pedirNumero(prompt, rango)`: Solicita un número dentro de un rango.
  - `pedirOpcion(prompt, opciones)`: Solicita la selección de una opción.

### **5.2. `RandomHelper`**
- Genera posiciones y números aleatorios.
- **Métodos:**
  - `posicionAleatoria(dimensiones)`: Devuelve coordenadas aleatorias.
  - `colocarAleatorio(lista, tablero)`: Distribuye jugadores y objetos aleatoriamente.

---

## **Diagrama Jerárquico Simplificado**
```
Entidad
│
├── Jugador
│   ├── Soldado
│   ├── Explorador
│   ├── Médico
│   └── Ingeniero
│
├── HabilidadEspecial
│   ├── Contraataque
│   ├── MovimientoRapido
│   ├── CuracionRapida
│   └── ColocarTrampas
│
└── Objeto
    ├── Arma
    │   ├── Cuchillo
    │   ├── Fusil
    │   ├── Escopeta
    │   ├── RifleFrancotirador
    │   └── CanonPlasma
    └── Trampa

Tablero
├── TableroBase  (Clase base lógica del tablero)
├── TableroConsola  (Para representarlo en consola)
└── TableroGrafico  (Extiende la funcionalidad para GUI)
     ├── VentanaPrincipal
     ├── PanelJuego
     ├── PanelJugador
     └── ControlEventos

Partida
├── LogicaPartida  (Controla las reglas y el flujo del juego)
└── InterfazPartida  (Se comunica con la GUI para mostrar los cambios)
```

## **Relaciones entre Clases**
```
Jugador <|-- Soldado
        <|-- Explorador
        <|-- Médico
        <|-- Ingeniero

HabilidadEspecial <|-- Contraataque
                  <|-- MovimientoRapido
                  <|-- CuracionRapida
                  <|-- ColocarTrampas

Objeto <|-- Arma
       <|-- Trampa

Arma <|-- Cuchillo
     <|-- Fusil
     <|-- Escopeta
     <|-- RifleFrancotirador
     <|-- CanonPlasma

TableroBase <|-- TableroConsola
            <|-- TableroGrafico

Partida <|-- LogicaPartida
        <|-- InterfazPartida
```

## **Diagrama Estructura de Archivos**
```
src/
├── entidad/
│   ├── Jugador.java
│   ├── Soldado.java
│   ├── Explorador.java
│   ├── Médico.java
│   ├── Ingeniero.java
│   ├── HabilidadEspecial.java
│   ├── Contraataque.java
│   ├── MovimientoRapido.java
│   ├── CuracionRapida.java
│   ├── ColocarTrampas.java
│   ├── Objeto.java
│   ├── Arma.java
│   ├── Cuchillo.java
│   ├── Fusil.java
│   ├── Escopeta.java
│   ├── RifleFrancotirador.java
│   ├── CanonPlasma.java
│   └── Trampa.java
├── tablero/
│   ├── TableroBase.java
│   ├── TableroConsola.java
│   └── TableroGrafico.java
├── partida/
│   ├── LogicaPartida.java
│   └── InterfazPartida.java
└── Main.java
```
