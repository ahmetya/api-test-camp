package com.bootcamp.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

import java.util.Arrays;
import java.util.Random;


public class RequestBody {

    public JSONObject storePetRequest() {

        JSONObject storeRequest = new JSONObject();

        storeRequest.put("name", "nohut");
        storeRequest.put("photoUrls", new JSONArray(Arrays.asList("photo url 1", "photo url 2")));
        storeRequest.put("id", 1234);
        storeRequest.put("category", new JSONObject()
                .put("id", 1000)
                .put("name", "nohutun kategorisi")
        );
        storeRequest.put("tags", new JSONArray(Arrays.asList(
                new JSONObject().put("id", 2000).put("name", "nohutun tag degeri 1"),
                new JSONObject().put("id", 2000).put("name", "nohutun tag degeri 2")
        )));
        storeRequest.put("status", "available");
        return storeRequest;
    }

    public JSONObject userRequestBody() {
        JSONObject userRequest = new JSONObject();
        String userName = "user" + this.randomId(); //user1231

        userRequest.put("id", this.randomId());
        userRequest.put("username", userName);
        userRequest.put("firstName", "user");
        userRequest.put("lastName", "zero");
        userRequest.put("email", userName + "@zero.com");
        userRequest.put("password", "zero000");
        userRequest.put("phone", "+905426928600");
        userRequest.put("userStatus", 1);
        return userRequest;
    }

    public JSONObject orderRequestBody() {
        JSONObject orderRequestBody = new JSONObject();
        orderRequestBody.put("id", 1000);
        orderRequestBody.put("petId", 1001);
        return orderRequestBody;
    }

    public int randomId() {
        Random random = new Random();
        int randomId = random.nextInt(9999 - 1000 + 1) + 1000;
        return randomId;
    }


}
