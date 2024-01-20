package Cucumber.stepdef;

import Cucumber.factory.Driverfactory;
import Cucumber.pages.BasePage;
import Cucumber.pages.CheckoutPage;
import Cucumber.pages.StorePage;
import Cucumber.utils.ConfigLoader;
import Objects.Billingdetails;
import Objects.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class PlaceorderasGuest {

   private WebDriver driver;
   private Billingdetails billdetails;

    private Product product;

    @Given("Iam a guest customer")
    public void iam_a_guest_customer() {

        /*driver= Driverfactory.getDriver();
        System.out.println("Driver:" +driver);*/

       /* System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();*/
        driver= Driverfactory.getDriver();
        driver.manage().window().maximize();
        new BasePage(driver).get(ConfigLoader.getInstance().getBaseUrl()+"store");
       //driver.get("https://askomdch.com/store");
    }

    @Given("I have a {product} in the cart")
    public void i_have_a_product_in_the_cart(Product product) {

        System.out.println(product.getName());
       new StorePage(driver).addtocart(product.getName());
    }

    @Given("Iam on the CheckOut Page")
    public void iam_on_the_check_out_page() {
       /* By checkout=By.cssSelector(".checkout-button");
        driver.findElement(checkout).click();*/
        new CheckoutPage(driver).checkoutproduct();
    }

    @When("I Provide the billing details")
    public void i_provide_the_billing_details(Billingdetails billdetails) {
       //this.billdetails=billdetails;

       /* By firstname=By.id("billing_first_name");
        By lastname=By.id("billing_last_name");
        By billaddress1=By.id("billing_address_1");
        By billcity=By.id("billing_city");
        By billstate=By.id("billing_state");
        By billpostcode=By.id("billing_postcode");
        By billmail=By.id("billing_email");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname));
        driver.findElement(firstname).sendKeys(billdetails.get(0).get("firstname"));
        driver.findElement(lastname).clear();
        driver.findElement(lastname).sendKeys(billdetails.get(0).get("lastname"));
        driver.findElement(billaddress1).clear();
        driver.findElement(billaddress1).sendKeys(billdetails.get(0).get("address1"));
        driver.findElement(billcity).clear();
        driver.findElement(billcity).sendKeys(billdetails.get(0).get("city"));


        Select select=new Select(driver.findElement(billstate));
        select.selectByVisibleText(billdetails.get(0).get("state"));

        driver.findElement(billpostcode).clear();
        driver.findElement(billpostcode).sendKeys(billdetails.get(0).get("zip"));
        driver.findElement(billmail).clear();
        driver.findElement(billmail).sendKeys(billdetails.get(0).get("email"));*/

        new CheckoutPage(driver).getDetails(billdetails);




    }

    @When("I Place the Order")
    public void i_place_the_order() {
       /* By placeorder=By.id("place_order");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeorder));
        driver.findElement(placeorder).click();*/
        new CheckoutPage(driver).setPlaceorder();
    }

    @Then("the order should be placed successfully with the message {string}")
    public void the_order_should_be_placed_successfully(String msg) {
     /*   By ordersuccess=By.cssSelector(".woocommerce-notice");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ordersuccess));

        String successmsg=driver.findElement(ordersuccess).getText();
        System.out.println(successmsg);*/
        Assert.assertEquals(msg, new CheckoutPage(driver).getsuccessmsg());



    }

}
