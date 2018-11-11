package Modelo;

public class Anuncio implements Comparable<Anuncio>{
    private String titulo;
    private int n_anun;
    private String usuario;
    private String contenido;

    private java.sql.Date fecha_anuncio;
    private String correo;
    private String fecha_subida;
    private String tema;   
  
    public Anuncio(){
    }
    
    public Anuncio(String titulo, String cont){
        this.titulo = titulo;
        this.contenido = cont;
    }
  
    public Anuncio(int n, String titulo, String usuario, String cont, String fecha, String tema){
        this.n_anun = n;
        this.titulo = titulo;
        this.usuario = usuario;
        this.contenido = cont;
        this.fecha_subida = fecha;
        this.tema = tema;
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
    public void setUsuario(String cont){
        this.usuario = cont; 
    }
    public String getUsuario(){
        return this.usuario;
    }
    public void setFecha(String cont){
        this.fecha_subida = cont; 
    }
    
    public String getFecha(){
        return this.fecha_subida;
    }
    public int getNumero(){
        return this.n_anun;
    }

    public java.sql.Date getFecha_anuncio() {
        return fecha_anuncio;
    }

    public void setFecha_anuncio(java.sql.Date fecha_anuncio) {
        this.fecha_anuncio = fecha_anuncio;
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
    
    public void setTema(String cont){
        this.tema = cont; 
    }
    public String getTema(){
        return this.tema;
    }
    public void setTitulo(String cont){
        this.titulo = cont; 
    }
    public String getTitulo(){
        return this.titulo;
    }
    @Override
    public int compareTo(Anuncio t){
        return Integer.compare(this.getNumero(),t.getNumero());
    }

}
