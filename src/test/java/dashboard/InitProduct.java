package dashboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class InitProduct {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

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
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
