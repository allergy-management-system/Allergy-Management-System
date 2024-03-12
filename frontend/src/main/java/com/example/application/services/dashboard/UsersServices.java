package com.example.application.services.dashboard;

import com.example.application.views.component.formStepper.FormFields;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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

    private final String chatEndpoint;

    private final RestTemplate restTemplate;
    private RestTemplate requestBody;

    public UsersServices() {
        this.httpClient = HttpClient.newHttpClient();
        this.baseUrl = "https://2cd6-196-61-44-226.ngrok-free.app";

        this.chatEndpoint = baseUrl + "/api/v1/allergy/chat";
        restTemplate = new RestTemplate();
    }

    public String sendMessageParams(MultiValueMap<String, String> requestBody) {
        try {
            String response;

            response = restTemplate.postForObject("https://2cd6-196-61-44-226.ngrok-free.app/api/v1/allergy/chat", requestBody, String.class);
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    public Object sendMessage(String message) {
        return sendPostRequest("/api/v1/allergy/chat", message);
    }

    private Object sendPostRequest(String endpoint ,String inputData) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(inputData))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Object getAllHistory() {
        return sendGetRequest("/api/v1/allergy/chat");
    }

    private Object sendGetRequest(String endpoint) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
