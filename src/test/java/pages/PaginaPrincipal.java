package pages;

public class PaginaPrincipal extends BasePage {

    
    private String imgLanguage = "//img[contains(@src, '/images/%s/flag.svg') and contains(@class, 'MuiBox-root')]";
                                 
    public PaginaPrincipal(){
        super(driver);  // llamamos al constructor padre
    }

    // metodo para navergar a https://brute.eternaltwin.org
    public void navigateToBET(){
        navigateTo("https://brute.eternaltwin.org");
    }

    //Metodo para dar click en cada bandera de lenguaje
    public void clickOnImgLanguage(String section){
        // Reemplaza el marcador de posición en sectionLink con el nombre
        try {
            Thread.sleep(1000); // Espera de 10 segundos (10,000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String xpathSection = String.format(imgLanguage, section);
        clickElement(xpathSection);
        System.out.println(xpathSection);
    }

}
