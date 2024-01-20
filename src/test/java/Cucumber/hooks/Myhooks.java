package Cucumber.hooks;

import Cucumber.context.TestContext;
import Cucumber.factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class Myhooks {

    private WebDriver driver;
    private TestContext context;


    public Myhooks(TestContext context)
    {
            this.context=context;
    }

    @Before
    public void before(Scenario scenario)
    {


        System.out.println("BEFORE THREAD ID:" + Thread.currentThread().getId() + "," + "Scenario name is :" +scenario.getName());
        driver= Driverfactory.initilization(System.getProperty("browser","chrome"));
    }

    @After
    public void after(Scenario scenario)
    {
        System.out.println("AFTER THREAD ID:" + Thread.currentThread().getId() + "," + "Scenario name is :" +scenario.getName());

        driver.quit();
    }
}
