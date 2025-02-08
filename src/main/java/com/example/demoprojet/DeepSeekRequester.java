package com.example.demoprojet;

import com.example.demoprojet.dto.DeepSeekResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class DeepSeekRequester {

    public static String askNetwork (String question)
    {
        HttpClient client = HttpClient.newHttpClient();

        String body = """
            {
              "model": "deepseek-r1:1.5b",
              "prompt": "%s",
              "stream": false
            }""".formatted(question);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:11434/api/generate"))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            var responseBody = response.body();
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            DeepSeekResponse dsResponse = objectMapper.readValue(responseBody, DeepSeekResponse.class);
            String answer = dsResponse.getResponse();
            //System.out.println(responseBody);
            return answer;
        }
        catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "Can't send request";
        }
    }

    public static void main (String[] args) {
        String answer = askNetwork("Why is the sky blue?");
        System.out.println("answer: " + answer);


    }

}