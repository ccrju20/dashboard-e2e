package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageObjects {

    WebDriver driver;

    By title = By.cssSelector("h4[data-test=products]");
    By addButton = By.xpath("//button[text()='Add']");
    By submitButton = By.id("submit");
    By cancelButton = By.id("cancel");
    By cardItems = By.className("MuiAvatar-circular");
    By chipTotal = By.className("MuiChip-root");
    By firstProduct = By.xpath("(//button[@data-test='product'])[1]");

    public ProductPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
      return driver.findElement(title).getText();
    }

    public void openAddProductModal() {
        driver.findElement(addButton).click();
    }

    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
    }

    public WebElement getCancelButton() {
        return driver.findElement(cancelButton);
    }

    public int getTotalProductItems() {
       return driver.findElements(cardItems).size();
    }

    public int getChipTotal() {
       String total = driver.findElement(chipTotal).getAttribute("data-test");
       return Integer.valueOf(total);
    }

    public void openEditProductModal() {
        driver.findElement(firstProduct).click();
    }
}
