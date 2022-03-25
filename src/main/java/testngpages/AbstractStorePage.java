package testngpages;

import datastructures.Category;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testngpages.signinandregistrationpages.SignInPage;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

public abstract class AbstractStorePage extends Page {

    private static final Logger logger = Logger.getLogger(AbstractStorePage.class);

    private static final String SIGN_IN_BUTTON_CSS = "a[class='login']";
    private static final String CATEGORY_BUTTON_XPATH = "//ul[li/a[@title='%s']]";
    private static final String CATEGORY_BUTTON_CSS= "a[title='%s']";

    public AbstractStorePage(WebDriver driver) {
        super(driver);
    }

    public SignInPage clickSignInButton() {
        logger.info("Click 'Sign in' button");
        scrollIntoView(driver.findElement(By.cssSelector(SIGN_IN_BUTTON_CSS)));
        seleniumWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SIGN_IN_BUTTON_CSS)));
        driver.findElement(By.cssSelector(SIGN_IN_BUTTON_CSS)).click();
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SignInPage.ROOT_CSS)));
        return new SignInPage(driver);
    }

    public <T extends Page> T clickCategory(Category category, Class<T> clazz) {
        logger.info("Click category: " + category.getName());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        scrollIntoView(driver.findElement(By.xpath(String.format(CATEGORY_BUTTON_XPATH, category.getName()))));
        String categoryCss = String.format(CATEGORY_BUTTON_CSS, category.getName());
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(CATEGORY_BUTTON_XPATH, category.getName()))));
        WebElement element = driver.findElement(By.cssSelector(categoryCss));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
        T page = null;
        try {
            page = clazz.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return page;
    }
}
