package dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ProductPageObjects;

public class Product_TC1 {
    WebDriver driver;
    ProductPageObjects productPageObjects;

    @BeforeClass
    void setup() {
        driver = InitProduct.getDriver();
        productPageObjects = new ProductPageObjects(driver);
    }

    @Test
    void confirmPage() {
        String title = productPageObjects.getPageTitle();
        Assert.assertEquals(title, "Products");
    }

    @Test
    void confirmAddProductModal() {
        productPageObjects.openAddProductModal();
        WebElement submitButton = productPageObjects.getSubmitButton();
        Assert.assertTrue(submitButton.isDisplayed());
        productPageObjects.getCancelButton().click();
    }

    @Test
    void confirmProductTotals() {
        int totalItems = productPageObjects.getTotalProductItems();
        int chipTotal = productPageObjects.getChipTotal();
        Assert.assertEquals(totalItems, chipTotal);
    }

    @Test
    void confirmEditProductModal() {
        productPageObjects.openEditProductModal();
        WebElement submitButton = productPageObjects.getSubmitButton();
        Assert.assertTrue(submitButton.isDisplayed());
        productPageObjects.getCancelButton().click();
    }

    @Test
    void confirmAddOptionsModal() {
        productPageObjects.openAddOptionsModal();
        WebElement submitButton = productPageObjects.getSubmitButton();
        Assert.assertTrue(submitButton.isDisplayed());
        productPageObjects.getCancelButton().click();
    }

}
