package automationCraft.testcreation.steps;

import automationCraft.engine.selenium.DriverFactory;
import automationCraft.testcreation.pages.zmartFindProductsPage;
import automationCraft.testcreation.pages.zmartHomePage;
import io.cucumber.java.en.*;


public class zmartSteps {

    protected zmartHomePage zmartHome;
    protected zmartFindProductsPage zmartProducts;

    @Given("el usuario se encuentra en la pagina de inicio")
    public void el_usuario_se_encuentra_en_la_pagina_de_inicio() {
        zmartHome = new zmartHomePage(DriverFactory.getDriver());
        zmartHome.validarZmartHomePage();
    }

    @Given("existen productos registrados")
    public void existen_productos_registrados() {
        zmartHome.validarProductosHome();
    }

    @When("se realiza una busqueda de producto por nombre {string}")
    public void se_realiza_una_busqueda_de_producto_por_nombre(String string) {
        zmartHome.realizarBusqueda("teclado");
    }

    @Then("se deben mostrar todos los productos por nombre {string}")
    public void se_deben_mostrar_todos_los_productos_por_nombre(String string) {
        zmartProducts = new zmartFindProductsPage(DriverFactory.getDriver());
        zmartProducts.validarZmartFindProductPage();
        zmartProducts.validarNombreBusqueda();
    }

    @Given("existen varios productos registrados")
    public void existen_varios_productos_registrados() {
        zmartHome = new zmartHomePage(DriverFactory.getDriver());
        zmartHome.validarProductosHome();
    }

    @When("se realiza la busqueda filtrando por {string}")
    public void se_realiza_la_busqueda_filtrando_por(String string) {
        zmartProducts = new zmartFindProductsPage(DriverFactory.getDriver());
        zmartHome.realizarBusqueda("teclado");
        zmartProducts.buscarPorDisponible();
    }

    @Then("se deben mostrar solo los productos segun el filtro indicado.")
    public void se_deben_mostrar_solo_los_productos_segun_el_filtro_indicado() {
        zmartProducts.validarBusquedaDisponible();
    }

    @Given("existen varios productos por tipo registrados.")
    public void existen_varios_productos_por_tipo_registrados() {
        zmartHome = new zmartHomePage(DriverFactory.getDriver());
        zmartHome.validarProductosHome();
    }

    @When("se realiza la busqueda filtrando por tipo {string}")
    public void se_realiza_la_busqueda_filtrando_por_tipo(String string) {
        zmartProducts = new zmartFindProductsPage(DriverFactory.getDriver());
        zmartProducts.validarZmartFindProductPage();
        zmartProducts.buscarPorPC("PC");
    }

    @Then("se deben mostrar solo los productos según el filtro de tipo indicado")
    public void se_deben_mostrar_solo_los_productos_según_el_filtro_de_tipo_indicado() {
        zmartProducts.validarBusquedaPC();
    }
}
