package pages;


// Importaciones necesarias
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class BasePage {

     /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */

    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage (WebDriver driver){
        BasePage.driver = driver;
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    //encuentra y devuelve un webElement en la pagina utilizando un locator XPATH
    // esperando que este este presente en el DOM
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String keyToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keyToSend);
    }

    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    public int dowpdownSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

        // Método para obtener el título de la página
    public String getPageTitle() {
        return driver.getTitle();
    }



}
