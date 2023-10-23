package interface_adapter.recipe_search;

import use_case.recipe_search.RecipeSearchInputBoundary;
import use_case.recipe_search.RecipeSearchInputData;

public class RecipeSearchController {

    final RecipeSearchInputBoundary recipeSearchInteractor;


    public RecipeSearchController(RecipeSearchInputBoundary recipeSearchInteractor) {
        this.recipeSearchInteractor = recipeSearchInteractor;
    }

    public void execute(){
        RecipeSearchInputData recipeSearchInputData = null; // has to be replaced by actual input data
        this.recipeSearchInteractor.execute(recipeSearchInputData);
    }
}
