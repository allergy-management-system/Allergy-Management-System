package com.example.application.services.authentication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class AuthServices {
    private static String authToken = null;
    public static String userId = null;
    private final HttpClient httpClient;
    private final String baseUrl;


    public AuthServices() {
        this.httpClient = HttpClient.newHttpClient();
        this.baseUrl = "https://allergy-u6fk.onrender.com/api/v1";
    }

    public Object loginUser(String inputData) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/loginUser"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(inputData))
                    .build();

            HttpResponse<String> response  = sendRequest(request);

            return response.statusCode();

        } catch (Exception e) {
            e.getMessage();
            return Optional.empty();
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

            // Parse JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree((String) response.body());

            if (jsonNode != null && !jsonNode.isEmpty()) {
                userId = jsonNode.get("userId").asText(); // Store token upon successful login
            }

            return response.statusCode();

        } catch (Exception e) {
            return Optional.empty();
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
        authToken = null;
    }
}
