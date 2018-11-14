/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Martin
 */
public class PageEditPerfil {
    private WebDriver driver;
    private By newArea1;
    private By newArea2;
    private By submitButton;
    
    public PageEditPerfil(WebDriver driver){
        this.driver = driver;
        newArea1 = By.xpath("//input[@value='Optimizacion']");
        newArea2 = By.xpath("//input[@value='Inteligencia Artificial']");
        submitButton = By.xpath("//input[@value='Guardar cambios']");
    }
    
    public void changeArea(){
        WebElement checkbox1 = driver.findElement(newArea1);
        WebElement checkbox2 = driver.findElement(newArea2);
        WebElement submit_button = driver.findElement(submitButton);
        
        checkbox1.click();
        checkbox2.click();
        submit_button.click();
    }
}
