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
public class PageDeleteDocuments {
    private WebDriver driver;
    private By selectDocument;
    private By submitButton;
    
    public PageDeleteDocuments(WebDriver driver){
        this.driver = driver;
        selectDocument = By.xpath("//input[@value='Face Recognition']");
        submitButton = By.xpath("//input[@value ='Guardar cambios']");
    }
    
    public void deleteDocument(){
        WebElement checkbox =  driver.findElement(selectDocument);
        WebElement submit_button = driver.findElement(submitButton);
        
        checkbox.click();
        submit_button.click();
    }
    
}
