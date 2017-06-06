package main.framework;


import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.MalformedURLException;

public class ParentFunctionWeb {

    public static WebDriver driver;
    public static void openBrowser(String url) throws MalformedURLException {

        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }

    protected static void quitBrowser() {

        for (String winHandle : driver.getWindowHandles()) {
            try {
                driver.switchTo().window(winHandle);
                driver.close();
                driver.quit();
            } catch (Exception e) {
            }
        }
    }





}

