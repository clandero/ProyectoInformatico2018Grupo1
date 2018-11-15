/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 *
 * @author Martin
 */
public class PagePersonas {
    private WebDriver driver;
    private By personasButton;
    private By tagP;
    private By intereses;
    
    public PagePersonas(WebDriver driver){
        this.driver = driver;
        personasButton = By.xpath("//a[@href='personas.jsp']");
        tagP = By.tagName("p");
        intereses = By.tagName("li");
    }
    
    public void SomeoneSameInterest(){
        
        ArrayList<WebElement> list_Intereses = (ArrayList<WebElement>) driver.findElements(intereses);
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
        
        WebElement personas_button = driver.findElement(personasButton);
        personas_button.click();
        
        ArrayList<WebElement> tags_P = (ArrayList<WebElement>) driver.findElements(tagP);
        
        for(int i = 0; i < tags_P.size(); i++){
            
            String auxText = tags_P.get(i).getText();
            if(auxText.contains("@")){
                //System.out.println(tags_P.get(i).getText());
                tags_P.remove(i);
            }
            /*if(auxText.contains("Ing")){
                tags_P.remove(i);
            }*/
        }
        for(int i = 0; i < tags_P.size(); i++){
            
            String auxText = tags_P.get(i).getText();
            if(auxText.contains("Ing")){
                tags_P.remove(i);
            }
        }
        
        ArrayList<String> temas_personas = new ArrayList<String>();
        for(WebElement element : tags_P){
            temas_personas.add(element.getText());
        }
        
        boolean bool = false;
        for(int i = 0; i < arrayList_Intereses.size(); i++){
            for(int j = 0; j < temas_personas.size(); j++){
                if(i == j){
                    bool = true;
                }
            }
        }
        
        Assert.assertTrue(bool);
        
    }
    
    
}
