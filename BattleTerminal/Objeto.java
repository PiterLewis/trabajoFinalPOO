package BattleTerminal;

//Clase base para objetos
abstract class Objeto {
 protected String nombre;
 protected int[] posicion;

 public Objeto(String nombre, int[] posicion) {
     this.nombre = nombre;
     this.posicion = posicion;
 }
 public String getTipo() {
     return nombre;
 }
}