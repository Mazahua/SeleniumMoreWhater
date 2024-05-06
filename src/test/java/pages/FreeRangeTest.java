package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class FreeRangeTest {
    
private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //inicializamos el driver para chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void navegamosABruteEternal() {
        driver.get("https://brute.eternaltwin.org");
    }
    
    @AfterMethod
    public void tearDown() {
        //cerrar el navegador
        if (driver != null){
            driver.quit();
        }
    }

}
