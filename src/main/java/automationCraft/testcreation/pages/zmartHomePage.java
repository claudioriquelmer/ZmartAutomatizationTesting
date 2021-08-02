package automationCraft.testcreation.pages;

import automationCraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

public class zmartHomePage extends SeleniumBase {

    public zmartHomePage(WebDriver driver) {
        super(driver);
    }

    //Objects
    private By inputFindProducts = By.xpath("//*[@id=\"strSearch\"]");
    private By searchProducts = By.xpath("//*[@id=\"searchBox\"]/input[2]");
    private By totalProducts = By.cssSelector(".BoxProductoS2188");

    //Method
    public void validarZmartHomePage () {
        goToUrl("https://www.zmart.cl");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String validador = getTitle();

        if (validador != null) {
            System.out.println(validador);
        }
    }

    public void validarProductosHome () {
        if (isDisplayed(inputFindProducts)) {
            findElements(totalProducts).size();
        } else {
            assertTrue(isDisplayed(totalProducts), "No se encontraron elementos " + findElements(totalProducts).size());
        }
    }

    public void realizarBusqueda (String nombre) {
        if (isDisplayed(inputFindProducts)) {
            click(inputFindProducts);
            type(nombre, inputFindProducts);
            click(searchProducts);
        } else {
            assertTrue(isDisplayed(inputFindProducts), "No se encontró el elemento" + inputFindProducts.toString());
        }
    }
}
