package interface_adapter.recipe_search;

import use_case.recipe_search.RecipeSearchOutputBoundary;
import use_case.recipe_search.RecipeSearchOutputData;

public class RecipeSearchPresenter implements  RecipeSearchOutputBoundary{

    // this method is called when recipe ideas have been found
    @Override
    public void prepareChooseRecipeView(RecipeSearchOutputData recipeSearchOutputData) {

    }

    // this method is called when no recipe ideas have been found
    @Override
    public void prepareNoRecipeFoundView() {

    }
    // need this to return RecipeSearchOutputBoundry Type


}
