package BattleTerminal;

//Clase base para personajes
abstract class Personaje {
 protected String nombre;
 protected int vidaInicial;
 protected Arma armaInicial;

 public Personaje(String nombre, int vidaInicial, Arma armaInicial) {
     this.nombre = nombre;
     this.vidaInicial = vidaInicial;
     this.armaInicial = armaInicial;
 }

 public abstract void activarHabilidadEspecial(Jugador jugador);

 public int getVidaInicial() {
     return vidaInicial;
 }

 public Arma getArmaInicial() {
     return armaInicial;
 }

 public String getNombre() {
     return nombre;
 }
}