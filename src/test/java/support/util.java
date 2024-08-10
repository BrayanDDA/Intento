package support;

import definitions.hooks;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.text.SimpleDateFormat;

public class util extends hooks {
    public static WebDriverWait wait;
    public static Alert dialogo;

    public util() {
        wait=new WebDriverWait(driver,30);
    }
    public void ventanActiva(){
        Set<String> identificadores = driver.getWindowHandles();
        for (String identificador:identificadores){
            driver.switchTo().window(identificador);
        }
    }

    public void ventanaInicial(){
        driver.close();
        driver.switchTo().window("");
    }

    public void aceptarDialogo(){
        dialogo = driver.switchTo().alert();
        dialogo.accept();
    }
    public void obtenerTextoDialogo(String mensaje){
        dialogo = driver.switchTo().alert();
        Assert.assertEquals(mensaje, dialogo.getText());
    }

    public static void evidencias() throws IOException {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmssSSS");
        String path="D:\\Documentos\\CAPACITACIÓN\\Trabajo\\evidencias\\";
        String nombre = formato.format(fecha)+"evidencias.jpg";
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(path+nombre));
    }

}
