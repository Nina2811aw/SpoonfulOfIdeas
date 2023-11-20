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
    public List<List<String>> getRecipeDetails(ChooseRecipeInputData chooseRecipeInputData)     {
        List<List<String>> info_list = new ArrayList<>();
        //[['id', 'title', 'instructions'],['id', 'url', 'instructions']]
        //going to add more details depending on what we need later


        String API_TOKEN = "47e1335f069c4ff1b2fbb1ea17cf2179";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String id = String.valueOf(chooseRecipeInputData.recipe);
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
            List<String> inner_lst = new ArrayList<>();


                // Adding id to nested list [0]
            inner_lst.add(id);

                // Adding title to nested list [1]
            inner_lst.add(responseBody.get("title").toString());

                // Adding Instructions to the list [2]
            inner_lst.add(responseBody.get("instructions").toString());
            info_list.add(inner_lst);

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);}

        return info_list;
    }
    public List<List<String>> RecipeNutritionLabelBuilder(ChooseRecipeInputData chooseRecipeInputData) {
        List<List<String>> info_list = new ArrayList<>();

        //[['id', 'url'],['id', 'url']]


        String id = String.valueOf(chooseRecipeInputData.recipe);
        List<String> inner_lst = new ArrayList<>();
            // Adding id to nested list [0]
        inner_lst.add(id);

            // Adding image url to nested list [1]
        String url = "https://api.spoonacular.com/recipes/" + id + "/nutritionLabel.png";
        inner_lst.add(url);
        info_list.add(inner_lst);

        return info_list;
    }


    @Override
    public String getFoodJoke() {

        String joke = "";
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        final String url = "https://api.spoonacular.com/food/jokes/random";
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
        return null;

    }
}
