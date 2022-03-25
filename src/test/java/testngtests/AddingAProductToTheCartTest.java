package testngtests;

import datastructures.Category;
import datastructures.Color;
import datastructures.SizeBody;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testngpages.HomePage;
import testngpages.categories.DressesCategoryPage;
import testngpages.categories.TShirtsCategoryPage;
import testngpages.categories.WomenCategoryPage;
import testngpages.layercartmodal.LayerCartModal;

import static testngpages.Page.STORE_URL;

@Listeners(TestListener.class)
public class AddingAProductToTheCartTest extends AbstractTest {

    @BeforeClass
    public void openStorePage() {
        setUp();
        homePage = new HomePage(driver);
    }

    @Test
    public void addingABlouseToCartTest() {
        LayerCartModal layerCartModal = homePage.clickCategory(Category.WOMEN, WomenCategoryPage.class)
                .openQuickViewModalForProduct("Blouse")
                .inputQuantity(2)
                .selectColor(Color.BLACK)
                .selectSize(SizeBody.L)
                .clickAddToCartButton();
        Assert.assertEquals(layerCartModal.getInformationAboutAddingProduct(), "Product successfully added to your shopping cart");
        Assert.assertEquals(layerCartModal.getProductName(), "Blouse");
        Assert.assertEquals(layerCartModal.getColorOfProduct(), Color.BLACK);
        Assert.assertEquals(layerCartModal.getSizeOfProduct(), SizeBody.L);
        layerCartModal.clickContinueShopping();
    }

    @Test
    public void addingAFadedShortSleeveTshirtsToCartTest() {
        LayerCartModal layerCartModal = homePage.clickCategory(Category.T_SHIRTS, TShirtsCategoryPage.class)
                .openQuickViewModalForProduct("Faded Short Sleeve T-shirts")
                .inputQuantity(1)
                .selectColor(Color.ORANGE)
                .selectSize(SizeBody.M)
                .clickAddToCartButton();
        Assert.assertEquals(layerCartModal.getInformationAboutAddingProduct(), "Product successfully added to your shopping cart");
        Assert.assertEquals(layerCartModal.getProductName(), "Faded Short Sleeve T-shirts");
        Assert.assertEquals(layerCartModal.getColorOfProduct(), Color.ORANGE);
        Assert.assertEquals(layerCartModal.getSizeOfProduct(), SizeBody.M);
        layerCartModal.clickContinueShopping();
    }

    @Test
    public void addingAPrintedSummerDressToCartTest() {
        LayerCartModal layerCartModal = homePage.clickCategory(Category.DRESSES, DressesCategoryPage.class)
                .openQuickViewModalForProduct("Printed Summer Dress")
                .inputQuantity(2)
                .selectColor(Color.YELLOW)
                .selectSize(SizeBody.S)
                .clickAddToCartButton();
        Assert.assertEquals(layerCartModal.getInformationAboutAddingProduct(), "Product successfully added to your shopping cart");
        Assert.assertEquals(layerCartModal.getProductName(), "Printed Summer Dress");
        Assert.assertEquals(layerCartModal.getColorOfProduct(), Color.YELLOW);
        Assert.assertEquals(layerCartModal.getSizeOfProduct(), SizeBody.S);
        layerCartModal.clickContinueShopping();
    }

    @AfterMethod
    public void openHomePage() {
        driver.navigate().to(STORE_URL);
    }
}
