package Modelo;

public class Anuncio implements Comparable<Anuncio>{
    private String titulo;
    private int n_anun;
    private String usuario;
    private String contenido;
    private String fecha_subida;
    private String tema;
    public Anuncio(){
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
