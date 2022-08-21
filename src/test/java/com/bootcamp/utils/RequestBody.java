package com.bootcamp.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class RequestBody {
    public JSONObject userRequestBody() {
        JSONObject userRequest = new JSONObject();
        userRequest.put("id", 1010);
        userRequest.put("username", "userBostonCodersLand");
        userRequest.put("firstName", "user");
        userRequest.put("lastName", "zero");
        userRequest.put("email", "user@zero.com");
        userRequest.put("password", "zero000");
        userRequest.put("phone", "+905426928600");
        userRequest.put("userStatus", 1);
        return userRequest;
    }

}
