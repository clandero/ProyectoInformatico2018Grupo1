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
public class PageAnuncios {
    private WebDriver driver;
    private By anunciosButton;
    
    public PageAnuncios(WebDriver driver){
        this.driver = driver;
        anunciosButton = By.xpath("//a[@href='anuncios']");
    }
    
    public void searchAnuncios(){
        WebElement anuncios_Button = driver.findElement(anunciosButton);
        anuncios_Button.click();
    }
    
    public void assertCorrectPage(){
        String PATH = "/html/body/div[2]/div/div[1]/h2";
        Assert.assertTrue(driver.findElement(By.xpath(PATH)).getText().contains("Título"));
    }
    
}
