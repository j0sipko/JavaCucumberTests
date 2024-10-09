package org.myOrg;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ApiHelper {
    public static String sendPostRequest(String url, HashMap<String, String> headers, String body)
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url)); //postURL
        headers.forEach((key, value) -> {
            requestBuilder.header(key, value);
        });
        HttpRequest postRequest = requestBuilder
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpResponse<String> postResponse;
        try {
            postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return postResponse.body();
    }

    public static String sendGetRequest(String url, HashMap<String, String> headers)
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url)); //postURL
        headers.forEach((key, value) -> {
            requestBuilder.header(key, value);
        });
        HttpRequest getRequest = requestBuilder
                .build();
        HttpResponse<String> getResponse;
        try {
            getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getResponse.body();
    }
}
