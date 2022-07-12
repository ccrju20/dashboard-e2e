package dashboard;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.AddProductPageObjects;
import pages.ProductPageObjects;

public class Product_TC2 {
    WebDriver driver;
    ProductPageObjects productPageObjects;
    AddProductPageObjects addProductPageObjects;

    @BeforeClass
    void setup() {
        driver = InitProduct.getDriver();
        productPageObjects = new ProductPageObjects(driver);
        addProductPageObjects = new AddProductPageObjects(driver);
    }

    @Test
    void inputTitle() throws InterruptedException {
        productPageObjects.openAddProductModal();
        addProductPageObjects.setTitle("cake");
        Thread.sleep(3000);
    }

}
