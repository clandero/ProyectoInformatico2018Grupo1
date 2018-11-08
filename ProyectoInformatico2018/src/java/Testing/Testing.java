/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 *
 * @author Martin
 */
public class Testing {
    
        private static WebDriver driver = null;
    
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Martin\\Desktop\\UdeC\\Martin\\2018 - 2\\Proyecto Informático\\chromedriver.exe");
        driver = new ChromeDriver();

        // And now use this to visit Google
        driver.get("http://localhost:8080/build/ingreso.jsp");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        //WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        //element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        //element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        WebElement user_box = driver.findElement(By.name("txtCorreo"));
        WebElement pass_box = driver.findElement(By.name("txtPassword"));
        WebElement submit_button = driver.findElement(By.name("login"));
        
        user_box.sendKeys("mmmmm@udec.cl");
        pass_box.sendKeys("mmmmm");
        submit_button.click();
        driver.quit();
       
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        //(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
        //    public Boolean apply(WebDriver d) {
        //        return d.getTitle().toLowerCase().startsWith("cheese!");
        /*    }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        driver.quit();*/
    }
    
}
