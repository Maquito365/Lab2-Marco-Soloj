public class CartaLab {
    private String simbolo;
    private boolean Revelada;
    private boolean Matched;

    public CartaLab(String simbolo){
        this.simbolo=simbolo;
        this.Revelada=false;
        this.Matched=false;
    }

    public String getSimbolo(){
        return simbolo;
    }
    public boolean isRevealed(){
        return Revelada;
    }
    public void setRevealed(boolean revelada){
        this.Revelada = revelada;
    }
    public boolean isMatched(){
        return Matched;
    }
    public void setMatched(boolean matched){
        this.Matched = matched;
    }
    
}
