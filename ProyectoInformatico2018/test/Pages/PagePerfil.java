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
import org.testng.Assert;

/**
 *
 * @author Martin
 */
public class PagePerfil {
    private WebDriver driver;
    private By titleText;
    private By searchField;
    private By searchTypeDrop;
    private By submitButton;
    private By deleteButton;
    
    public PagePerfil(WebDriver driver) {
        this.driver = driver;
        titleText = By.xpath("/html/body/div[1]/a[1]");
        searchField = By.name("Buscar");
        searchTypeDrop = By.name("opcion");
        submitButton = By.name("Enviar");
        deleteButton = By.id("delButton");
    }
    
    public void SearchSomeone(String searchText){
        WebElement search_box = driver.findElement(searchField);
        search_box.sendKeys(searchText);
    }
    
    public void selectSearchType(String searchType){
        WebElement submit_button = driver.findElement(submitButton);
        
        Select selectType = new Select(driver.findElement(searchTypeDrop));
        System.out.println(searchType);
        selectType.selectByVisibleText(searchType);
        submit_button.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public void DeleteDocuments(){
        WebElement delete_button = driver.findElement(deleteButton);
        delete_button.click();
        
        
    }
    
    public void assertCorrectPage() {
        //System.out.println(driver.findElement(By.xpath("/html/body/div[1]/a[1]")).getText());
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Perfil"));
    }
    /*
    public void assertIncorrectPage() {
        Assert.assertFalse(driver.findElement(titleText).getText().contains("Perfil"));
    }*/
    
    
}
