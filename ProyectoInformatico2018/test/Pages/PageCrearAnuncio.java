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
public class PageCrearAnuncio {
    private WebDriver driver;
    private By crearAnuncioButton;
    private By txtTitulo;
    private By dropArea;
    private By txtContenido;
    private By submitButton;
    private By tags_h2;
    
    public PageCrearAnuncio(WebDriver driver){
        this.driver = driver;
        crearAnuncioButton = By.xpath("//a[@href='crearAnuncio.jsp']");
        txtTitulo = By.name("txtTitulo");
        dropArea = By.name("txtArea");
        txtContenido = By.name("txtContenido");
        submitButton = By.xpath("//input[@value='Crear']");
        tags_h2 = By.tagName("h2");
    }
    
    public void crearAnuncio(){
        WebElement crearAnuncio_Button = driver.findElement(crearAnuncioButton);
        crearAnuncio_Button.click();
        
        WebElement titulo_box = driver.findElement(txtTitulo);
        String titulo = "Memoria de titulo 1";
        titulo_box.sendKeys(titulo);
        
        Select selectAreaType = new Select(driver.findElement(dropArea));
        selectAreaType.selectByVisibleText("Optimización");
        
        WebElement contenido_box = driver.findElement(txtContenido);
        String contenido = "bla bla bla bla bla";
        contenido_box.sendKeys(contenido);
        
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
            if(element.contains(titulo)){
                bool = true;
            }
        }
        
        Assert.assertTrue(bool);
    }
}
