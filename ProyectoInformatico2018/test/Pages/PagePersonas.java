/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

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
    
    public PagePersonas(WebDriver driver){
        this.driver = driver;
        personasButton = By.xpath("//a[@href='personas.jsp']");
        
    }
    
    public void SomeoneSameInterest(){
        WebElement personas_button = driver.findElement(personasButton);
        personas_button.click();
    }
    
    public void assertCorrectPage(){
        String PATH = "/html/body/div[2]/div/form[1]/div/p[2]";
        Assert.assertTrue(driver.findElement(By.xpath(PATH)).getText().contains("@"));
    }
    
}
