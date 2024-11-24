package br.com.washington.ai.http.controller;

import br.com.washington.ai.http.request.QuestionRequest;
import br.com.washington.ai.http.response.QuestionResponse;
import br.com.washington.ai.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

    private final AiService service;

    @PostMapping
    public QuestionResponse askAi(@RequestBody QuestionRequest request){
        return service.askAi(request);
    }
}
