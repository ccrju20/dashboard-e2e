package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageObjects {

    WebDriver driver;

    By title = By.cssSelector("h4[data-test=products]");
    By addButton = By.xpath("//button[text()='Add']");
    By submitButton = By.id("submit");

    public ProductPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
      return driver.findElement(title).getText();
    }

    public WebElement openAddProductModal() {
        driver.findElement(addButton).click();
        return driver.findElement(submitButton);
    }
}
