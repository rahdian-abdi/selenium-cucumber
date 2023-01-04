package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.BasePageObject;

public class BaseTest {
    WebDriver driver = new ChromeDriver();
    BasePageObject objectModel = new BasePageObject(driver);
}
