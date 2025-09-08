public class ControladorLab2 {
  private TableroLab tablero;
  private JugadorLab jugador1;
  private JugadorLab jugador2;
  
    public ControladorLab2(String nombre1, String nombre2, int n){
        this.tablero = new TableroLab(n);
        this.jugador1 = new JugadorLab(nombre1);
        this.jugador2 = new JugadorLab(nombre2);
    }
    public TableroLab getTablero(){
        return tablero;
    }
    public JugadorLab getJugador1(){
        return jugador1;
    }
    public JugadorLab getJugador2(){
        return jugador2;
    }
    // Recibe a los jugadores, verifica primero que las cartas seleccionadas no sean las mismas, luego que no esten emparejadas
    // Revela las cartas y luego compara los símbolos y si son iguales las pone como emparejadas sino las oculta.
    public String jugar(JugadorLab jugador, CartaLab carta1, CartaLab carta2){
        if (carta1 == carta2){
            return "Las cartas seleccionadas son la misma. Seleccione dos cartas diferentes.";
        }
        if (carta1.isMatched() || carta2.isMatched()){
            return "Ya han encontrado la pareja de estas cartas. Seleccione otras cartas.";
        }
        carta1.setRevealed(true);
        carta2.setRevealed(true);

        if (carta1.getSimbolo().equals(carta2.getSimbolo())){
            carta1.setMatched(true);
            carta2.setMatched(true);
            jugador.setpuntos(jugador.getpuntos() + 1);
            return "Pareja encontrada, tienes un punto";
        }
        else{
            carta1.setRevealed(false);
            carta2.setRevealed(false);
            return "No son iguales xdd";
        }
    }// Reinicia el juego, creando un nuevo tablero y reiniciando los pts de ambos jugadores
    public void nuevoJuego(int n){
        tablero = new TableroLab(n);
        jugador1.setpuntos(0);
        jugador2.setpuntos(0);
    }
    //Ayuda a determinar el ganador del juego, priimero si uno de los dos pj tienen mayor pts
    //Aumenta su cantidad de victorias y dependiendo de quien tenga más pts gana sino muestra que quedaron en empate
    public String Victoria(){
        if (jugador1.getpuntos()>jugador2.getpuntos()){
            jugador1.setgamesGanados(jugador1.getgamesGanados()+1);
            return jugador1.getnombre() + " es el ganador de la partida";
        }
        else if (jugador2.getpuntos()>jugador1.getpuntos()){
            jugador2.setgamesGanados(jugador2.getgamesGanados()+1);
            return jugador2.getnombre() + " es el ganador de la partida";
        }
        else{
            return "La partida ha terminado en empate";
        }
    }

}
