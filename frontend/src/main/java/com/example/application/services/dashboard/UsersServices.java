package com.example.application.services.dashboard;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
public class UsersServices {

    private final HttpClient httpClient;
    private final String baseUrl;
//    private final String authToken;

    public UsersServices() {
        this.httpClient = HttpClient.newHttpClient();
        this.baseUrl = "https://allergy-u6fk.onrender.com/api/v1";
//        this.authToken = authToken;
    }

    public Optional<String> getAllUsers() {
        return sendGetRequest("/getAllUsers");
    }

    private Optional<String> sendGetRequest(String endpoint) {
        return sendRequest(endpoint, HttpRequest.newBuilder().GET());
    }

    private Optional<String> sendPostRequest(String endpoint, Map<String, Object> data) {
        return sendRequest(endpoint, HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(data.toString())));
    }

    private Optional<String> sendDeleteRequest(String endpoint) {
        return sendRequest(endpoint, HttpRequest.newBuilder().DELETE());
    }

    private Optional<String> sendPatchRequest(String endpoint, Map<String, Object> data) {
        return sendRequest(endpoint, HttpRequest.newBuilder().method("PATCH", HttpRequest.BodyPublishers.ofString(data.toString())));
    }

    private Optional<String> sendRequest(String endpoint, HttpRequest.Builder requestBuilder) {
        try {
            HttpRequest request = requestBuilder
                    .uri(URI.create(baseUrl + endpoint))
//                    .header("Authorization", "Bearer " + authToken)
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Optional.of(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
