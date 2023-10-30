package data_access;

import use_case.choose_recipe.ChooseRecipeDataAccessInterface;
import use_case.choose_recipe.ChooseRecipeInputData;
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

public class SpoonacularDataAccessObject implements RecipeSearchDataAccessInterface, ChooseRecipeDataAccessInterface {
    @Override
    public void getRecipeIdeas(RecipeSearchInputData recipeSearchInputData) {

    }

    @Override
    public List<List<String>> getRecipeDetails(ChooseRecipeInputData chooseRecipeInputData)     {
        List<List<String>> info_list = new ArrayList<>();

        String API_TOKEN = "47e1335f069c4ff1b2fbb1ea17cf2179";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        for (int i = 0; i < chooseRecipeInputData.recipeId.size(); i++) {
            String id = String.valueOf(chooseRecipeInputData.recipeId.get(i));
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
                throw new RuntimeException(e);
            }
        }
        return info_list;
    }
    public List<List<String>> RrecipeNutritionLabelBuilder(ChooseRecipeInputData chooseRecipeInputData) {
        for (int i = 0; i < chooseRecipeInputData.recipeId.size(); i++) {
            String id = String.valueOf(chooseRecipeInputData.recipeId.get(i));
            String url = "https://api.spoonacular.com/recipes/" + id + "/nutritionLabel.png";
            label_list.add(url);
        }
    }


}
