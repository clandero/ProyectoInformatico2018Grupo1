package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String correo;
    private String nombre_usuario;
    private String tipo_usuario;

    private String departamento;

    private String password;
    private List<AreadeInteres> intereses;

    public Usuario() {
    }

    public Usuario(String name, String c, String p, String d, String t) {
        this.nombre_usuario = name;
        this.correo = c;       
        this.password = p;
        this.departamento = d;
        this.tipo_usuario = t;
        
    }

    public Usuario(String c, String name, String intereses) {
        this.correo = c;
        this.nombre_usuario = name;
        this.tipo_usuario = "user";
        this.intereses = new ArrayList<AreadeInteres>();
        String[] intereses_list = intereses.split(" ");
        for (String inter : intereses_list) {
            this.intereses.add(new AreadeInteres(inter));
        }
    }

    public String getCorreo() {
        return this.correo;
    }

    public String getNombreUsuario() {
        return this.nombre_usuario;
    }

    public String getTipoUsuario() {
        return this.tipo_usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setCorreo(String c) {
        this.correo = c;
    }

    public void setNombreUsuario(String name) {
        this.nombre_usuario = name;
    }

    public void setTipoUsuario(String t) {
        this.tipo_usuario = t;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setPassword(String p) {
        this.password = p;
    }
}
