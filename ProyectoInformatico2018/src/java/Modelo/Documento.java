package Modelo;

public class Documento {
    private int id;
    private String titulo;
    private String sv_path;
    private java.sql.Timestamp fecha_documento;
    
    public Documento(){
    }
    
    public Documento(int x){
        this.id = x;
    }
    
    public Documento(int x, String titulo, String sv_path){
        this.id = x;
        this.titulo = titulo;
        this.sv_path = sv_path;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setSvPath(String sv_path){
        this.sv_path = sv_path;
    }
    
    public void setID(int x){
        this.id = x;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getSvPath(){
        return this.sv_path;
    }
    
    public int getID(){
        return this.id;
    }
    
}
