package com.example.application.services.authentication;

import com.vaadin.flow.component.notification.Notification;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class AuthServices {
    private static String authToken = "8IvE5eAQaaRJXSZKgw4CDUBbEy8G9GpfajrbuS4pJ79gS7yo4kx6of1nbOpwvTMU";
    private final HttpClient httpClient;
    private final String baseUrl;


    public AuthServices() {
        this.httpClient = HttpClient.newHttpClient();
        this.baseUrl = "https://allergy-u6fk.onrender.com/api/v1";
    }

    public Object register(String inputData) {
        return sendPostRequest("/addNewUser", inputData);
    }

    public Object login(String inputData) {
        return sendPostRequest("/loginUser", inputData);
    }

    private Object sendPostRequest(String endpoint, String inputData) {
        //<--set the Authentication token
        String signUpAuthToken = "8IvE5eAQaaRJXSZKgw4CDUBbEy8G9GpfajrbuS4pJ79gS7yo4kx6of1nbOpwvTMU";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .header("Content-Type", "application/json")
                    .header("Authentication", "Barrier" + signUpAuthToken)
                    .POST(HttpRequest.BodyPublishers.ofString(inputData))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String token = ""; // Obtain token from response
            if (token != null && !token.isEmpty()) {
                authToken = token; // Store token upon successful login
            }

            return response.body();
        } catch (Exception e) {
            Notification.show("There's a network connection problem. Please, check your internet and try again.");
            return Optional.empty();
        }
    }

    public static boolean isUserLoggedIn() {
        return authToken != null;
    }

    public void logout() {
        // Clear authentication token on logout
        authToken = null;
    }
}
