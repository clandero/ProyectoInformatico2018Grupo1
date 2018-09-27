package Modelos;

public class Documento {
    private int id;
    
    public Documento(){
    }
    
    public Documento(int x){
        this.id = x;
    }
    public void setID(int x){
        this.id = x;
    }
    public int getID(){
        return this.id;
    }
    
}
