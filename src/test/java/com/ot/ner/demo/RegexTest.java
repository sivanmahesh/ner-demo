package com.ot.ner.demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {


    @Test
    public void testPhoneNumbers(){
        List<String> phoneNumbers = new ArrayList();

        phoneNumbers.add("1234567890");
        phoneNumbers.add("123-456-7890");
        phoneNumbers.add("123.456.7890");
        phoneNumbers.add("123 456 7890");
        phoneNumbers.add("(123) 456 7890");
        phoneNumbers.add("+17708934456");

        //Invalid phone numbers
        phoneNumbers.add("12345678");
        phoneNumbers.add("12-12-111");
        //String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        //String regex=  "^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?";

        String regex = "(?:(?:\\\\+?([1-9]|[0-9][0-9]|[0-9][0-9][0-9])\\\\s*(?:[.-]\\\\s*)?)?(?:\\\\(\\\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\\\s*\\\\)|([0-9][1-9]|[0-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\\\s*(?:[.-]\\\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\\\s*(?:[.-]\\\\s*)?([0-9]{4})(?:\\\\s*(?:#|x\\\\.?|ext\\\\.?|extension)\\\\s*(\\\\d+))?";
        Pattern pattern = Pattern.compile(regex);

        for(String email :phoneNumbers)

        {
            Matcher matcher = pattern.matcher(email);
            System.out.println(email + " : " + matcher.matches());
        }
    }


}




