package Cucumber.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DummyStepDefintions {
    @Given("given some dummy scenario")
    public void given_some_dummy_scenario() {
       System.out.println("Some Scenarios");

    }
    @When("to validate {word}")
    public void to_validate(String string) {
        System.out.println(string);

    }
    @Then("validated")
    public void validated() {

        System.out.println("Validated");
    }
}
