package dashboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPageObjects;

import java.time.Duration;

public class Product_TC1 {
    WebDriver driver;
    ProductPageObjects productPageObjects;

    @BeforeTest
    @Parameters({"browser", "url"})
    void setup(String browser, String baseUrl) {
        // testing with only chrome and firefox
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("unidentified browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl + "/#/products");
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
    void confirmEditProductModal() throws InterruptedException {
        productPageObjects.openEditProductModal();
        Thread.sleep(1000);
        WebElement submitButton = productPageObjects.getSubmitButton();
        Assert.assertTrue(submitButton.isDisplayed());
        productPageObjects.getCancelButton().click();
        Thread.sleep(1000);
    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }
}
