import java.util.*;
public class VistaLab2 {

    public static void main(String[] args) {
        System.out.println("Bienvenido al juego de Memoria");
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar datos iniciales de jugadores y del tablero
        System.out.print("Ingrese el nombre del Jugador 1: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Ingrese el nombre del Jugador 2: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Ingrese el tamaño del tablero deseado, solo se aceptan números pares: ");
        int n = scanner.nextInt();
        
        ControladorLab2 controlador = new ControladorLab2(nombre1, nombre2, n);
        int t = 1; // Variable para el turno: 1 = jugador1, 2 = jugador2
        
        while (true) {
            System.out.println("Tablero de " + n + "x" + n);
            System.out.println(displayTablero(controlador.getTablero()));

            String turnoAct = (t == 1) ? controlador.getJugador1().getnombre() : controlador.getJugador2().getnombre();
            System.out.println("Turno de: " + turnoAct);
            System.out.println("Ingrese la fila y columna de la carta que quiere voltear");
            int fila1 = scanner.nextInt() - 1;
            int columna1 = scanner.nextInt() - 1;
            System.out.println("Ingrese la fila y columna de la segunda carta que quiere voltear");
            int fila2 = scanner.nextInt() - 1;
            int columna2 = scanner.nextInt() - 1;

            CartaLab carta1 = controlador.getTablero().getCarta(fila1, columna1);
            CartaLab carta2 = controlador.getTablero().getCarta(fila2, columna2);

            if (carta1 == null || carta2 == null) {
                System.out.println("Coordenadas inválidas");
                continue;
            }

            String resultado = "";
            if (t == 1) {
                resultado = controlador.jugar(controlador.getJugador1(), carta1, carta2);
            } else {
                resultado = controlador.jugar(controlador.getJugador2(), carta1, carta2);
            }
            System.out.println(resultado);
            System.out.println("Tablero de " + n + "x" + n);
            System.out.println(displayTablero(controlador.getTablero()));

            if (controlador.getTablero().FinJuego()) {
                System.out.println("¡Juego Terminado!");
                System.out.println(controlador.Victoria());
                System.out.print("¿Desea jugar otra partida? (s/n): ");
                String respuesta = scanner.next();
                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.print("Ingrese el tamaño del tablero deseado, solo se aceptan números pares: ");
                    n = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea pendiente
                    controlador = new ControladorLab2(nombre1, nombre2, n);
                    t = 1; // Reinicia el turno al jugador 1
                    continue;
                } else {
                    System.out.println("Gracias por jugar");
                    break;
                }
            }
            if (!resultado.contains("punto")) {
                t = (t == 1) ? 2 : 1;
            }
        }
        scanner.close();
    }
    
    // Método para generar la representación textual del tablero.
    // Recorre cada posición y muestra el símbolo de la carta si está revelada o emparejada;
    // de lo contrario muestra "X" para indicar que la carta está oculta.
    private static String displayTablero(TableroLab tablero) {
        StringBuilder sb = new StringBuilder();
        int n = tablero.getN();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                CartaLab carta = tablero.getCarta(i, j);
                if (carta.isRevealed() || carta.isMatched()){
                    sb.append(carta.getSimbolo()).append(" ");
                } else {
                    sb.append("X ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

