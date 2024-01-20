package Cucumber.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driverfactory {

    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static WebDriver initilization(String browser)
    {
        WebDriver driver;
        switch (browser)
        {
            case "chrome":
               // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
               // System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("browser is not available");
        }
        Driverfactory.driver.set(driver);
        return driver;
    }

    public static WebDriver getDriver()
    {
        return driver.get();
    }
}
