package com.bdqnsxt.oa.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static JsonNode fromJson2(String jsonString) {
        try {
            return mapper.readTree(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
