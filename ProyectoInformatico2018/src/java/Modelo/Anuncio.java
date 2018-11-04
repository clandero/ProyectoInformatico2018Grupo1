package Modelo;

public class Anuncio {
    private int n_anun;
    private String contenido;
    private String titulo;
    private String fecha_anuncio;
    
    public Anuncio(){
    }
    
    public Anuncio(String titulo, String cont){
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
    }

    public String getFecha_anuncio() {
        return fecha_anuncio;
    }

    public void setFecha_anuncio(String fecha_anuncio) {
        this.fecha_anuncio = fecha_anuncio;
    }
    

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getN_anun() {
        return n_anun;
    }

    public void setN_anun(int n_anun) {
        this.n_anun = n_anun;
    }
}
