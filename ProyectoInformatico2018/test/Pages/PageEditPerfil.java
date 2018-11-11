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
    private By newArea;
    private By submitButton;
    
    public PageEditPerfil(WebDriver driver){
        this.driver = driver;
        newArea = By.xpath("//input[@value='Infraestructura Vial']");
        submitButton = By.xpath("//input[@value='Guardar cambios']");
    }
    
    public void changeArea(){
        WebElement checkbox = driver.findElement(newArea);
        WebElement submit_button = driver.findElement(submitButton);
        
        checkbox.click();
        submit_button.click();
    }
}
