/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Pages.PageLogin;
import Pages.PageLogout;
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
public class TestingLogout {
    
    private static WebDriver driver;
    private static PageLogin pageLogin;
        
    @BeforeMethod
    public static void setUp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        String PATH = "Drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", PATH);
        
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/build/ingreso.jsp");
        
        pageLogin = new PageLogin(driver);

        pageLogin.login("mmmmm@udec.cl","mmmmm");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void LogoutTest(){
        PageLogout pageLogout = new PageLogout(driver);
        
        pageLogout.logout();

        pageLogout.assertCorrectPage();
    }
    
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    
}
