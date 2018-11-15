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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 *
 * @author Martin
 */
public class PageEditarAnuncio {
    private WebDriver driver;
    private By editarButton;
    private By tituloAnuncio;
    private By contenidoAnuncio;
    private By dropArea;
    private By submitButton;
    private By tags_h2;
    
    public PageEditarAnuncio(WebDriver driver){
        this.driver = driver;
        editarButton = By.name("anuncio");
        tituloAnuncio = By.name("titulo_anuncio");
        contenidoAnuncio = By.name("contenido_anuncio");
        dropArea = By.name("area_anuncio");
        submitButton = By.xpath("//input[@value='Guardar']");
        tags_h2 = By.tagName("h2");
    }
    
    public void editarAnuncio(){
        WebElement edit_button = driver.findElement(editarButton);
        edit_button.click();
        
        WebElement titulo_box = driver.findElement(tituloAnuncio);
        WebElement contenido_box = driver.findElement(contenidoAnuncio);
        Select selectAreaType = new Select(driver.findElement(dropArea));
        
        String new_titulo = "Memoria de Titulo 2";
        titulo_box.clear();
        titulo_box.sendKeys(new_titulo);
        selectAreaType.selectByVisibleText("Inteligencia Artificial");
        contenido_box.clear();
        contenido_box.sendKeys("Why So Serious?");
        
        WebElement submit_button = driver.findElement(submitButton);
        submit_button.click();
        
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
        boolean bool = false;
        for(String element: titulos){
            if(element.contains(new_titulo)){
                bool = true;
            }
        }
        
        Assert.assertTrue(bool);
    }
}
