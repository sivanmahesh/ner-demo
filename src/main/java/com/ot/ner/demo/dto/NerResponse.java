package com.ot.ner.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Set;

public class NerResponse {

    public Map<String, Set<String>> getMatches() {
        return matches;
    }

    public void setMatches(Map<String, Set<String>> matches) {
        this.matches = matches;
    }

    @JsonProperty(value = "Suggestions")
    Map<String, Set<String>> matches;
}
