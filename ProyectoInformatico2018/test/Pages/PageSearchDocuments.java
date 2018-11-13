/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 *
 * @author Martin
 */
public class PageSearchDocuments {
    private WebDriver driver;
    private By titleText;
    
    public PageSearchDocuments(WebDriver driver){
        this.driver = driver;
        titleText = By.xpath("/html/body/div[2]/div/div/div/div/table/tbody/tr[5]/td[3]");
    }
    
    public void assertPage(){
        Assert.assertTrue(driver.findElement(titleText).getText().contains("@"));
    }
}
