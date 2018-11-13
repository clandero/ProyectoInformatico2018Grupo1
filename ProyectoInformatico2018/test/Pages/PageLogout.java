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
public class PageLogout {
    private WebDriver driver;
    private By logoutButton;
    
    public PageLogout(WebDriver driver){
        this.driver = driver;
        logoutButton = By.xpath("//a[@href='logOut']");
    }
    
    public void logout(){
        WebElement logout_button = driver.findElement(logoutButton);
        
        logout_button.click();
    }
    
    public void assertCorrectPage(){
        String PATH = "/html/body/div[2]/div/h2";
        Assert.assertTrue(driver.findElement(By.xpath(PATH)).getText().contains("Bienvenido"));
    }
    
}
