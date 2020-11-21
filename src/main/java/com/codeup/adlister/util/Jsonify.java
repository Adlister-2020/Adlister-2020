package com.codeup.adlister.util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jsonify {
    public static String jsonifyObj(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        return mapper.writeValueAsString(obj);
    }
}
