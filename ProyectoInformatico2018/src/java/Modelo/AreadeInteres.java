package Modelo;

public class AreadeInteres implements Comparable<AreadeInteres>{

    private String tema;

    public AreadeInteres() {
    }

    public AreadeInteres(String x) {
        this.tema = x;
    }

    public void setTema(String x) {
        this.tema = x;
    }

    public String getTema() {
        return this.tema;
    }

    @Override
    public int compareTo(AreadeInteres t) {
        return this.getTema().compareTo(t.getTema());
    }

    
}
