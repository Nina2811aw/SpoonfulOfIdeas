package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Main {
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static void main(String[] args) {
        getNumberOfRecipes();
    }

    public static void getNumberOfRecipes() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spoonacular.com/recipes/complexSearch?query=pasta&number=5")
                .addHeader("x-api-key", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray responseArray = responseBody.getJSONArray("results");
            System.out.println("Ideas for recipes with pasta:");
            for(int i = 0; i < responseArray.length(); i++){
                JSONObject currentObject = responseArray.getJSONObject(i);
                System.out.println(currentObject.get("title"));
            }

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}