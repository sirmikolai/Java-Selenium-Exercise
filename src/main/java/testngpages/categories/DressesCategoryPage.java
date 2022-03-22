package testngpages.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DressesCategoryPage extends AbstractCategoryPage {
    public static final String ROOT_CSS = "body[class*='category-dresses']";

    public DressesCategoryPage(WebDriver driver) {
        super(driver);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ROOT_CSS)));
    }
}
