package Cucumber.pages;

import Objects.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StorePage extends BasePage{

    @FindBy(css = "a[title='View cart']")
    private WebElement viewcart;

    @FindBy(css="li[id='menu-item-1227'] a[class='menu-link']")
    private WebElement store;
    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void ClickStore()
    {
        wait.until(ExpectedConditions.visibilityOf(store)).click();
    }

    public void addtocart(String productname)
    {

        By shoes = By.cssSelector("a[aria-label='Add “" +productname+ "” to your cart']");
        System.out.println("the product name is:"+wait.until(ExpectedConditions.elementToBeClickable(shoes)).getText());
        wait.until(ExpectedConditions.elementToBeClickable(shoes)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewcart)).click();
    }
}
