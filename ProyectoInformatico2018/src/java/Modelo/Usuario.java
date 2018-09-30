package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String correo;
    private String nombre_usuario;
    private String tipo_usuario;
    private String departamento;
    private String pass;

    
    public Usuario(){
    }
    
    public Usuario(String name, String c, String p, String d, String t){
        this.correo = c;
        this.nombre_usuario = name;
        this.tipo_usuario = t;
        this.departamento = d;
        this.pass = p;
    }
    public String getCorreo(){
        return this.correo;
    }
    public String getNombreUsuario(){
        return this.nombre_usuario;
    }
    public String getTipoUsuario(){
        return this.tipo_usuario;
    }
    public void setCorreo(String c){
        this.correo = c;
    }
    public void setNombreUsuario(String name){
        this.nombre_usuario = name;
    }
    public void setTipoUsuario(String t){
        this.tipo_usuario = t;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
