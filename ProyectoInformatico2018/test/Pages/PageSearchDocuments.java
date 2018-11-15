/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        titleText = By.tagName("td");
    }
    
    public void assertPage(){
        List<WebElement> listWebElements = driver.findElements(titleText);

        boolean bool = false;
        for(int i = 0; i < listWebElements.size(); i++){
            if(listWebElements.get(i).getText().contains("@")){
                bool = true;
            }
        }
        
        Assert.assertTrue(bool);
    }
}
