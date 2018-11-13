/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Pages.PagePerfil;
import Pages.PageRegister;
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
public class TestingRegister {
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
    public void RegisterCorrectTest(){
        driver.navigate().to("http://localhost:8080/build/index");
        PageRegister pageRegister = new PageRegister(driver);
        PagePerfil pagePerfil = new PagePerfil(driver);
        
        pageRegister.register("Tester uno", "test1@udec.cl", "test");
        pageRegister.selectUserType("Estudiante");
        pageRegister.selectDepartment();
        
        pagePerfil.assertCorrectPage();
    }
    
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
