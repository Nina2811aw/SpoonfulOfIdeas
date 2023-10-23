package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Main {
private static final String API_TOKEN = "47e1335f069c4ff1b2fbb1ea17cf2179";

    public static void main(String[] args) {
        List<Integer> idList = new ArrayList<>();
        
        
        //INCLUDE ONLY RECIEPES WITH INSTRUCTION
        idList.add(4632);
        getReciepeInformation(idList);

    }

    public static void getReciepeInformation(List<Integer> recipeInformation) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        for(int i = 0; i < recipeInformation.size(); i++){
            String id = String.valueOf(recipeInformation.get(i));
            String url = "https://api.spoonacular.com/recipes/" + id + "/information?includeNutrition=false";
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("x-api-key", API_TOKEN)
                    .addHeader("Content-Type", "application/json")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                assert response.body() != null;
                JSONObject responseBody = new JSONObject(response.body().string());


                System.out.println(responseBody.get("title").toString());
                System.out.println("Cooking Time: " + responseBody.get("title").toString() + " min");
                System.out.println(responseBody.get("instructions").toString());

            } catch (IOException | JSONException e) {
                throw new RuntimeException(e);
            }
        }


    }



}
