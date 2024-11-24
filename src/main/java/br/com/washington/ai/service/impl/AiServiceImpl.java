package br.com.washington.ai.service.impl;

import br.com.washington.ai.client.AiClient;
import br.com.washington.ai.http.request.QuestionRequest;
import br.com.washington.ai.http.response.QuestionResponse;
import br.com.washington.ai.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AiServiceImpl implements AiService {
    
    private final AiClient aiClient;

    @Value("${ai.ollama.rule}")
    private String rule;

    @Override
    public QuestionResponse askAi(QuestionRequest request) {

        String prompt = String.format(rule, request.getQuestion());

        String response = aiClient.askAi(prompt);

        return new QuestionResponse(response);
    }
}
