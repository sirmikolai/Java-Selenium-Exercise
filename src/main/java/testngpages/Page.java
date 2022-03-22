package testngpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

    public static final String STORE_URL = "http://automationpractice.com/index.php";
    public WebDriver driver;
    public WebDriverWait seleniumWait;
    private Actions actions;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.seleniumWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        this.actions = new Actions(driver);
    }

    protected void scrollIntoView(WebElement element) {
        actions.moveToElement(element).perform();
    }
}
