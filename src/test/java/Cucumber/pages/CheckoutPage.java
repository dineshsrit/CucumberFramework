package Cucumber.pages;

import Objects.Billingdetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".checkout-button")
    private WebElement checkout;

    @FindBy(id="billing_first_name")
    private WebElement firstname;

    @FindBy(id="billing_last_name")
    private WebElement lastname;

    @FindBy(id="billing_address_1")
    private WebElement billaddress1;

    @FindBy(id="billing_city")
    private WebElement billcity;

    @FindBy(id="billing_state")
    private WebElement billstate;

    @FindBy(id="billing_postcode")
    private WebElement billpostcode;

    @FindBy(id="billing_email")
    private WebElement billmail;

    @FindBy(id="place_order")
    private WebElement placeorder;

    @FindBy(css=".woocommerce-notice")
    private WebElement ordersuccess;

    @FindBy(css = "td[class='product-name'] a")
    private WebElement prodname;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement prodqty;

    public CheckoutPage enterfirstname(String first_name)
    {
        wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys(first_name);
        return this;
    }

    public CheckoutPage enterlastname(String last_name)
    {
        wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(last_name);
        return this;
    }

    public CheckoutPage enterbilladdress(String address)
    {
        wait.until(ExpectedConditions.visibilityOf(billaddress1)).sendKeys(address);
        return this;
    }
    public CheckoutPage enterbillcity(String city)
    {
        wait.until(ExpectedConditions.visibilityOf(billcity)).sendKeys(city);
        return this;
    }
    public CheckoutPage enterbillstate(String state)
    {
        Select select= new Select(wait.until(ExpectedConditions.visibilityOf(billstate)));
        select.selectByVisibleText(state);
        return this;
    }

    public CheckoutPage enterbillpostcode(String postcode)
    {
        wait.until(ExpectedConditions.visibilityOf(billpostcode)).sendKeys(postcode);
        return this;
    }

    public CheckoutPage enterbillemail(String mail)
    {
        wait.until(ExpectedConditions.visibilityOf(billmail)).sendKeys(mail);
        return this;
    }
    public void checkoutproduct()
    {
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }

    public CheckoutPage getDetails(Billingdetails billingdetails)
    {
        return enterfirstname(billingdetails.getFirstname()).enterlastname(billingdetails.getLastname()).enterbilladdress(billingdetails.getAddress()).enterbillcity(billingdetails.getCity())
                .enterbillstate(billingdetails.getState()).enterbillpostcode(billingdetails.getPostalcode()).enterbillemail(billingdetails.getEmail());
    }

    public void setPlaceorder()
    {
        wait.until(ExpectedConditions.visibilityOf(placeorder)).click();
    }

    public String getsuccessmsg()
    {
       return wait.until(ExpectedConditions.visibilityOf(ordersuccess)).getText();
    }

    public String getProductName()
    {
        return wait.until(ExpectedConditions.visibilityOf(prodname)).getText();
    }

    public int getProductqty()
    {
      String qty=   wait.until(ExpectedConditions.visibilityOf(prodqty)).getAttribute("value");
      return Integer.parseInt(qty);
    }
}
