package testngpages.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testngpages.Page;
import testngpages.quickviewmodal.QuickViewModal;

public abstract class AbstractCategoryPage extends Page {

    private static final String PRODUCT_NAME_XPATH = "//div[@class='product-container']" +
            "[div[@class='right-block']//a[contains(text(),'%s')]]";
    private static final String OPEN_QUICK_VIEW_MODAL_FOR_PRODUCT_NAME_XPATH = PRODUCT_NAME_XPATH + "//a[@class='quick-view']";

    public AbstractCategoryPage(WebDriver driver) {
        super(driver);
    }

    public QuickViewModal openQuickViewModalForProduct(String productName) {
        System.out.println("Open Quick View modal for product: " + productName);
        scrollIntoView(driver.findElement(By.xpath(String.format(PRODUCT_NAME_XPATH, productName))));
        String quickViewModalXpath = String.format(OPEN_QUICK_VIEW_MODAL_FOR_PRODUCT_NAME_XPATH, productName);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quickViewModalXpath)));
        driver.findElement(By.xpath(quickViewModalXpath)).click();
        return new QuickViewModal(driver, this);
    }
}
