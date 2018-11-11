/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import Helper.Helpers;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Martin
 */
public class PageLogin {
    
    private WebDriver driver;
    private By userField;
    private By passField;
    private By submitButton;
    
    public PageLogin(WebDriver driver) {
        this.driver = driver;
        userField = By.name("txtCorreo");
        passField = By.name("txtPassword");
        submitButton = By.name("login");
    }
    
    public void login(String user, String pass) {
        WebElement user_box = driver.findElement(userField);
        WebElement pass_box = driver.findElement(passField);
        WebElement submit_button = driver.findElement(submitButton);
        
        user_box.sendKeys(user);
        pass_box.sendKeys(pass);
        submit_button.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}
