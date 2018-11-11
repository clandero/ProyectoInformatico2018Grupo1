/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Pages.PageLogin;
import Pages.PagePerfil;
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
public class TestingLogin {
    
    private static WebDriver driver;
        
    @BeforeMethod
    public static void setUp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        String PATH = "Drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", PATH);
        
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
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
    
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    
}
