package testngtests;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import datastructures.Gender;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testngpages.HomePage;
import testngpages.accountpages.AccountPage;

@Listeners(TestListener.class)
public class RegistrationTest extends AbstractTest {

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();

    @BeforeClass
    public void openStorePage() {
        setUp();
        homePage = new HomePage(driver);
    }

    @Test
    public void registrationToStoreTest() {
        AccountPage accountPage = homePage.clickSignInButton()
                .inputEmailAddressForRegistration(person.getEmail())
                .clickCreateAnAccount()
                .selectGender(Gender.MAN)
                .inputFirstNameInPersonalInformation(person.getFirstName())
                .inputLastNameInPersonalInformation(person.getLastName())
                .inputPassword(person.getPassword())
                .selectDateOfBirth(person.getDateOfBirth())
                .inputFirstNameInAddressInformation(person.getFirstName())
                .inputLastNameInAddressInformation(person.getLastName())
                .inputCompanyName(person.getCompany().getName())
                .inputCityName(person.getAddress().getCity())
                .selectCountry("United States")
                .inputAddressLine1(person.getAddress().getAddressLine1())
                .inputAddressLine2(person.getAddress().getAddressLine2())
                .inputZipPostalCode(person.getAddress().getPostalCode())
                .inputMobilePhone(person.getTelephoneNumber())
                .inputAddressAliasForFutureReference(person.getCompany().getDomain())
                .selectState("Texas")
                .clickRegister();

        Assert.assertEquals(accountPage.getWelcomeText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
        Assert.assertEquals(accountPage.getUserNameFromHeader(), person.getFullName());
    }
}
