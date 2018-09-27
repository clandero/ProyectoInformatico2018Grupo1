package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String correo;
    private String nombre_usuario;
    private String tipo_usuario;
    private List<AreadeInteres> intereses;

    public List<AreadeInteres> getIntereses() {
        return intereses;
    }

    public void setIntereses(AreadeInteres intereses) {
        this.intereses.add(intereses);
    }
    
    public Usuario(){
    }
    
    public Usuario(String c, String name, String t){
        this.correo = c;
        this.nombre_usuario = name;
        this.tipo_usuario = t;
        this.intereses = new ArrayList<AreadeInteres>();
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
}
