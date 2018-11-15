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

/**
 *
 * @author Martin
 */
public class PageDeleteAnuncio {
    private WebDriver driver;
    private By tags_h2;
    
    public PageDeleteAnuncio(WebDriver driver){
        this.driver = driver;
        tags_h2 = By.tagName("h2");
    }
    
    public void deleteAnuncio(){
        ArrayList<WebElement> list_h2 = (ArrayList<WebElement>) driver.findElements(tags_h2);
        ArrayList<String> titulos = new ArrayList<String>();
        for(int i = 0; i < list_h2.size(); i++){
            String auxText = list_h2.get(i).getText();
            if(auxText.contains("Título")){
                String[] splitting = auxText.split(": ");
                int j = 0;
                for(String element : splitting){
                    if(j == 1){
                        titulos.add(element);
                    }
                    j++;
                }
            }
        }
        String deleteTitulo = titulos.get(1);
    }
}
