package test.tests.cucumber;

import main.framework.ParentFunctionWeb;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import test.tests.pageObjects.WebLoginPage;
import java.util.List;

public class WebLoginStepDefinitions extends ParentFunctionWeb {

    private WebLoginPage webLoginPage = null;
    private List<String> smsCodes;

    @Before
    public void beforeScenario() throws Exception {
        openBrowser("http://www.garanti.com.tr/");
        webLoginPage = new WebLoginPage(driver);
    }
    @After
    public void afterScenario() {
        quitBrowser();
    }
    @Given("^I am on the www.garanti.com.tr Home Page$")
    public void iAmOnGarantiBankHomePage() {
    }

    @When("^I click Login Link on Home Page$")
    public void iClickLoginLinkOnHomePage()  {
        webLoginPage.clickLoginLink();
    }

    @And("^Fill UserID field with \"([^\"]*)\" and Fill Password field with \"([^\"]*)\" and click Login on LoginPage$")
    public void fillUserIDFieldWithAndFillPasswordFieldWithAndClickLoginOnLoginPage(String id, String password) throws Throwable  {
        webLoginPage.FillinCredentialsAndClickLogin(id,password);
    }

    @And("^I click SMS Code and write \"([^\"]*)\" on Login Page$")
    public void iClickSMSCodeAndWriteOnLoginPage(String smsCode) throws Throwable {
        webLoginPage.FillinSmsCode(smsCode);
    }

    @Then("^I should see url contains \"([^\"]*)\"$")
    public void iShouldSeeUrlCantains(String keyword) throws Throwable {
        webLoginPage.checkForUrlContains(keyword);
    }

    @And("^I click SMS Code and write smscode on Login Page$")
    public void iClickSMSCodeAndWriteSmscodeOnLoginPage(DataTable smsCode) throws Throwable {

        List<List<String>> data = smsCode.raw();
        //This is to get the first data of the set (First Row + First Column)
        driver.findElement(By.id("code")).sendKeys(data.get(0).get(0));
        //This is to get the first data of the set (Second Row + First Column)
        driver.findElement(By.id("code")).sendKeys(data.get(1).get(0));

    }

    @And("^Fill UserID field with \"([^\"]*)\" and Fill Password field with \"([^\"]*)\" from list and click Login on LoginPage$")
    public void fillUserIDFieldWithUseridAndFillPasswordFieldWithPasswordFromListAndClickLoginOnLoginPage(String userid, String password, DataTable table) throws Throwable {
       webLoginPage.FillinCredentialsAndClickLogin(userid,password);

        //List<List<String>> data = table.raw();
        //webLoginPage.FillinCredentialsAndClickLogin(data.get(0).get(0),data.get(0).get(1));
    }

    @Then("^I should not see url contains \"([^\"]*)\"$")
    public void iShouldNotSeeUrlCantains(String keyword) throws Throwable {
        webLoginPage.checkForUrlNotContains(keyword);
    }

}
