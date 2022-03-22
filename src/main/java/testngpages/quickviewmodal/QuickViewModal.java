package testngpages.quickviewmodal;

import datastructures.Color;
import datastructures.SizeBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import testngpages.Page;
import testngpages.layercartmodal.LayerCartModal;

public class QuickViewModal extends Page {

    private static final String IFRAME_CSS = "iframe[class='fancybox-iframe']";
    private static final String ROOT_CSS = "body[id='product']";
    private static final String QUANTITY_INPUT_CSS = ROOT_CSS + " input[id='quantity_wanted']";
    private static final String SIZE_SELECT_CSS = ROOT_CSS + " select[name='group_1']";
    private static final String COLOR_SELECT_CSS = ROOT_CSS + " a[name='%s']";
    private static final String ADD_TO_CART_BUTTON = ROOT_CSS + " button[type='submit']";

    private Page parentPage;

    public QuickViewModal(WebDriver driver, Page parentPage) {
        super(driver);
        this.parentPage = parentPage;
        driver.switchTo().frame(driver.findElement(By.cssSelector(IFRAME_CSS)));
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ROOT_CSS)));
    }

    public QuickViewModal inputQuantity(int quantity) {
        System.out.println("Input quantity: " + quantity);
        scrollIntoView(driver.findElement(By.cssSelector(QUANTITY_INPUT_CSS)));
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(QUANTITY_INPUT_CSS)));
        WebElement quantityInput = driver.findElement(By.cssSelector(QUANTITY_INPUT_CSS));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
        seleniumWait.until(ExpectedConditions.textToBePresentInElementValue(quantityInput, String.valueOf(quantity)));
        return this;
    }

    public QuickViewModal selectSize(SizeBody sizeBody) {
        System.out.println("Select size: " + sizeBody.getName());
        scrollIntoView(driver.findElement(By.cssSelector(SIZE_SELECT_CSS)));
        Select countrySelect = new Select(driver.findElement(By.cssSelector(SIZE_SELECT_CSS)));
        countrySelect.selectByVisibleText(sizeBody.getName());
        return this;
    }

    public QuickViewModal selectColor(Color color) {
        System.out.println("Select size: " + color.getName());
        String colorSelectCssPath = String.format(COLOR_SELECT_CSS, color.getName());
        scrollIntoView(driver.findElement(By.cssSelector(colorSelectCssPath)));
        driver.findElement(By.cssSelector(colorSelectCssPath)).click();
        return this;
    }

    public LayerCartModal clickAddToCartButton() {
        System.out.println("Click 'Add to cart' button");
        scrollIntoView(driver.findElement(By.cssSelector(ADD_TO_CART_BUTTON)));
        seleniumWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ADD_TO_CART_BUTTON)));
        driver.findElement(By.cssSelector(ADD_TO_CART_BUTTON)).click();
        driver.switchTo().defaultContent();
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LayerCartModal.ROOT_CSS)));
        return new LayerCartModal(driver, parentPage);
    }
}
