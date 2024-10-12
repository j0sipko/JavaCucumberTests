package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.myorg.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberTestStepsCalculator {
    private int result;

    @When("^We calculate (.*) (.*) (.*)$")
    public void we_calculate(int value1, String operator, int value2) {
        Calculator calculator = new Calculator();
        switch (operator) {
            case "+":
                result = calculator.add(value1, value2);
                break;
            case "-":
                result = calculator.sub(value1, value2);
                break;
            case "*":
                result = calculator.mul(value1, value2);
                break;
            case "/":
                result = calculator.div(value1, value2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    @Then("^Method should return (.*)$")
    public void method_should_return_expected_result(int expectedResult) {
        assertEquals(expectedResult, result);
    }
}
