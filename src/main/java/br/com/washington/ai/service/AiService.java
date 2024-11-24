package br.com.washington.ai.service;

import br.com.washington.ai.http.request.QuestionRequest;
import br.com.washington.ai.http.response.QuestionResponse;

public interface AiService {

    QuestionResponse askAi(QuestionRequest request);
}
