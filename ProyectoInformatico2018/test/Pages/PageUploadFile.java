/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import Helper.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 *
 * @author Martin
 */
public class PageUploadFile {
    private WebDriver driver;
    private By goUploadFileButton;
    private By examinarButton;
    private By temaDrop;
    private By uploadButton;
    
    public PageUploadFile(WebDriver driver){
        this.driver = driver;
        goUploadFileButton = By.xpath("//a[@href='upload']");
        examinarButton = By.name("file");
        temaDrop = By.name("tema");
        uploadButton = By.name("upload");
    }
    
    public void goUploadFile(){
        WebElement goUploadFile_button = driver.findElement(goUploadFileButton);
        
        goUploadFile_button.click();
        
        
    }
    
    public void uploadFile(){
        WebElement examinar_button = driver.findElement(examinarButton);
        Select selectType = new Select(driver.findElement(temaDrop));
        WebElement upload_button = driver.findElement(uploadButton);
        
        examinar_button.click();
        Helpers helper = new Helpers();
        helper.sleepSeconds(10);
        
        selectType.selectByVisibleText("Optimizacion");
        upload_button.click();
    }
    
    public void assertPage(){
        String PATH = "/html/body/div[2]";
        Assert.assertTrue(driver.findElement(By.xpath(PATH)).getText().contains("correctamente"));
    }
    
}
