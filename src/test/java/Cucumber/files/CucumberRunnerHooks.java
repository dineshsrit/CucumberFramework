package Cucumber.files;

import io.cucumber.java.*;

public class CucumberRunnerHooks {

    @BeforeAll
    public static void beforeAll()
    {
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll()
    {
        System.out.println("After All");
    }


    @Before
    public static void before(Scenario scenario)
    {
        System.out.println("before Scenario");
        System.out.println("Scenario Name:" +scenario.getName());
        System.out.println("Scenario Line:" +scenario.getLine());
        System.out.println("Scenario Tagnames:" +scenario.getSourceTagNames());
        System.out.println("Scenario Status:" +scenario.getStatus());
        System.out.println("Scenario URI:" +scenario.getUri());
        System.out.println("Scenario isFailed:" +scenario.isFailed());
    }

    @After
    public static void after(Scenario scenario)
    {
        System.out.println("after ");
        System.out.println("Scenario Name:" +scenario.getName());
        System.out.println("Scenario Line:" +scenario.getLine());
        System.out.println("Scenario Tagnames:" +scenario.getSourceTagNames());
        System.out.println("Scenario Status:" +scenario.getStatus());
        System.out.println("Scenario URI:" +scenario.getUri());
        System.out.println("Scenario isFailed:" +scenario.isFailed());
    }
}
