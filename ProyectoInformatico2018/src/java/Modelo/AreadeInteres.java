package Modelo;

public class AreadeInteres {

    private String tema;

    public AreadeInteres() {
    }

    public AreadeInteres(String x) {
        this.tema = x;
    }

    public AreadeInteres(AreadeInteres area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTema(String x) {
        this.tema = x;
    }

    public String getTema() {
        return this.tema;
    }
}
