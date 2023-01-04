package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.AssertData;

import static org.junit.Assert.*;

public class SauceDemoLoginStepDefinition extends BaseTest{
    @Before(order = 0)
    public void openBrowser(){
        driver.manage().window().maximize();
    }
    @Before(order = 1)
    public void goToUrl(){
        String url = "https://www.saucedemo.com/";
        objectModel.goToUrl(url);
    }
    @After
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }
    @When("User input username {string} and password {string}")
    public void userInputUsernameAndPassword(String username, String password) {
        final By user = By.id("user-name");
        final By pass = By.id("password");
        objectModel.inputText(user, username);
        objectModel.inputText(pass, password);

    }
    @And("Click on the login button")
    public void clickOnTheLoginButton() {
        final By login_button = By.id("login-button");
        objectModel.click(login_button);
    }
    @Then("User will be directed to inventory page")
    public void userWillBeDirectedToInventoryPage() {
        assertEquals(AssertData.INVENTORY_URL, objectModel.getUrl());
        String title = objectModel.getText(By.className("title"));
        assertEquals(AssertData.TITLE, title);
    }
}
