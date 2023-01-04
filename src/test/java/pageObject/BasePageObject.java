package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BasePageObject {
    WebDriver driver;

    public BasePageObject(WebDriver driver){
        this.driver = driver;
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public void goToUrl(String url){
        driver.navigate().to(url);
    }

    public WebElement find(By by){
        return driver.findElement(by);
    }
    public List<WebElement> finds(By by){
        return driver.findElements(by);
    }
    public String getTextWebElement(WebElement element){
        return element.getText();
    }
    public String getText(By by){
        return find(by).getText();
    }
    public void inputText(By by, String text){
        find(by).sendKeys(text);
    }
    public void click(By by){
        find(by).click();
    }
    public boolean isDisplayed(By by){
        return find(by).isDisplayed();
    }
}
