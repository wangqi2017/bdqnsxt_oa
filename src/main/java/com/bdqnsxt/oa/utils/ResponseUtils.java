package com.bdqnsxt.oa.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtils {

    public static Map<String,Object> extJSProxyResponse(boolean success, String message){
        Map<String,Object> map = new HashMap<>();
        map.put("success",success);
        map.put("message",message);
        return map;
    }

    public static Map<String,Object> successExtJSProxyResponse(String message){
        return extJSProxyResponse(true,message);
    }

    public static Map<String,Object> failureExtJSProxyResponse(String message){
        return extJSProxyResponse(false,message);
    }

    public static Map<String,Object> successExtJSProxyResponse(Object data, Long totalCount, String message) {
        Map<String, Object> res = new HashMap<>();
        res.put("success", "true");
        res.put("data", data);
        res.put("message", message);
        res.put("total", totalCount);
        return res;
    }

    public static Map<String,Object> successExtJSProxyResponse(Object data,String message) {
        Map<String, Object> res = new HashMap<>();
        res.put("success", "true");
        res.put("data", data);
        res.put("message",message);
        return res;
    }

    public static Map<String,Object> extJSProxyResponse(Object data, Long totalCount) {
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", totalCount);
        return res;
    }

    public static Map<String,Object> successExtJSTreeProxyResponse(Object data, String overrideDataKey) {
        Map<String, Object> res = new HashMap<String, Object>(1);
        res.put(overrideDataKey, data);
        return res;
    }
}
