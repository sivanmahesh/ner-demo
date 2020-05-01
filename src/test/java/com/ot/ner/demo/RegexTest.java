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

        phoneNumbers.add("this is a 1234567890 asdas");
        phoneNumbers.add("this is a 123-456-7890 asd");
        phoneNumbers.add("this is a 123.456.7890 as");
        phoneNumbers.add("this is a 123 456 7890 asd" );
        phoneNumbers.add("this is a (123) 456 7890");
        phoneNumbers.add("this is a +17708934456");

        //Invalid phone numbers
        phoneNumbers.add("12345678");
        phoneNumbers.add("12-12-111");
        //String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        //String regex=  "^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?";

        //String regex = "(?:(?:\\\\+?([1-9]|[0-9][0-9]|[0-9][0-9][0-9])\\\\s*(?:[.-]\\\\s*)?)?(?:\\\\(\\\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\\\s*\\\\)|([0-9][1-9]|[0-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\\\s*(?:[.-]\\\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\\\s*(?:[.-]\\\\s*)?([0-9]{4})(?:\\\\s*(?:#|x\\\\.?|ext\\\\.?|extension)\\\\s*(\\\\d+))?";
        String regex = "(?:(?:\\+?([1-9]|[0-9][0-9]|[0-9][0-9][0-9])\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([0-9][1-9]|[0-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?";
        Pattern pattern = Pattern.compile(regex);

        // mahesh test

        String content = "This is from msivan@onetrust.com. my phone number is 770-893-8897";
        Matcher matcherText = pattern.matcher(content);
        boolean flag = matcherText.matches();


        System.out.println("flag is ? "+flag);


        for(String email :phoneNumbers)

        {
            Matcher matcher = pattern.matcher(email);
            System.out.println(email + " : " + matcher.matches());
        }
    }


}




