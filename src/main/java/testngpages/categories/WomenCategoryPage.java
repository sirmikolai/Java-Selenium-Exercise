package testngpages.categories;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WomenCategoryPage extends AbstractCategoryPage {

    private static final Logger logger = Logger.getLogger(WomenCategoryPage.class);

    public static final String ROOT_CSS = "body[class*='category-women']";

    public WomenCategoryPage(WebDriver driver) {
        super(driver);
        seleniumWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ROOT_CSS)));
    }

}
