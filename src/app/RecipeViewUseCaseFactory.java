package app;

import data_access.SpoonacularDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipePresenter;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.recipe_search.RecipeSearchController;
import interface_adapter.recipe_search.RecipeSearchPresenter;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import use_case.choose_recipe.ChooseRecipeInputBoundary;
import use_case.choose_recipe.ChooseRecipeInteractor;
import use_case.choose_recipe.ChooseRecipeOutputBoundary;
import use_case.recipe_search.RecipeSearchDataAccessInterface;
import use_case.recipe_search.RecipeSearchInputBoundary;
import use_case.recipe_search.RecipeSearchInteractor;
import use_case.recipe_search.RecipeSearchOutputBoundary;
import view.ChooseRecipeView;
import view.RecipeSearchView;

public class RecipeViewUseCaseFactory {


    public static RecipeSearchView createSearchView(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel, ChooseRecipeViewModel chooseRecipeViewModel){
        RecipeSearchController recipeSearchController = createSearchCase(viewManagerModel, recipeSearchViewModel, chooseRecipeViewModel);
        return new RecipeSearchView(recipeSearchController,recipeSearchViewModel); // delete this line, might want to remove static later

    }


    public static RecipeSearchController createSearchCase(ViewManagerModel viewManagerModel,RecipeSearchViewModel recipeSearchViewModel, ChooseRecipeViewModel chooseRecipeViewModel){
        //throws IOException?
        RecipeSearchOutputBoundary recipeSearchPresenter = new RecipeSearchPresenter(viewManagerModel, recipeSearchViewModel, chooseRecipeViewModel);

        RecipeSearchDataAccessInterface spoonacularDataAccessObject = new SpoonacularDataAccessObject();

        RecipeSearchInputBoundary recipeSearchInputBoundary = new RecipeSearchInteractor(spoonacularDataAccessObject, recipeSearchPresenter); // null has to be replaced by actual objects

        return new RecipeSearchController(recipeSearchInputBoundary);
    }

    public static ChooseRecipeView createChooseView(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel){
        ChooseRecipeController chooseRecipeController = createChooseCase(viewManagerModel, chooseRecipeViewModel);
        return new ChooseRecipeView(chooseRecipeController, chooseRecipeViewModel);
    }
    public static ChooseRecipeController createChooseCase(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel){
        ChooseRecipeOutputBoundary chooseRecipeOutputBoundary = new ChooseRecipePresenter(viewManagerModel, chooseRecipeViewModel);

        ChooseRecipeInputBoundary chooseRecipeInteractor = new ChooseRecipeInteractor(null, null);

        return new ChooseRecipeController(chooseRecipeInteractor);


    }


}