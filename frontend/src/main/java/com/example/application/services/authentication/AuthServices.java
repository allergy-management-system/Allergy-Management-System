package com.example.application.services.authentication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.vaadin.flow.component.page.WebStorage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class AuthServices {
    private static String authToken = null;
    private final HttpClient httpClient;
    private final RestTemplate restTemplate;
    private final String baseUrl;

    private static final String NAME_KEY = "userId";

    public AuthServices() {
        this.httpClient = HttpClient.newHttpClient();
        this.baseUrl = "https://allergy-u6fk.onrender.com/api/v1";
        restTemplate = new RestTemplate();
    }

    public Object loginUser (MultiValueMap<String, String> requestBody) {
        try {
            String response;
            response = restTemplate.postForObject(baseUrl + "/loginUser", requestBody, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree((String) response);

            if (jsonNode != null && !jsonNode.isEmpty()) {
                authToken = jsonNode.get("userId").asText();
                WebStorage.setItem(NAME_KEY,jsonNode.get("userId").asText());
            }

            if (response.contains("status")) {
                return "500";
            } else {
                return "200";
            }

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Object registerUser(String inputData) {
        //<--set the Authentication token
        String signUpAuthToken = "8IvE5eAQaaRJXSZKgw4CDUBbEy8G9GpfajrbuS4pJ79gS7yo4kx6of1nbOpwvTMU";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/addNewUser"))
                    .header("Content-Type", "application/json")
                    .header("Authentication", "Barrier" + signUpAuthToken)
                    .POST(HttpRequest.BodyPublishers.ofString(inputData))
                    .build();

            HttpResponse<String> response  = sendRequest(request);

            return response.statusCode();

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private HttpResponse<String>  sendRequest(HttpRequest request) {
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public static boolean isUserLoggedIn() {
        return authToken != null;
    }

    public void logout() {
        // Clear authentication token on logout
        WebStorage.removeItem(NAME_KEY);
        authToken = null;
    }
}
