package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.myOrg.ApiHelper;
import org.myOrg.JsonHelper;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberTestStepsAPI {
    private JSONObject responseJson = null;

    @When("^We send post request with login credentials from (.*)$")
    public void we_send_post_request_with_login_credentials(String fileName) {
        String body = JsonHelper.getTextFromResFile(fileName);
        HashMap<String, String> headers = new HashMap<>();
        String response = ApiHelper.sendPostRequest("https://json-placeholder.mock.beeceptor.com/login", headers, body);
        responseJson = new JSONObject(response);
        System.out.println(responseJson.toString(4));
    }

    @When("^We send Get Git user request for user (.*)$")
    public void we_send_Get_user_request(String userName) {
        HashMap<String, String> headers = new HashMap<>();
        String response = ApiHelper.sendGetRequest("https://api.github.com/users/" + userName, headers);
        responseJson = new JSONObject(response);
        System.out.println(responseJson.toString(4));
    }

    @Then("^response should contain json with (.*) key$")
    public void response_should_contain(String keyName) {
        assertEquals(true, responseJson.has(keyName), "response json does not contain \""
                + keyName + "\"");
    }

    @Then("^response should contain json with key (.*) and value (.*) as (.*)$")
    public void response_should_contain(String keyName, String expectedValue, String valueType) {
        assertEquals(true, responseJson.has(keyName), "response json does not contain \""
                + keyName + "\"");
        String valueTypeLC = valueType.toLowerCase();
        String actualValue;
        switch (valueTypeLC) {
            case "boolean":
                actualValue = String.valueOf(responseJson.getBoolean(keyName));
                break;
            case "int":
                actualValue = String.valueOf(responseJson.getInt(keyName));
                break;
            case "double":
                actualValue = String.valueOf(responseJson.getDouble(keyName));
                break;
            case "float":
                actualValue = String.valueOf(responseJson.getFloat(keyName));
                break;
            case "long":
                actualValue = String.valueOf(responseJson.getLong(keyName));
                break;
            case "string":
                actualValue = responseJson.getString(keyName);
                break;
            default:
                throw new IllegalArgumentException("Invalid valueType: " + valueType);
        }
        assertEquals(expectedValue, actualValue);
    }
}
