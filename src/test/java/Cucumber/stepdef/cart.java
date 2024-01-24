package Cucumber.stepdef;

import Cucumber.factory.Driverfactory;
import Cucumber.pages.CheckoutPage;
import Cucumber.pages.StorePage;
import Cucumber.utils.ConfigLoader;
import Objects.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.stylesheets.LinkStyle;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class cart {

   private  WebDriver driver;

    @Given("Iam on the Store Page")
    public void iam_on_the_store_page() {
        // Write code here that turns the phrase above into concrete actions
       /* System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();*/
        driver= Driverfactory.getDriver();
        driver.manage().window().maximize();
        new StorePage(driver).get(ConfigLoader.getInstance().getBaseUrl());
        new StorePage(driver).ClickStore();
       /* By store = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");
        driver.findElement(store).click();*/

    }

    @When("I add a {product} to the Cart")
    public void i_add_a_to_the_cart(Product product) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
       /* By shoes = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
        driver.findElement(shoes).click();
        By viewcart = By.cssSelector("a[title='View cart']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewcart));
        driver.findElement(viewcart).click();*/

        new StorePage(driver).addtocart(product.getName());
        System.out.println(product.getName());
        System.out.println("dummy output for checking the Github Hook trigger for GitScm Polling");


    }

    @Then("I should see {int} {product} in the Cart")
    public void i_should_see_in_the_cart(Integer qty, Product productname) {
        // Write code here that turns the phrase above into concrete actions
        /*By Prodname = By.linkText("Blue Shoes");
        String selectedproductname = driver.findElement(Prodname).getText();*/

        System.out.println("selected prod:" + new CheckoutPage(driver).getProductName());
        System.out.println("expected Prod:" + productname.getName());

        Assert.assertEquals(productname.getName(), new CheckoutPage(driver).getProductName());
        /*By prodqty = By.xpath("//input[@type='number']");
        String expectedqty = driver.findElement(prodqty).getAttribute("value");*/

        Assert.assertEquals(qty, new CheckoutPage(driver).getProductqty());

    }


}