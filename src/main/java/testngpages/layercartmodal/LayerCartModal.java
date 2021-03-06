package testngpages.layercartmodal;

import datastructures.Color;
import datastructures.SizeBody;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testngpages.Page;
import testngpages.categories.WomenCategoryPage;

public class LayerCartModal extends Page {

    private static final Logger logger = Logger.getLogger(LayerCartModal.class);

    public static final String ROOT_CSS = "div[id='layer_cart']";
    private static final String MESSAGE_ABOUT_ADDED_PRODUCT_CSS = ROOT_CSS + " div[class*='layer_cart_product'] h2";
    private static final String PRODUCT_NAME_CSS = ROOT_CSS + " span[id='layer_cart_product_title']";
    private static final String PRODUCT_ATTRIBUTES_CSS = ROOT_CSS + " span[id='layer_cart_product_attributes']";
    private static final String CONTINUE_SHOPPING_CSS = ROOT_CSS + " span[title*='Continue shopping']";

    private Page parentPage;

    public LayerCartModal(WebDriver driver, Page parentPage) {
        super(driver);
        this.parentPage = parentPage;
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ROOT_CSS)));
    }

    public String getInformationAboutAddingProduct() {
        logger.info("Get message about added product");
        scrollIntoView(driver.findElement(By.cssSelector(MESSAGE_ABOUT_ADDED_PRODUCT_CSS)));
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MESSAGE_ABOUT_ADDED_PRODUCT_CSS)));
        return driver.findElement(By.cssSelector(MESSAGE_ABOUT_ADDED_PRODUCT_CSS)).getText();
    }

    public String getProductName() {
        logger.info("Get product name");
        scrollIntoView(driver.findElement(By.cssSelector(PRODUCT_NAME_CSS)));
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PRODUCT_NAME_CSS)));
        return driver.findElement(By.cssSelector(PRODUCT_NAME_CSS)).getText();
    }

    public Color getColorOfProduct() {
        logger.info("Get color of product");
        scrollIntoView(driver.findElement(By.cssSelector(PRODUCT_ATTRIBUTES_CSS)));
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PRODUCT_ATTRIBUTES_CSS)));
        String colorName = driver.findElement(By.cssSelector(PRODUCT_ATTRIBUTES_CSS)).getText().replaceFirst(",[^,]*$", "");
        for (Color color : Color.values()) {
            if (color.getName().equalsIgnoreCase(colorName)) {
                return color;
            }
        }
        return null;
    }

    public SizeBody getSizeOfProduct() {
        logger.info("Get size of product");
        scrollIntoView(driver.findElement(By.cssSelector(PRODUCT_ATTRIBUTES_CSS)));
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PRODUCT_ATTRIBUTES_CSS)));
        String sizeBodyName = driver.findElement(By.cssSelector(PRODUCT_ATTRIBUTES_CSS)).getText().replaceFirst("^(.+?), ", "");
        for (SizeBody sizeBody : SizeBody.values()) {
            if (sizeBody.getName().equalsIgnoreCase(sizeBodyName)) {
                return sizeBody;
            }
        }
        return null;
    }

    public Page clickContinueShopping() {
        logger.info("Click 'Continue shopping'");
        scrollIntoView(driver.findElement(By.cssSelector(CONTINUE_SHOPPING_CSS)));
        seleniumWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CONTINUE_SHOPPING_CSS)));
        driver.findElement(By.cssSelector(CONTINUE_SHOPPING_CSS)).click();
        return parentPage;
    }
}
