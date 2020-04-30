package com.ot.ner.demo.controller;


import com.ot.ner.demo.service.NerService;
import com.ot.ner.demo.dto.NerRequest;
import com.ot.ner.demo.dto.NerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/ner")
public class NerDemoController {

    @Autowired
    protected NerService nerService;

    @PostMapping(value = "/recognize")
    public NerResponse checkForPII(@RequestBody final NerRequest request) {


        NerResponse response = new NerResponse();

        Map<String, Set<String>> matches = nerService.getPIISuggestions(request.getData());
        response.setMatches(matches);


        return response;
    }


}
