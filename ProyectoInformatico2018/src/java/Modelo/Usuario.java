package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String correo;
    private String nombre_usuario;
    private String tipo_usuario;
    private String departamento;
    private int n_departamento;

    private String password;
    private List<AreadeInteres> intereses;

    public Usuario() {
        this.intereses = new ArrayList<AreadeInteres>();
    }

    public Usuario(String name, String c, String p, String departamento, int d, String t) {
        this.nombre_usuario = name;
        this.correo = c;
        this.password = p;
        this.departamento = departamento;
        this.n_departamento = d;
        this.tipo_usuario = t;
        this.intereses = new ArrayList<AreadeInteres>();
    }

    public Usuario(String name, String c, String p, int d, String t) {
        this.nombre_usuario = name;
        this.correo = c;
        this.password = p;
        this.n_departamento = d;
        this.tipo_usuario = t;
        this.intereses = new ArrayList<AreadeInteres>();
    }

    public Usuario(String c, String name, String intereses) {
        this.correo = c;
        this.nombre_usuario = name;
        this.tipo_usuario = "user";
        this.intereses = new ArrayList<>();
        String[] intereses_list = intereses.split(" ");
        for (String inter : intereses_list) {
            this.intereses.add(new AreadeInteres(inter));
        }
    }

    public List<AreadeInteres> getIntereses() {
        return this.intereses;
    }
    
    public void addInteres(String x){
        this.intereses.add(new AreadeInteres(x));
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

    public int getDepartamento() {
        return n_departamento;
    }

    public void setDepartamento(int departamento) {
        this.n_departamento = departamento;
    }

    public void setPassword(String p) {
        this.password = p;
    }
}
