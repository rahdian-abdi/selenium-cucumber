package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SauceDemoAddToCartStepDefinition extends BaseTest{
    @Before(order = 0, value = "@addToCart")
    public void openBrowser(){
        driver.manage().window().maximize();
    }
    @Before(order = 1, value = "@addToCart")
    public void goToUrl(){
        String url = "https://www.saucedemo.com/";
        objectModel.goToUrl(url);
    }
    @Before(order = 2, value = "@addToCart")
    public void userLogin(){
        final By user = By.id("user-name");
        final By pass = By.id("password");
        final By login_button = By.id("login-button");
        objectModel.inputText(user, "standard_user");
        objectModel.inputText(pass, "secret_sauce");
        objectModel.click(login_button);
    }
    @After(value = "@addToCart")
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }
    @When("I add an item to cart")
    public void iAddAnItemToCart() {
        final By addItem = By.id("add-to-cart-sauce-labs-backpack");
        objectModel.click(addItem);
    }
    @Then("I will see the cart badge number")
    public void iWillSeeTheCartBadgeNumber() {
        final By cartBadge = By.className("shopping_cart_badge");
        objectModel.isDisplayed(cartBadge);
    }
    @And("I will see the item added is available in cart page")
    public void iWillSeeTheItemAddedIsAvailableInCartPage() {
        final By cartButton = By.className("shopping_cart_link");
        objectModel.click(cartButton);

        final By cartBadge = By.className("shopping_cart_badge");
        int numberProduct = Integer.parseInt(objectModel.getText(cartBadge));

        final By listCartItem = By.className("inventory_item_name");
        List<WebElement> elements = objectModel.finds(listCartItem);
        List<String> cartItem = new ArrayList<>();
        for (WebElement element : elements){
            cartItem.add(objectModel.getTextWebElement(element));
        }
        int cartItemSize = cartItem.size();

        assertEquals(numberProduct, cartItemSize);

    }
}
