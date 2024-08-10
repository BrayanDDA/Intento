package pageobjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

import java.util.concurrent.TimeUnit;

public class tarjetaPage extends util {
    public static String nro_tarjeta;
    public static String cvv;
    public static String mes;
    public static String anio;
    @FindBy(xpath = "//*[contains(text(),'Card Number:')]") protected WebElement lblnroTarjeta;
    @FindBy(xpath = "//*[contains(text(),'CVV:')]") protected WebElement lblcvvTarjeta;
    @FindBy(xpath = "//*[contains(text(),'Exp:')]") protected WebElement lblexpTarjeta;
    private String wqeqwe;
    public tarjetaPage() {
        PageFactory.initElements(driver,this);
    }
    public void obtenerNroTarjeta() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(lblnroTarjeta));
        TimeUnit.SECONDS.sleep(5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lblnroTarjeta);
        String texto= lblnroTarjeta.getText();
        nro_tarjeta= texto.replace("Card Number:- ","");
        System.out.println(nro_tarjeta);
    }

    public  void obtenerCVV(){
        wait.until(ExpectedConditions.visibilityOf(lblcvvTarjeta));
        String texto= lblcvvTarjeta.getText();
        cvv= texto.replace("CVV:- ","");
        System.out.println(cvv);
    }

    public  void obtenerFecha() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(lblexpTarjeta));
        String texto= lblexpTarjeta.getText();
        String[] fecha = texto.replace("Exp:- ","").split("/");
        mes = fecha[0];
        anio= fecha[1];
        System.out.println(mes);
        System.out.println(anio);
    }

}
