import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TableroLab {
   private ArrayList<CartaLab> cartas;
   private int tamaño;
   private int n;

   public TableroLab(int n){
        this.n = n;
        this.tamaño = n*n;
        this.cartas = new ArrayList(tamaño);
        generarCartas();
   }
   public int getTamaño(){
        return tamaño;
   }
   public List<CartaLab> getCartas(){
        return cartas;
   }
   public int getN(){
        return n;
   }
   //Hace que la posición de la carta dependiendo de su fila y columna lo covierte en un índice
   // si esta dentro del rango osea mayor 0 y menor al tamaño del arreglo esa es la posición de la carta
   public CartaLab getCarta(int fila, int columna){
        int index = fila * n + columna;
        if(index >= 0 && index < tamaño){
            return cartas.get(index);
        }
        return null;
   }
   //Revisa mediante un recorrido de las cartas si todas estan emparejadas finaliza de lo contrario
   // retorna false significando que el juego no ha terminado
   public boolean FinJuego() {
    for(CartaLab carta : cartas){
        if (!carta.isMatched()){
            return false;
        }
    }
    return true;
   }
   //Método para generar las cartas en el tablero, calcula en base al tamaño del tablero la cantidad de pares
   // de cartas que se necesita y genera un símbolo para cada una con ASCII cambiandolo por pareja de carta
   // se añaden las cartas al tablero y las mezcla con el shuffle.
   private void generarCartas(){
        int paresMaximos = tamaño / 2;
        int cinicial = 33;
        for(int i=0; i<paresMaximos; i++){
            String simbolo = new String(Character.toChars(cinicial + i));
            cartas.add(new CartaLab(simbolo));
            cartas.add(new CartaLab(simbolo));
        }
        Collections.shuffle(cartas);
   } 
   
}
