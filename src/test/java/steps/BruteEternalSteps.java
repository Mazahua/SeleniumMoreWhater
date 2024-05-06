package steps;



import java.nio.charset.Charset;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.PaginaPrincipal;


public class BruteEternalSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    
    @Given("I navigate to brute.eternaltwin.org")
        public void iNavigateToBET() {
            landingPage.navigateToBET();
        }

    @Then("the page should be displayed in English")
    public void verifyPageLanguage() {
        String actualTitle = landingPage.getPageTitle();
        Assert.assertEquals("La página no está en Ingles", "MyBrute", actualTitle);
    }

    @Then("the page shoulb be display in the correct title {word}")
    public void verifyPageTitle(String expectedTitle) {
        try {
            Thread.sleep(1000); // Espera de 10 segundos (10,000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Convertir la palabra esperada a UTF-8
        byte[] utf8Bytes = expectedTitle.getBytes(Charset.forName("UTF-8"));
        String expectedTitleUtf8 = new String(utf8Bytes, Charset.forName("UTF-8"));

        String actualTitle = landingPage.getPageTitle();
        Assert.assertEquals("El título de la página no coincide con el título esperado", expectedTitleUtf8, actualTitle);
    }


    @When("I push on the flag languaje {word}")
    public void navigationFooterLanguajetwo(String section) {
        System.setProperty("file.encoding", "UTF-8");
        landingPage.clickOnImgLanguage(section);
    }

}
