package interface_adapter.recipe_search;

import interface_adapter.ViewManagerModel;
import use_case.recipe_search.RecipeSearchOutputBoundary;
import use_case.recipe_search.RecipeSearchOutputData;
import interface_adapter.recipe_search.RecipeSearchViewModel;

public class RecipeSearchPresenter implements  RecipeSearchOutputBoundary{

    private final RecipeSearchViewModel recipeSearchViewModel;

    private ViewManagerModel viewManagerModel;

    public RecipeSearchPresenter(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel){
        this.viewManagerModel = viewManagerModel;
        this.recipeSearchViewModel = recipeSearchViewModel;
    }



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
