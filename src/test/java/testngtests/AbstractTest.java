package testngtests;

import datastructures.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import testngpages.HomePage;

import static testngpages.Page.STORE_URL;

public abstract class AbstractTest {

    WebDriver driver;
    HomePage homePage;
    private String BROWSER = System.getProperty("browser").toUpperCase();

    public void setUp() {
        driver = getBrowser(getBrowserType(BROWSER));
        driver.manage().window().maximize();
        driver.get(STORE_URL);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    private WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {
            case FIREFOX:
                return getFirefoxBrowser();
            case EDGE:
                return getEdgeBrowser();
            default:
                return getChromeBrowser();
        }
    }

    private WebDriver getChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver getFirefoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver getEdgeBrowser() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private BrowserType getBrowserType(String browserName) {
        for (BrowserType browserType : BrowserType.values()) {
            if (browserType.getName().equalsIgnoreCase(browserName)) {
                return browserType;
            }
        }
        return null;
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
