package Modelos;

public class Anuncio {
    private int n_anun;
    private String contenido;
    
    public Anuncio(){
    }
    
    public Anuncio(int n, String cont){
        this.n_anun = n;
        this.contenido = cont;
    }
    
    public void setNumero(int n){
        this.n_anun = n;
    }
    public void setContent(String cont){
        this.contenido = cont; 
    }
    public String getContent(){
        return this.contenido;
    }
    public int getNumero(){
        return this.n_anun;
    }
}
