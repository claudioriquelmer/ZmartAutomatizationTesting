package automationCraft.testcreation.pages;

import automationCraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static automationCraft.engine.selenium.DriverFactory.getDriver;
import static org.testng.Assert.*;

public class zmartFindProductsPage extends SeleniumBase {
    public zmartFindProductsPage(WebDriver driver) {
        super(driver);
    }

    //Objects
    private By busqueda = By.xpath("//*[@id=\"contenidos\"]/div[2]/div[1]/h2/em");
    private By checkBoxDisponible = By.xpath("//*[@id=\"chkDisp1\"]");
    private By checkBoxCategoria = By.xpath("//*[@id=\"chkVideoJuegos9\"]");
    private By estadoProducto = By.xpath("//*[@id=\"BoxProdDisplay81547\"]/div[3]/span[3]");
    private By cantidadResultados = By.cssSelector(".ProdBox146");

    //Methods
    public void validarZmartFindProductPage () {
        String validador = getTitle();
        if (validador != null) {
            System.out.println(validador);
        }
    }

    public void validarNombreBusqueda () {
        assertEquals("teclado", getText(busqueda));
    }

    public void buscarPorDisponible () {
        if (isDisplayed(checkBoxDisponible)) {
            click(checkBoxDisponible);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void validarBusquedaDisponible () {
        List<WebElement> resultadosDisponible = findElements(cantidadResultados);
        String resultadoEsperado = "Disponible";
        //Recorremos la lista resultados
        for (WebElement resultadoBusqueda : resultadosDisponible) {
            if (resultadoBusqueda.findElement(estadoProducto).getText().equals(resultadoEsperado)) {
                assertTrue(true);
            } else {
                assertFalse(false);
            }
        }
    }

    public void buscarPorPC (String name) {
        if (isDisplayed(checkBoxCategoria)) {
            click(checkBoxCategoria);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void validarBusquedaPC () {
        List<WebElement> resultadosDisponible = findElements(cantidadResultados);
        String resultadoEsperado = "Disponible";
        //Recorremos la lista resultados
        for (WebElement resultadoBusqueda : resultadosDisponible) {
            if (resultadoBusqueda.findElement(estadoProducto).getText().equals(resultadoEsperado)) {
                assertTrue(true);
            } else {
                assertFalse(false);
            }
        }
    }

}
