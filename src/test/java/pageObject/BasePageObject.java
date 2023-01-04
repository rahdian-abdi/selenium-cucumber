package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public String getText(By by){
        return find(by).getText();
    }
    public void inputText(By by, String text){
        find(by).sendKeys(text);
    }
    public void click(By by){
        find(by).click();
    }
}
