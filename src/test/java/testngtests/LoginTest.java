package testngtests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testngpages.HomePage;
import testngpages.accountpages.AccountPage;

public class LoginTest extends AbstractTest {

    @BeforeClass
    public void openStorePage() {
        setUp();
        homePage = new HomePage(driver);
    }

    @Test
    public void signingInToStoreTest() {
        AccountPage accountPage = homePage.clickSignInButton()
                .inputEmailAddressForLogin("robert.farrell@gmail.com")
                .inputPasswordForLogin("qPPXnVY5")
                .clickSignIn();

        Assert.assertEquals(accountPage.getWelcomeText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
        Assert.assertEquals(accountPage.getUserNameFromHeader(), "Robert Farrell");
    }


}
