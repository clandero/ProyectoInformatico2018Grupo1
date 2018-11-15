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
public class PageEditPerfil {
    private WebDriver driver;
    private By newArea1;
    private By newArea2;
    private By submitButton;
    private By editButton;
    private By listIntereses;
    private ArrayList<String> newIntereses = new ArrayList<String>();
    
    public PageEditPerfil(WebDriver driver){
        this.driver = driver;
        newArea1 = By.xpath("//input[@value='Optimización']");
        newArea2 = By.xpath("//input[@value='Inteligencia Artificial']");
        submitButton = By.xpath("//input[@value='Guardar cambios']");
        editButton = By.id("editButton");
        listIntereses = By.tagName("li");
        newIntereses.add("Inteligencia Artificial");
        newIntereses.add("Optimización");
        
    }
    
    public void EditPerfil(){
        WebElement edit_button = driver.findElement(editButton);
        edit_button.click();
        
        WebElement checkbox1 = driver.findElement(newArea1);
        WebElement checkbox2 = driver.findElement(newArea2);
        
        checkbox1.click();
        checkbox2.click();
        
        WebElement submit_button = driver.findElement(submitButton);
        submit_button.click();
        
        ArrayList<WebElement> list_Intereses = (ArrayList<WebElement>)driver.findElements(listIntereses);
        for(int i = 0; i < list_Intereses.size(); i++){
            String auxText = list_Intereses.get(i).getText();
            if(auxText.contains("pdf") || auxText.contains("@") || auxText.contains("Departamento") || auxText.contains("Nombre")){
                list_Intereses.remove(i);
            }
        }
        list_Intereses.remove(0);
        ArrayList<String> list_InteresesActual = new ArrayList<String>();
        for(WebElement element: list_Intereses){
            list_InteresesActual.add(element.getText());
            System.out.println(element.getText());
        }
        boolean bool = false;
        if(list_InteresesActual.equals(newIntereses)){
            bool = true;
        }

        Assert.assertTrue(bool);
    }

}
