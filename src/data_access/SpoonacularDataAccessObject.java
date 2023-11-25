package data_access;

import entity.RecipeInformation;
import org.json.JSONArray;
import use_case.back_to_choose.BackToChooseDataAccessInterface;
import use_case.choose_recipe.ChooseRecipeDataAccessInterface;
import use_case.choose_recipe.ChooseRecipeInputData;
import use_case.food_joke.FoodJokeDataAccessInterface;
import use_case.nutrition_detail.NutritionDetailDataAccessInterface;
import use_case.recipe_search.RecipeSearchDataAccessInterface;
import use_case.recipe_search.RecipeSearchInputData;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpoonacularDataAccessObject implements RecipeSearchDataAccessInterface, ChooseRecipeDataAccessInterface,
        BackToChooseDataAccessInterface, NutritionDetailDataAccessInterface, FoodJokeDataAccessInterface {

    private static String API_TOKEN = "47e1335f069c4ff1b2fbb1ea17cf2179";

    private List<RecipeInformation> recipeInformationList;
    @Override
    public List<RecipeInformation> getRecipeIdeas(RecipeSearchInputData recipeSearchInputData) {

        List<RecipeInformation> recipeList = new ArrayList<>();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        // getting the user information which specifies the complex search

        String ingredients = recipeSearchInputData.getIngredients();
        String diets = recipeSearchInputData.getDiets();
        String intolerances = recipeSearchInputData.getAllergies();
        String cuisine = recipeSearchInputData.getCuisines();
        int minProtein = recipeSearchInputData.getMinProtein();
        int maxProtein = recipeSearchInputData.getMaxProtein();
        int minFat = recipeSearchInputData.getMinFat();
        int maxFat = recipeSearchInputData.getMaxFat();
        int minCarbs = recipeSearchInputData.getMinCarbs();
        int maxCarbs = recipeSearchInputData.getMaxCarbs();
        int minCalories = recipeSearchInputData.getMinCalories();
        int maxCalories = recipeSearchInputData.getMaxCalories();

        String url = String.format("https://api.spoonacular.com/recipes/complexSearch?query=%s&diet=%s&intolerances=%s&cuisine=%s&minProtein=%d&maxProtein=%d&minFat=%d&maxFat=%d&minCarbs=%d&maxCarbs=%d&minCalories=%d&maxCalories=%d&number=10",ingredients, diets,intolerances,cuisine, minProtein, maxProtein, minFat, maxFat, minCarbs, maxCarbs, minCalories, maxCalories);

        Request request = new Request.Builder()
                .url(url)
                .addHeader("x-api-key", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray responseArray = responseBody.getJSONArray("results");
            for(int i = 0; i < responseArray.length(); i++){
                JSONObject currentObject = responseArray.getJSONObject(i);
                RecipeInformation recipeInformation = new RecipeInformation((Integer)currentObject.get("id"), (String)currentObject.get("title"));
                recipeList.add(recipeInformation);
            }

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
        this.recipeInformationList = recipeList;

        return recipeList;

    }

    public List<RecipeInformation> getRecipeInformationList(){return recipeInformationList;}

    @Override
    public List<String> getRecipeDetails(ChooseRecipeInputData chooseRecipeInputData)     {
        List<String> inner_lst = new ArrayList<>();
        //['id', 'title', 'instructions']
        //going to add more details depending on what we need later

        String API_TOKEN = "47e1335f069c4ff1b2fbb1ea17cf2179";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String id = String.valueOf(chooseRecipeInputData.getrecipe().getID());
        String url = "https://api.spoonacular.com/recipes/" + id + "/information?includeNutrition=false";
        Request request = new Request.Builder()
                .url(url)
                .addHeader("x-api-key", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            System.out.println(response);
            String responseBodyString =  response.body().string().trim();
            JSONObject responseBody;
            if (!responseBodyString.isEmpty()) {
                responseBody = new JSONObject(responseBodyString);
                // Process the JSON data
            } else {
                responseBody = null;
            }


            // Adding id to nested list [0]
            inner_lst.add(id);

            // Adding title to nested list [1]
            inner_lst.add(responseBody.get("title").toString());

            // Adding Instructions to the list [2]
            inner_lst.add(responseBody.get("instructions").toString());

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);}

        return inner_lst;
    }
    public static void displayNutritionLabelImage(String id) {
        String API_TOKEN = "47e1335f069c4ff1b2fbb1ea17cf2179";

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        String nutritionLabelUrl = "https://api.spoonacular.com/recipes/" + id + "/nutritionLabel.png";
        Request imageRequest = new Request.Builder()
                .url(nutritionLabelUrl)
                .addHeader("x-api-key", API_TOKEN)
                .build();

        try {
            Response imageResponse = client.newCall(imageRequest).execute();
            assert imageResponse.body() != null;

            ImageIcon imageIcon = new ImageIcon(imageResponse.body().bytes());
            JOptionPane.showMessageDialog(
                    null,
                    new JLabel(imageIcon),
                    "Nutrition Label for Recipe ID: " + id,
                    JOptionPane.PLAIN_MESSAGE,
                    null
            );

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching or displaying image", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    @Override
    public String getFoodJoke() {

        String joke = "";
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        final String url = "https://api.spoonacular.com/food/trivia/random";
        Request request = new Request.Builder()
                .url(url)
                .addHeader("x-api-key", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            joke = (String)responseBody.get("text");


        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
        return joke;

    }
}
