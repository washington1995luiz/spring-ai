package br.com.washington.ai.client.impl;

import br.com.washington.ai.client.AiClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Component
public class AiClientImpl implements AiClient {

    @Value("${spring.ai.ollama.base-url}")
    private String baseUrl;

    @Value("${spring.ai.ollama.model}")
    private String model;

    private final RestTemplate restTemplate;

    @Override
    public String askAi(String prompt) {
        try{

            String url = String.format("%s/generate", baseUrl);

            Map<String, Object> request = new HashMap<>();
            request.put("model", model);
            request.put("prompt", prompt);
            request.put("stream", false);

            String response = restTemplate.postForObject(url, request, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response);
            return root.get("response").asText();
        }  catch (HttpClientErrorException e) {
            log.error("was not possible find response!\n\nError:{}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return "we are unable to process your query";
        }
    }
}
