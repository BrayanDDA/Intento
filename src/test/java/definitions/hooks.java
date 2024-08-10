package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class hooks {
    public static WebDriver driver;
    @Before
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        //System.setProperty("webdriver.edge.driver","src/test/resources/drivers/msedgedriver.exe");
        //driver = new EdgeDriver();

        driver.manage().window().maximize();
    }

    @After
    public static void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
