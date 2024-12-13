# Clase `Entidad`

## **Descripción**
La clase `Entidad` es una clase abstracta que actúa como la base para todas las entidades del juego, incluidos los jugadores y enemigos. Define las propiedades y comportamientos comunes que comparten todos los actores en el tablero.

---

## **Propiedades**
### **Atributos principales:**
- **`vida`** (`int`): Representa la cantidad de salud de la entidad.
- **`ataque`** (`int`): Define el poder de ataque de la entidad.
- **`defensa`** (`int`): Reduce el daño recibido en combate.
- **`posicion`** (`int[]`): Guarda las coordenadas actuales de la entidad en el tablero.

---

## **Métodos**

### **Métodos abstractos**
1. **`mover(int direccion)`**  
   - Permite a la entidad moverse en una dirección específica:
     - `0`: Arriba
     - `1`: Abajo
     - `2`: Izquierda
     - `3`: Derecha  
   - Actualiza las coordenadas de la entidad en el tablero.

2. **`usarHabilidad()`**  
   - Activa la habilidad especial única de la entidad. Su implementación varía en las subclases.

---

### **Métodos comunes**
1. **`atacar(Entidad objetivo)`**  
   - Realiza un ataque sobre otra entidad. El daño se calcula como:  
     ```java
     dañoReal = this.ataque - objetivo.defensa;
     ```
   - Reduce la vida del objetivo por la cantidad de daño infligido.

2. **`recibirDaño(int daño)`**  
   - Reduce la salud de la entidad según el daño recibido, considerando la defensa. Si la vida llega a 0 o menos, la entidad queda eliminada.

3. **`esVivo()`**  
   - Retorna `true` si la vida es mayor que 0, de lo contrario, retorna `false`.

---

## **Diagrama de Herencia**

```plaintext
Entidad (abstracta)
│
├── Jugador
│   ├── Soldado
│   ├── Explorador
│   ├── Médico
│   └── Ingeniero
└── Enemigo (futuras expansiones)
