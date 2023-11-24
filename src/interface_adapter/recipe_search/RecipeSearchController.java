package interface_adapter.recipe_search;

import use_case.recipe_search.RecipeSearchInputBoundary;
import use_case.recipe_search.RecipeSearchInputData;

import java.util.ArrayList;
import java.util.Map;

public class RecipeSearchController {

    final RecipeSearchInputBoundary recipeSearchInteractor;


    public RecipeSearchController(RecipeSearchInputBoundary recipeSearchInteractor) {
        this.recipeSearchInteractor = recipeSearchInteractor;
    }

    // the parameters of this method have to be adapted depending on how the
    // input data from the user is gathered
    public void execute(ArrayList<String> ingredients, Map<String, Boolean> diets, Map<String, Boolean> intolerances, String cuisine, String protein, String fat, String carbs, String calories){

        int minProtein = 0;
        int maxProtein = 0;
        int minFat = 0;
        int maxFat = 0;
        int minCarbs = 0;
        int maxCarbs = 0;
        int minCalories = 0;
        int maxCalories = 0;

        String dietsString = "";
        String intolerancesString = "";

        boolean dietChosen = false;
        for(Boolean checked : diets.values()){
            if (checked) {
                dietChosen = true;
                break;
            }
        }

        boolean intoleranceChosen = false;
        for(Boolean checked : intolerances.values()){
            if(checked){
                intoleranceChosen = true;
                break;
            }
        }

        if(dietChosen){
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
            dietsString = new String(userDiets);
        }

        if(intoleranceChosen){
            StringBuilder userIntolerances = new StringBuilder();
            boolean firstIntoleranceAppended = false;
            for(String intolerance : intolerances.keySet()){
                if(intolerances.get(intolerance)){
                    if (!firstIntoleranceAppended){
                        userIntolerances.append(intolerance);
                        firstIntoleranceAppended = true;
                    } else{
                        userIntolerances.append(",");
                        userIntolerances.append(intolerance);
                    }
                }
            }
            intolerancesString = new String(userIntolerances);
        }

        switch(protein) {
            case "high protein":
                minProtein = 20;
                maxProtein = 100;
                break;
            case "low protein":
                maxProtein = 40;
                break;
            default:
                maxProtein = 100;
        }

        switch (fat){
            case "high fat":
                minFat = 30;
                maxFat = 100;
                break;
            case "low fat":
                maxFat = 35;
                break;
            default:
                maxFat = 100;
        }

        switch (carbs){
            case "high carbs":
                minCarbs = 50;
                maxCarbs = 200;
                break;
            case "low carbs":
                maxCarbs = 80;
                break;
            default:
                maxCarbs = 200;
        }

        switch (calories){
            case "high calorie":
                minCalories = 700;
                maxCalories = 2000;
                break;
            case "low calorie":
                maxCalories = 700;
                break;
            default:
                maxCalories = 2000;

        }

        RecipeSearchInputData recipeSearchInputData = new RecipeSearchInputData(ingredients, dietsString, cuisine, intolerancesString, minProtein, maxProtein, minFat, maxFat, minCarbs, maxCarbs, minCalories, maxCalories); // has to be replaced by actual input data
        this.recipeSearchInteractor.execute(recipeSearchInputData);
    }
}
