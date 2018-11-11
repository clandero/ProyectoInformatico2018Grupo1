/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Helper.Helpers;
import Pages.PageDeleteDocuments;
import Pages.PageLogin;
import Pages.PagePerfil;
import Pages.PageRegister;
import Pages.PageSearchSomeone;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author Martin
 */
public class TestingPage {
    
        private static WebDriver driver;
        
    @BeforeMethod
    public static void setUp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        String PATH = "C:\\Users\\Martin\\Desktop\\UdeC\\Martin\\2018 - 2\\Proyecto Informático\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", PATH);
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/build");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void LoginCorrectTest(){
        driver.navigate().to("http://localhost:8080/build/ingreso.jsp");
        PageLogin pageLogin = new PageLogin(driver);
        PagePerfil pagePerfil = new PagePerfil(driver);
        
        pageLogin.login("mmmmm@udec.cl","mmmmm");
        //Helpers helper = new Helpers();
        //helper.sleepSeconds(3);
        pagePerfil.assertCorrectPage();
    }

    @Test
    public void RegisterTest(){
        driver.navigate().to("http://localhost:8080/build/registro.jsp");
        PageRegister pageRegister = new PageRegister(driver);
        PagePerfil pagePerfil = new PagePerfil(driver);
        
        pageRegister.register("Tester Uno", "test@udec.cl", "test");
        pageRegister.selectUserType("Estudiante");
        pageRegister.selectDepartment();
        
        //Helpers helper = new Helpers();
        //helper.sleepSeconds(3);
        
        pagePerfil.assertCorrectPage();
    }
    
    @Test
    public void SearchSomeoneTest(){
        driver.navigate().to("http://localhost:8080/build/ingreso.jsp");
        PageLogin pageLogin = new PageLogin(driver);
        PagePerfil pagePerfil = new PagePerfil(driver);
        PageSearchSomeone pageSearchSomeone = new PageSearchSomeone(driver);
        
        pageLogin.login("mmmmm@udec.cl","mmmmm");
        
        pagePerfil.SearchSomeone("informatica");
        pagePerfil.selectSearchType("Departamento");
        
        //Helpers helper = new Helpers();
        //helper.sleepSeconds(3);
        
        pageSearchSomeone.assertPage();
    }
    
    @Test
    public void DeleteDocumentsTest(){
        driver.navigate().to("http://localhost:8080/build/ingreso.jsp");
        PageLogin pageLogin = new PageLogin(driver);
        PagePerfil pagePerfil = new PagePerfil(driver);
        PageDeleteDocuments pageDeleteDocuments = new PageDeleteDocuments(driver);
        
        pageLogin.login("mmmmm@udec.cl","mmmmm");
        Helpers helper = new Helpers();
        helper.sleepSeconds(3);
        
        pagePerfil.DeleteDocuments();
        pageDeleteDocuments.deleteDocument();
        
        pagePerfil.assertCorrectPage();
        helper.sleepSeconds(3);
        
    }
    
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    
}
