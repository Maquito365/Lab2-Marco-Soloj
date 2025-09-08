public class JugadorLab {
    private String nombre;
    private int puntos;
    private int gamesGanados;

    public JugadorLab(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.gamesGanados = 0;
    }

    public String getnombre() {
        return nombre;
    }
    public int getpuntos() {
        return puntos;
    }
    public void setpuntos(int puntos){
        this.puntos = puntos;
    }
    public int getgamesGanados(){
        return gamesGanados;
    }
    public void setgamesGanados(int gamesGanados){
        this.gamesGanados = gamesGanados;
    }
}
