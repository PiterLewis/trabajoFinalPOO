package BattleTerminal;

//Clase abstracta base para todas las entidades
//Clase abstracta base para todas las entidades
abstract class Entidad {
 protected String nombre;
 protected int vida;
 protected int[] posicion;

 public Entidad(String nombre, int vida, int[] posicion) {
     this.nombre = nombre;
     this.vida = vida;
     this.posicion = posicion;
 }

 public boolean estaVivo() {
     return vida > 0;
 }

 public void recibirDano(int cantidad) {
     vida -= cantidad;
     if (vida < 0) vida = 0;
 }

 public void mover(int[] nuevaPosicion) {
     this.posicion = nuevaPosicion;
 }

 public int[] getPosicion() {
     return posicion;
 }
}