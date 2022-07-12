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
    void setup(String browser, String url) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        productPageObjects = new ProductPageObjects(driver);
    }

    @Test
    void confirmPage() {
        String title = productPageObjects.getPageTitle();
        Assert.assertEquals(title, "Products");
    }

    @Test
    void confirmAddProductModal() throws InterruptedException {
        WebElement submitButton = productPageObjects.openAddProductModal();
        Assert.assertTrue(submitButton.isDisplayed());
        Thread.sleep(1000);
    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }
}
