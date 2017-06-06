package test.tests.pageObjects;

import main.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WebLoginPage extends ParentPage {

    public WebLoginPage(WebDriver driver) {
        super(driver);
    }

    public WebLoginPage clickLoginLink() {
       driver.findElement(By.id("login")).click();
        return this;
    }

    public WebLoginPage FillinCredentialsAndClickLogin(String id, String password) throws Exception {
        driver.findElement(By.id("username")).sendKeys(id);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
        return this;
    }

    public WebLoginPage FillinSmsCode(String smsCode) throws Exception {

        driver.findElement(By.id("code")).sendKeys(smsCode);

        return this;
    }

    public WebLoginPage checkForUrlContains(String keyword) throws Exception {

        Thread.sleep(6000);
        Assert.assertTrue(driver.getCurrentUrl().contains(keyword));
        return this;
    }

    public WebLoginPage checkForUrlNotContains(String keyword) throws Exception {

        Thread.sleep(6000);
        Assert.assertFalse(driver.getCurrentUrl().contains(keyword));
        return this;
    }


}
