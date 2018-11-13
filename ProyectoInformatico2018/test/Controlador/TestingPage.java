/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Helper.Helpers;
import Pages.PageDeleteDocuments;
import Pages.PageEditPerfil;
import Pages.PageLogin;
import Pages.PagePerfil;
import Pages.PageSearchDocuments;
import Pages.PageSearchSomeone;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author Martin
 */
public class TestingPage {
    
    private static WebDriver driver;
    private static PageLogin pageLogin;
    private static PagePerfil pagePerfil;
        
    @BeforeMethod
    public static void setUp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        String PATH = "Drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", PATH);
        
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/build/ingreso.jsp");
        
        pageLogin = new PageLogin(driver);
        pagePerfil = new PagePerfil(driver);
        
        pageLogin.login("mmmmm@udec.cl","mmmmm");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void SearchSomeoneTest(){
        PageSearchSomeone pageSearchSomeone = new PageSearchSomeone(driver);
        
        pagePerfil.SearchSomething("informatica");
        pagePerfil.selectSearchType("Departamento");
        
        pageSearchSomeone.assertPage();
    }
    
    @Test
    public void DeleteDocumentsTest(){
        PageDeleteDocuments pageDeleteDocuments = new PageDeleteDocuments(driver);
        
        pagePerfil.DeleteDocuments();
        pageDeleteDocuments.deleteDocument();
        
        pagePerfil.assertCorrectPage();
    }
    
    @Test
    public void EditPerfilTest(){
        PageEditPerfil pageEditPerfil = new PageEditPerfil(driver);
        
        pagePerfil.EditPerfil();
        pageEditPerfil.changeArea();
        //Helpers helper = new Helpers();
        //helper.sleepSeconds(3);
        pagePerfil.assertCorrectPage();
        
        //helper.sleepSeconds(3);
    }
    
    @Test
    public void SearchDocuments(){
        PageSearchDocuments pageSearchDocument = new PageSearchDocuments(driver);
        pagePerfil.SearchSomething("optimizacion");
        pagePerfil.SearchSomeDocument("Tema");
        //Helpers helper = new Helpers();
        //helper.sleepSeconds(3);
        pageSearchDocument.assertPage();
    }
    
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
