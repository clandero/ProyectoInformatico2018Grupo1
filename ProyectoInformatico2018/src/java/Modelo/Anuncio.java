package Modelo;

public class Anuncio {
    private int n_anun;
    private String contenido;
    private String titulo;
    private java.sql.Date fecha_anuncio;
    private String correo;
    
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

    public java.sql.Date getFecha_anuncio() {
        return fecha_anuncio;
    }

    public void setFecha_anuncio(java.sql.Date fecha_anuncio) {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
