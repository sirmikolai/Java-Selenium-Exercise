package testngpages.signinandregistrationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testngpages.AbstractStorePage;
import testngpages.accountpages.AccountPage;

public class SignInPage extends AbstractStorePage {

    public static final String ROOT_CSS = "body[id='authentication']";
    private static final String EMAIL_ADDRESS_FOR_LOGIN_INPUT_CSS = ROOT_CSS + " input[id='email']";
    private static final String PASSWORD_FOR_LOGIN_INPUT_CSS = ROOT_CSS + " input[id='passwd']";
    private static final String SIGN_IN_BUTTON_CSS = ROOT_CSS + " button[id='SubmitLogin']";
    private static final String EMAIL_ADDRESS_FOR_REGISTRATION_INPUT_CSS = ROOT_CSS + " input[id='email_create']";
    private static final String CREATE_AN_ACCOUNT_BUTTON_CSS = ROOT_CSS + " button[id='SubmitCreate']";

    public SignInPage(WebDriver driver) {
        super(driver);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ROOT_CSS)));
    }

    public SignInPage inputEmailAddressForLogin(String emailAddress) {
        System.out.println("Input email address for login: " + emailAddress);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(EMAIL_ADDRESS_FOR_LOGIN_INPUT_CSS)));
        WebElement emailAddressForLoginInputElement = driver.findElement(By.cssSelector(EMAIL_ADDRESS_FOR_LOGIN_INPUT_CSS));
        emailAddressForLoginInputElement.clear();
        emailAddressForLoginInputElement.sendKeys(emailAddress);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(emailAddressForLoginInputElement, emailAddress));
        return this;
    }

    public SignInPage inputPasswordForLogin(String password) {
        System.out.println("Input password for login");
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PASSWORD_FOR_LOGIN_INPUT_CSS)));
        WebElement passwordForLoginInputElement = driver.findElement(By.cssSelector(PASSWORD_FOR_LOGIN_INPUT_CSS));
        passwordForLoginInputElement.clear();
        passwordForLoginInputElement.sendKeys(password);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(passwordForLoginInputElement, password));
        return this;
    }

    public AccountPage clickSignIn() {
        System.out.println("Click 'Sign in'");
        seleniumWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SIGN_IN_BUTTON_CSS)));
        driver.findElement(By.cssSelector(SIGN_IN_BUTTON_CSS)).click();
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(AccountPage.ROOT_CSS)));
        return new AccountPage(driver);
    }

    public SignInPage inputEmailAddressForRegistration(String emailAddress) {
        System.out.println("Input email address for registration: " + emailAddress);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(EMAIL_ADDRESS_FOR_REGISTRATION_INPUT_CSS)));
        WebElement emailAddressForRegistrationInputElement = driver.findElement(By.cssSelector(EMAIL_ADDRESS_FOR_REGISTRATION_INPUT_CSS));
        emailAddressForRegistrationInputElement.clear();
        emailAddressForRegistrationInputElement.sendKeys(emailAddress);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(emailAddressForRegistrationInputElement, emailAddress));
        return this;
    }

    public RegistrationPage clickCreateAnAccount() {
        System.out.println("Click 'Create an account'");
        seleniumWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CREATE_AN_ACCOUNT_BUTTON_CSS)));
        driver.findElement(By.cssSelector(CREATE_AN_ACCOUNT_BUTTON_CSS)).click();
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(RegistrationPage.ROOT_CSS)));
        return new RegistrationPage(driver);
    }
}
