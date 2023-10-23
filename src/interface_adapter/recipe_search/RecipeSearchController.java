package interface_adapter.recipe_search;

import use_case.recipe_search.RecipeSearchInputBoundary;

public class RecipeSearchController {

    final RecipeSearchInputBoundary recipeSearchInteractor;


    public RecipeSearchController(RecipeSearchInputBoundary recipeSearchInteractor) {
        this.recipeSearchInteractor = recipeSearchInteractor;
    }
}
