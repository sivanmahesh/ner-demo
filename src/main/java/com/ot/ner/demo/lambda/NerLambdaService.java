package com.ot.ner.demo.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ot.ner.demo.dto.NerResponse;
import com.ot.ner.demo.service.NerService;

import java.util.Map;
import java.util.Set;

public class NerLambdaService implements RequestHandler {
    @Override
    public Object handleRequest(Object o, Context context) {

        String content = (String)o;
        NerService service = new NerService();
        Map<String, Set<String>> matches = service.getPIISuggestions(content);

        NerResponse response = new NerResponse();
        response.setMatches(matches);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return  objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }



    }
}
