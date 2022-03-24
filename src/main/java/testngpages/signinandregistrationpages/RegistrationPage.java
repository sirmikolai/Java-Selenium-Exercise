package testngpages.signinandregistrationpages;

import datastructures.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import testngpages.AbstractStorePage;
import testngpages.accountpages.AccountPage;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class RegistrationPage extends AbstractStorePage {

    public static final String ROOT_CSS = "body[id='authentication']";
    private static final String GENDER_RADIO_BUTTON_CSS = ROOT_CSS + " div[id='%s'] > span";
    private static final String FIRST_NAME_PERSONAL_INFORMATION_INPUT_CSS = ROOT_CSS + " input[id='customer_firstname']";
    private static final String LAST_NAME_PERSONAL_INFORMATION_INPUT_CSS = ROOT_CSS + " input[id='customer_lastname']";
    private static final String PASSWORD_INPUT_CSS = ROOT_CSS + " input[id='passwd']";
    private static final String DATE_OF_BIRTH_DAY_SELECT_CSS = ROOT_CSS + " select[name='days']";
    private static final String DATE_OF_BIRTH_MONTH_SELECT_CSS = ROOT_CSS + " select[id='months']";
    private static final String DATE_OF_BIRTH_YEAR_SELECT_CSS = ROOT_CSS + " select[id='years']";
    private static final String FIRST_NAME_ADDRESS_INFORMATION_INPUT_CSS = ROOT_CSS + " input[id='firstname']";
    private static final String LAST_NAME_ADDRESS_INFORMATION_INPUT_CSS = ROOT_CSS + " input[id='lastname']";
    private static final String COMPANY_INPUT_CSS = ROOT_CSS + " input[id='company']";
    private static final String ADDRESS_LINE_1_INPUT_CSS = ROOT_CSS + " input[id='address1']";
    private static final String ADDRESS_LINE_2_INPUT_CSS = ROOT_CSS + " input[id='address2']";
    private static final String CITY_INPUT_CSS = ROOT_CSS + " input[id='city']";
    private static final String COUNTRY_SELECT_CSS = ROOT_CSS + " select[id='id_country']";
    private static final String STATE_SELECT_CSS = ROOT_CSS + " select[id*='id_state']";
    private static final String ZIP_POSTAL_CODE_INPUT_CSS = ROOT_CSS + " input[id='postcode']";
    private static final String MOBILE_PHONE_INPUT_CSS = ROOT_CSS + " input[id='phone_mobile']";
    private static final String ADDRESS_ALIAS_FOR_FUTURE_REFERENCE_CSS = ROOT_CSS + " input[id='alias']";
    private static final String REGISTER_BUTTON_CSS = ROOT_CSS + " button[id='submitAccount']";

    public RegistrationPage(WebDriver driver) {
        super(driver);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ROOT_CSS)));
    }

    public RegistrationPage selectGender(Gender gender) {
        System.out.println("Select gender: " + gender);
        String genderRadioButtonCssPath = String.format(GENDER_RADIO_BUTTON_CSS, gender.getDivIdValue());
        seleniumWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(genderRadioButtonCssPath)));
        driver.findElement(By.cssSelector(genderRadioButtonCssPath)).click();
        seleniumWait.until(ExpectedConditions.attributeToBe(By.cssSelector(genderRadioButtonCssPath), "class", "checked"));
        return this;
    }

    public RegistrationPage inputFirstNameInPersonalInformation(String firstName) {
        System.out.println("Input first name in personal information: " + firstName);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FIRST_NAME_PERSONAL_INFORMATION_INPUT_CSS)));
        WebElement firstNameInput = driver.findElement(By.cssSelector(FIRST_NAME_PERSONAL_INFORMATION_INPUT_CSS));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(firstNameInput, firstName));
        return this;
    }

    public RegistrationPage inputLastNameInPersonalInformation(String lastName) {
        System.out.println("Input last name in personal information: " + lastName);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LAST_NAME_PERSONAL_INFORMATION_INPUT_CSS)));
        WebElement lastNameInput = driver.findElement(By.cssSelector(LAST_NAME_PERSONAL_INFORMATION_INPUT_CSS));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(lastNameInput, lastName));
        return this;
    }

    public RegistrationPage inputPassword(String password) {
        System.out.println("Input password: " + password);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PASSWORD_INPUT_CSS)));
        WebElement passwordInput = driver.findElement(By.cssSelector(PASSWORD_INPUT_CSS));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage selectDateOfBirth(LocalDate localDate) {
        System.out.println("Select date of birth: " + localDate);
        selectDayInDateOfBirth(localDate.getDayOfMonth());
        selectMonthInDateOfBirth(localDate.getMonth());
        selectYearInDateOfBirth(localDate.getYear());
        return this;
    }

    private void selectDayInDateOfBirth(int dayOfMonth) {
        System.out.println("Select day of month: " + dayOfMonth);
        scrollIntoView(driver.findElement(By.cssSelector(DATE_OF_BIRTH_DAY_SELECT_CSS)));
        Select daySelect = new Select(driver.findElement(By.cssSelector(DATE_OF_BIRTH_DAY_SELECT_CSS)));
        daySelect.selectByValue(String.valueOf(dayOfMonth));
    }

    private void selectMonthInDateOfBirth(Month month) {
        System.out.println("Select month: " + month.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        scrollIntoView(driver.findElement(By.cssSelector(DATE_OF_BIRTH_MONTH_SELECT_CSS)));
        Select monthSelect = new Select(driver.findElement(By.cssSelector(DATE_OF_BIRTH_MONTH_SELECT_CSS)));
        monthSelect.selectByValue(String.valueOf(month.getValue()));
    }

    private void selectYearInDateOfBirth(int year) {
        System.out.println("Select year: " + year);
        scrollIntoView(driver.findElement(By.cssSelector(DATE_OF_BIRTH_YEAR_SELECT_CSS)));
        Select yearSelect = new Select(driver.findElement(By.cssSelector(DATE_OF_BIRTH_YEAR_SELECT_CSS)));
        yearSelect.selectByValue(String.valueOf(year));
    }

    public RegistrationPage inputFirstNameInAddressInformation(String firstName) {
        System.out.println("Input first name in address information: " + firstName);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FIRST_NAME_ADDRESS_INFORMATION_INPUT_CSS)));
        WebElement firstNameInput = driver.findElement(By.cssSelector(FIRST_NAME_ADDRESS_INFORMATION_INPUT_CSS));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(firstNameInput, firstName));
        return this;
    }

    public RegistrationPage inputLastNameInAddressInformation(String lastName) {
        System.out.println("Input last name in address information: " + lastName);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LAST_NAME_ADDRESS_INFORMATION_INPUT_CSS)));
        WebElement lastNameInput = driver.findElement(By.cssSelector(LAST_NAME_ADDRESS_INFORMATION_INPUT_CSS));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(lastNameInput, lastName));
        return this;
    }

    public RegistrationPage inputCompanyName(String companyName) {
        System.out.println("Input company name: " + companyName);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(COMPANY_INPUT_CSS)));
        WebElement companyNameInput = driver.findElement(By.cssSelector(COMPANY_INPUT_CSS));
        companyNameInput.clear();
        companyNameInput.sendKeys(companyName);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(companyNameInput, companyName));
        return this;
    }

    public RegistrationPage inputCityName(String cityName) {
        System.out.println("Input city name: " + cityName);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CITY_INPUT_CSS)));
        WebElement cityNameInput = driver.findElement(By.cssSelector(CITY_INPUT_CSS));
        cityNameInput.clear();
        cityNameInput.sendKeys(cityName);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(cityNameInput, cityName));
        return this;
    }

    public RegistrationPage selectCountry(String countryName) {
        System.out.println("Select country: " + countryName);
        scrollIntoView(driver.findElement(By.cssSelector(COUNTRY_SELECT_CSS)));
        Select countrySelect = new Select(driver.findElement(By.cssSelector(COUNTRY_SELECT_CSS)));
        countrySelect.selectByVisibleText(countryName);
        return this;
    }

    public RegistrationPage selectState(String stateName) {
        System.out.println("Select state: " + stateName);
        scrollIntoView(driver.findElement(By.cssSelector(STATE_SELECT_CSS)));
        Select stateSelect = new Select(driver.findElement(By.cssSelector(STATE_SELECT_CSS)));
        stateSelect.selectByVisibleText(stateName);
        return this;
    }

    public RegistrationPage inputAddressLine1(String addressLine) {
        System.out.println("Input address line 1: " + addressLine);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ADDRESS_LINE_1_INPUT_CSS)));
        WebElement addressLineInput = driver.findElement(By.cssSelector(ADDRESS_LINE_1_INPUT_CSS));
        addressLineInput.clear();
        addressLineInput.sendKeys(addressLine);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(addressLineInput, addressLine));
        return this;
    }

    public RegistrationPage inputAddressLine2(String addressLine) {
        System.out.println("Input address line 2: " + addressLine);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ADDRESS_LINE_2_INPUT_CSS)));
        WebElement addressLineInput = driver.findElement(By.cssSelector(ADDRESS_LINE_2_INPUT_CSS));
        addressLineInput.clear();
        addressLineInput.sendKeys(addressLine);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(addressLineInput, addressLine));
        return this;
    }

    public RegistrationPage inputZipPostalCode(String zipPostalCode) {
        System.out.println("Input Zip/Postal code: " + zipPostalCode);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ZIP_POSTAL_CODE_INPUT_CSS)));
        WebElement zipPostalCodeInput = driver.findElement(By.cssSelector(ZIP_POSTAL_CODE_INPUT_CSS));
        zipPostalCodeInput.clear();
        zipPostalCodeInput.sendKeys(zipPostalCode);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(zipPostalCodeInput, zipPostalCode));
        return this;
    }

    public RegistrationPage inputMobilePhone(String mobilePhone) {
        System.out.println("Input Mobile Phone: " + mobilePhone);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MOBILE_PHONE_INPUT_CSS)));
        WebElement mobilePhoneInput = driver.findElement(By.cssSelector(MOBILE_PHONE_INPUT_CSS));
        mobilePhoneInput.clear();
        mobilePhoneInput.sendKeys(mobilePhone);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(mobilePhoneInput, mobilePhone));
        return this;
    }

    public RegistrationPage inputAddressAliasForFutureReference(String addressAliasForFutureReference) {
        System.out.println("Input address alias for future reference: " + addressAliasForFutureReference);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ADDRESS_ALIAS_FOR_FUTURE_REFERENCE_CSS)));
        WebElement addressAliasInput = driver.findElement(By.cssSelector(ADDRESS_ALIAS_FOR_FUTURE_REFERENCE_CSS));
        addressAliasInput.clear();
        addressAliasInput.sendKeys(addressAliasForFutureReference);
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(addressAliasInput, addressAliasForFutureReference));
        return this;
    }

    public AccountPage clickRegister() {
        System.out.println("Click 'Register'");
        seleniumWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(REGISTER_BUTTON_CSS)));
        driver.findElement(By.cssSelector(REGISTER_BUTTON_CSS)).click();
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(AccountPage.ROOT_CSS)));
        return new AccountPage(driver);
    }
}
