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
        // create input data object and call interactor
        RecipeSearchInputData recipeSearchInputData = null; // has to be replaced by actual input data
        this.recipeSearchInteractor.execute(recipeSearchInputData);
    }
}
