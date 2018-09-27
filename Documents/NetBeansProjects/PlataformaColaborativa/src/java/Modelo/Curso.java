package Modelos;

public class Curso {
    private int codigo_curso;
    private String nombre_curso;
    
    public Curso(){
    }
    public Curso(int codigo, String nombre){
        this.codigo_curso = codigo;
        this.nombre_curso = nombre;
    }
    public void setNombre(String nombre){
        this.nombre_curso = nombre;
    }
    public void setCodigo(int codigo){
        this.codigo_curso = codigo;
    }
    public String getNombre(){
        return this.nombre_curso;
    }
    public int getCodigo(){
        return this.codigo_curso;
    }

}
