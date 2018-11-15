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
public class PageDeleteDocuments {
    private WebDriver driver;
    private By deleteButton;
    private By documents;
    private By documentDelete;
    
    public PageDeleteDocuments(WebDriver driver){
        this.driver = driver;
        documentDelete = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/ul[1]"); //Toma el primer documento que encuentra en el perfil
        deleteButton = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/ul[1]/li/a[2]"); //
        documents = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/ul"); //Toma todos los documentos que encuentra en el perfil
    }
    
    public void deleteDocument(){
        
        WebElement document_delete = driver.findElement(documentDelete);
        String nameDocumentDelete = document_delete.getText();
        WebElement delete_button = driver.findElement(deleteButton);
        
        delete_button.click(); //Se elimina el documento
        List<WebElement> listDocuments = driver.findElements(documents); //Se obtiene la lista de los documentos (actualizada)
        
        boolean bool = false;
        if(listDocuments.size() == 0){
            bool = true;
        }
        else{
            for(int i = 0; i < listDocuments.size() ; i++){
                if(listDocuments.get(i).getText() == nameDocumentDelete){
                    bool = false;
                }
                else bool = true;
            }
        }
        
        Assert.assertTrue(bool);
    }
    
}
