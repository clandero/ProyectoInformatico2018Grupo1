package Modelos;

public class AreadeInteres {
    private String tema;
    
    public AreadeInteres(){
    }
    
    public AreadeInteres(String x){
        this.tema = x;
    }
    public void setTema(String x){
        this.tema = x;
    }
    public String getTema(){
        return this.tema;
    }
}
