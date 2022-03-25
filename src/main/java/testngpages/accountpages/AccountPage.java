package testngpages.accountpages;

import exercise1.Operation;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testngpages.AbstractStorePage;

public class AccountPage extends AbstractStorePage {

    private static final Logger logger = Logger.getLogger(AccountPage.class);

    public static final String ROOT_CSS = "body[id='my-account']";
    private static final String WELCOME_TEXT_CSS = ROOT_CSS + " p[class='info-account']";
    private static final String USER_NAME_IN_HEADER = ROOT_CSS + " div[class='header_user_info'] > a > span";

    public AccountPage(WebDriver driver) {
        super(driver);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ROOT_CSS)));
    }

    public String getWelcomeText() {
        logger.info("Get welcome text");
        scrollIntoView(driver.findElement(By.cssSelector(WELCOME_TEXT_CSS)));
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(WELCOME_TEXT_CSS)));
        return driver.findElement(By.cssSelector(WELCOME_TEXT_CSS)).getText();
    }

    public String getUserNameFromHeader() {
        logger.info("Get user name from header");
        scrollIntoView(driver.findElement(By.cssSelector(USER_NAME_IN_HEADER)));
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(USER_NAME_IN_HEADER)));
        return driver.findElement(By.cssSelector(USER_NAME_IN_HEADER)).getText();
    }
}
