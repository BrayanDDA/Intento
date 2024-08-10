package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class pagoPage extends util {
    @FindBy(id = "card_nmuber") protected WebElement txtTarjeta;
    @FindBy(id = "month") protected WebElement cmbMes;
    @FindBy(id = "year") protected WebElement cmbAnio;
    @FindBy(id = "cvv_code") protected WebElement txtCvv;
    @FindBy(name = "submit") protected WebElement btnPagar;


    public pagoPage() {
        PageFactory.initElements(driver,this);
    }

    public void escribirNroTrajeta(String texto){
        wait.until(ExpectedConditions.visibilityOf(txtTarjeta));
        txtTarjeta.sendKeys(texto);
    }

    public void seleccionarMes(String mes){
        new Select(cmbMes).selectByVisibleText(mes);
    }

    public void seleccionarAnio(String anio){
        new Select(cmbAnio).selectByVisibleText(anio);
    }

    public void escribirNroCvv(String texto){
        txtCvv.sendKeys(texto);
    }

    public void clickPagar(){
        btnPagar.click();
    }
}
