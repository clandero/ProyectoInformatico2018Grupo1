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
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Martin
 */
public class PageRegister {
    private WebDriver driver;
    private By nameField;
    private By userField;
    private By passField;
    private By userTypeDrop;
    private By departmentButton;
    private By submitButton;
    
    public PageRegister(WebDriver driver) {
        this.driver = driver;
        nameField = By.name("txtNombre");
        userField = By.name("txtCorreo");
        passField = By.name("txtPassword");
        userTypeDrop = By.name("search_categories");
        departmentButton = By.xpath("//input[@name='radio' and @value='Ingeniería Química']");
        submitButton = By.xpath("//input[@value ='Enviar']");
    }
    
    public void register(String name, String email, String pass) {
        WebElement name_box = driver.findElement(nameField);
        WebElement user_box = driver.findElement(userField);
        WebElement pass_box = driver.findElement(passField);
        
        name_box.sendKeys(name);
        user_box.sendKeys(email);
        pass_box.sendKeys(pass);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }
    
    public void selectUserType(String userType) {
        Select selectUserType = new Select(driver.findElement(userTypeDrop));
        selectUserType.selectByVisibleText(userType);
    }
    
    public void selectDepartment() {
        WebElement radioButton = driver.findElement(departmentButton);
        WebElement submit_button = driver.findElement(submitButton);
        
        radioButton.click();
        submit_button.click();           
    }
    
    
}
