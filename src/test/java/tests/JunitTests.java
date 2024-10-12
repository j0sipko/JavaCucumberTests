package tests;
import org.json.JSONObject;
import org.myorg.ApiHelper;
import org.myorg.Calculator;
import org.myorg.JsonHelper;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class JunitTests {

    @org.junit.jupiter.api.Test
    void addTest() {
        Calculator calculator = new Calculator();
        assertEquals(12, calculator.add(9,3), "9+3 test failed!");
    }

    @org.junit.jupiter.api.Test
    void subTest() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.sub(9,3), "9-3 test failed!");
    }

    @org.junit.jupiter.api.Test
    void mulTest() {
        Calculator calculator = new Calculator();
        assertEquals(27, calculator.mul(9,3), "9*3 test failed!");
    }

    @org.junit.jupiter.api.Test
    void divTest() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.div(9,3), "9/3 test failed!");
    }

    @org.junit.jupiter.api.Test
    void testGetAPI() {
        HashMap<String, String> headers = new HashMap<>();
        String response = ApiHelper.sendGetRequest("https://api.github.com/users/eugenp", headers);
        JSONObject responseJson = new JSONObject(response);
        System.out.println(responseJson.toString(4));
    }

    @org.junit.jupiter.api.Test
    void testPostAPI() {
        String body = JsonHelper.getTextFromResFile("successLogin.json");
        HashMap<String, String> headers = new HashMap<>();
        String response = ApiHelper.sendPostRequest("https://json-placeholder.mock.beeceptor.com/login", headers, body);
        JSONObject responseJson = new JSONObject(response);
        System.out.println(responseJson.toString(4));
    }
}