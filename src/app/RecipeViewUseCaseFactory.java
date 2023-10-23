package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_search.RecipeSearchController;
import interface_adapter.recipe_search.RecipeSearchPresenter;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import use_case.recipe_search.RecipeSearchInputBoundary;
import use_case.recipe_search.RecipeSearchInteractor;
import use_case.recipe_search.RecipeSearchOutputBoundary;
import view.RecipeSearchView;

public class RecipeViewUseCaseFactory {

    public static RecipeSearchView create(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel){
        RecipeSearchController recipeSearchController = createSearchCase(viewManagerModel, recipeSearchViewModel);
        return new RecipeSearchView(recipeSearchController,recipeSearchViewModel); // delete this line, might want to remove static later

    }

    public static RecipeSearchController createSearchCase(ViewManagerModel viewManagerModel,RecipeSearchViewModel recipeSearchViewModel){
        //throws IOException?
        RecipeSearchOutputBoundary recipeSearchOutputBoundary = new RecipeSearchPresenter();

        RecipeSearchInputBoundary recipeSearchInputBoundary = new RecipeSearchInteractor();

        return new RecipeSearchController(recipeSearchInputBoundary);
    }
}
