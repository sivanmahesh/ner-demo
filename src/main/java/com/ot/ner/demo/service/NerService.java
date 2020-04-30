package com.ot.ner.demo.service;

import org.apache.tika.parser.ner.regex.RegexNERecogniser;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;
import java.util.Set;

@Service
public class NerService {

    public Map<String, Set<String>> getPIISuggestions(String str) {
        InputStream stream = NerService.class.getClassLoader().getResourceAsStream("ner-regex.txt");
        RegexNERecogniser regexNERecogniser = new RegexNERecogniser(stream);

        Map<String, Set<String>> matches = regexNERecogniser.recognise(str);

        return matches;
    }



}

