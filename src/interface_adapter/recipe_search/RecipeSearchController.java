package interface_adapter.recipe_search;

import use_case.recipe_search.RecipeSearchInputBoundary;
import use_case.recipe_search.RecipeSearchInputData;

import java.util.Map;

public class RecipeSearchController {

    final RecipeSearchInputBoundary recipeSearchInteractor;


    public RecipeSearchController(RecipeSearchInputBoundary recipeSearchInteractor) {
        this.recipeSearchInteractor = recipeSearchInteractor;
    }

    // the parameters of this method have to be adapted depending on how the
    // input data from the user is gathered
    public void execute(String ingredients, Map<String, Boolean> diets, Map<String, Boolean> intolerances, String cuisine, String protein, String fat, String carbs, String calories){

        int minProtein = 0;
        int maxProtein = 0;
        int minFat = 0;
        int maxFat = 0;
        int minCarbs = 0;
        int maxCarbs = 0;
        int minCalories = 0;
        int maxCalories = 0;

        StringBuilder userDiets = new StringBuilder();
        boolean firstDietAppended = false;
        for(String diet : diets.keySet()){
            if(diets.get(diet)){
                if (!firstDietAppended){
                    userDiets.append(diet);
                    firstDietAppended = true;
                } else{
                    userDiets.append(",");
                    userDiets.append(diet);
                }
            }
        }
        String dietsString = new String(userDiets);

        StringBuilder userIntolerances = new StringBuilder();
        boolean firstIntoleranceAppended = false;
        for(String intolerance : intolerances.keySet()){
            if(diets.get(intolerance)){
                if (!firstIntoleranceAppended){
                    userIntolerances.append(intolerance);
                    firstIntoleranceAppended = true;
                } else{
                    userDiets.append(",");
                    userIntolerances.append(intolerance);
                }
            }
        }
        String intolerancesString = new String(userIntolerances);

        switch(protein) {
            case "high protein":
                minProtein = 50;
                break;
            case "low protein":
                maxProtein = 50;
                break;
            default:
        }

        switch (fat){
            case "high fat":
                minFat = 50;
                break;
            case "low fat":
                maxFat = 50;
                break;
            default:
        }

        switch (carbs){
            case "high carbs":
                minCarbs = 50;
                break;
            case "low carbs":
                maxCarbs = 50;
                break;
            default:
        }

        switch (calories){
            case "high calorie":
                minCalories = 500;
                break;
            case "low calorie":
                maxCalories = 500;
                break;
            default:
        }

        RecipeSearchInputData recipeSearchInputData = new RecipeSearchInputData(ingredients, dietsString, cuisine, intolerancesString, minProtein, maxProtein, minFat, maxFat, minCarbs, maxCarbs, minCalories, maxCalories); // has to be replaced by actual input data
        this.recipeSearchInteractor.execute(recipeSearchInputData);
    }
}
