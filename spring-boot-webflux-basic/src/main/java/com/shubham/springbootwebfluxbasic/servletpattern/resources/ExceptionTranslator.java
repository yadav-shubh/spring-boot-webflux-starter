package com.shubham.springbootwebfluxbasic.servletpattern.resources;

import com.shubham.springbootwebfluxbasic.exception.BadRequestException;
import com.shubham.springbootwebfluxbasic.exception.UnAuthrorizeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/translate")
public class ExceptionTranslator {

    @RequestMapping("/bad-request")
    public void throwException() {
        throw new BadRequestException("BadRequestException");
    }

    @RequestMapping("/unauthorized")
    public void throwException2() {
        throw new UnAuthrorizeException("UnAuthrorizeException");
    }

    @RequestMapping("/forbidden")
    public void throwException3() {
        typeCounter("give me 10 dollars");
        throw new RuntimeException("Exception");
    }

    public static void typeCounter(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        map.put("string", 0);
        map.put("integer", 0);
        map.put("double", 0);
        String[] parts = sentence.split(" ");
        for (String string : parts) {
            try {
                Integer.parseInt(string);
                map.put("integer", map.getOrDefault("integer", 0) + 1);
            } catch (Exception e) {

            }

            try {
                Double.parseDouble(string);
                if(string.contains(".")){
                    Double.parseDouble(string);
                    map.put("double", map.getOrDefault("double", 0) + 1);
                }
            } catch (Exception e) {
                map.put("string", map.getOrDefault("string", 0) + 1);

            }

        }
        
    }
}
