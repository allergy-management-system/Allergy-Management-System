package com.example.application.services.authentication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;

public class AuthServices {

    private final HttpClient httpClient;
    private final String baseUrl;

    public AuthServices() {
        this.httpClient = HttpClient.newHttpClient();
        this.baseUrl = "https://allergy-u6fk.onrender.com/api/v1";
    }

    public Optional<String> register(Map<String, Object> inputData) {
        return sendPostRequest("/addNewUser", inputData);
    }

    public Optional<String> login(Map<String, Object> inputData) {
        return sendPostRequest("/loginUser", inputData);
    }

    private Optional<String> sendPostRequest(String endpoint, Map<String, Object> inputData) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(inputData.toString()))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Optional.of(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
