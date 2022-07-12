package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProductPageObjects {

    WebDriver driver;

    By title = By.name("title");

    public AddProductPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void setTitle(String text) {
        driver.findElement(title).sendKeys(text);
    }
}
