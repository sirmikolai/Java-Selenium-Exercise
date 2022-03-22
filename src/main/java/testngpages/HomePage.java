package testngpages;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractStorePage {

    public static final String ROOT_CSS = "body[id='index']";

    public HomePage(WebDriver driver) {
        super(driver);
    }


}
