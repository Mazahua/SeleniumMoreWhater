package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", //directorio de archivos .feature
        glue = "steps", //paquete donde tenemos nuestras clases definiendo los steps escritos en el feeature file
        plugin = { "pretty","html:target/cucumber-reports" }
)

public class TestRunner {
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}
