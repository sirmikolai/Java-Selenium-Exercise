package testngpages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractStorePage {

    private static final Log logger = LogFactory.getLog(HomePage.class);

    public static final String ROOT_CSS = "body[id='index']";

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
