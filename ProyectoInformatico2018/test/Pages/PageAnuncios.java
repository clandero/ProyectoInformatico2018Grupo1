/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 *
 * @author Martin
 */
public class PageAnuncios {
    private WebDriver driver;
    private By anunciosButton;
    private By tags_h5;
    private By intereses;
    
    public PageAnuncios(WebDriver driver){
        this.driver = driver;
        anunciosButton = By.xpath("//a[@href='anuncios']");
        tags_h5 = By.tagName("h5");
        intereses = By.tagName("li");
    }
    
    public void searchAnuncios(){
        ArrayList<WebElement> list_Intereses = (ArrayList<WebElement>) driver.findElements(intereses);
        WebElement anuncios_Button = driver.findElement(anunciosButton);
        
        for(int i = 0; i < list_Intereses.size(); i++){
            String auxText = list_Intereses.get(i).getText();
            if(auxText.contains("pdf") || auxText.contains("@") || auxText.contains("Departamento") || auxText.contains("Nombre")){
                list_Intereses.remove(i);
            }
        }
        list_Intereses.remove(0);
        ArrayList<String> arrayList_Intereses = new ArrayList<String>();
        for(WebElement element : list_Intereses){
            arrayList_Intereses.add(element.getText());
        }
        
        anuncios_Button.click();
        
        ArrayList<WebElement> list_h5 = (ArrayList<WebElement>) driver.findElements(tags_h5);
        ArrayList<String> temas_anuncios = new ArrayList<String>();
        int tam = list_h5.size();
        for(int j = 0; j < tam; j++){
            String auxText = list_h5.get(j).getText();
            
            if(auxText.contains("Tem")){
                //System.out.println(auxText);
                String[] splitting = auxText.split(" ");
                int i = 0;
                for(String element: splitting){
                    if(i == 1){
                        temas_anuncios.add(element);
                    }
                    i++;
                }
            }
        }
        
        boolean bool = false;
        for(int i = 0; i < temas_anuncios.size(); i++){
            for(int j = 0; j < arrayList_Intereses.size(); j++){
                if(i == j){
                    bool = true;
                }
            }
        }

        
        Assert.assertTrue(bool);
        
    }
    
}
