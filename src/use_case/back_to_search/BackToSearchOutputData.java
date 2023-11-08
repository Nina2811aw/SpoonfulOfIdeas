package use_case.back_to_search;

import use_case.recipe_search.RecipeSearchInputData;

public class BackToSearchOutputData extends RecipeSearchInputData {

    public BackToSearchOutputData(String ingredients, String diets, String cuisine, String intolerances, int minProtein,
                                  int maxProtein, int minFat, int maxFat, int minCarbs, int maxCarbs, int minCalories, int maxCalories){

        // call the constructor RecipeSearchInputData as BackToSearchOutputData works equivalently to it.
        super(ingredients, diets, cuisine, intolerances, minProtein, maxProtein, minFat,
                maxFat, minCarbs, maxCarbs, minCalories, maxCalories);
    }
}
