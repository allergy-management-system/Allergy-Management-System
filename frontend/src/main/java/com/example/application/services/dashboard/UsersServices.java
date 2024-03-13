package com.example.application.services.dashboard;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

public class UsersServices {

    private final HttpClient httpClient;
    private final String baseUrl;
    private final RestTemplate restTemplate;

    private Object[][] historyData;
    public UsersServices() {
        this.httpClient = HttpClient.newHttpClient();
        this.baseUrl = "https://6663-196-61-44-226.ngrok-free.app";

        restTemplate = new RestTemplate();
    }

    public String sendMessageParams(MultiValueMap<String, String> requestBody) {
        try {
            String response;
            response = restTemplate.postForObject("https://6663-196-61-44-226.ngrok-free.app/api/v1/allergy/chat", requestBody, String.class);

            // Parse JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree((String) response);

            String responseMessage = jsonNode.get("response").asText();

            String[] lines = responseMessage.split("\n");
            StringBuilder trimmedText = new StringBuilder();
            for (int i = 0; i < Math.min(lines.length, 5); i++) {
                trimmedText.append(lines[i]).append("\n");
            }

            return trimmedText.toString();

        } catch (Exception e) {
            return String.valueOf(e.getMessage());
        }
    }

    public List<JsonNode> getAllHistory(String userId) {
        List<JsonNode> responseNodes = new ArrayList<>();

        try {
            // Construct the request body with the userId
            MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
            requestBody.add("userId", userId);

            // Set up the URL
            String url = "https://allergy-u6fk.onrender.com/api/v1/allergy/history";

            // Make the POST request with the request body
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestBody, String.class);
            String response = responseEntity.getBody();


            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode responseNode = objectMapper.readTree(response);

            // Check if the response is an array
            if (responseNode.isArray()) {
                // Iterate over each element in the array
                for (JsonNode arrayElement : responseNode) {
                    System.out.println("Array Element: " + arrayElement);
                    responseNodes.add(arrayElement);
                }
            } else {
                // If the response is not an array, print the entire response
                responseNodes.add(responseNode);
            }
            return responseNodes;

        } catch (Exception e) {
            return null;
        }
    }

    public Object DeleteAllergy (String userId) {
        try {
            // Construct the request body with the userId
            MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
            requestBody.add("userId", userId);

            // Set up the URL
            String url = "https://allergy-u6fk.onrender.com/api/v1/allergy/history";

            // Make the POST request with the request body
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestBody, String.class);
            String response = responseEntity.getBody();

            System.out.println("Response: " + response);

            return response;
        } catch (Exception e) {
            e.getMessage();
            return String.valueOf(e.getMessage());
        }
    }

}
