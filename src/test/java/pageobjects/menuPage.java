package pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class menuPage extends util {
    @FindBy(linkText = "Generate Card Number") protected WebElement lnkGenerarTarjeta;
    @FindBy(css = "#nav > a:nth-child(2)") protected WebElement lnkGenerarTarjeta2;
    @FindBy(xpath = "//nav/a[@href='cardnumber.php']") protected WebElement getLnkGenerarTarjeta3;

    public menuPage() {
        PageFactory.initElements(driver,this);
    }

    public void clickGenerarTarjeta(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkGenerarTarjeta));
        lnkGenerarTarjeta.click();
    }
}
