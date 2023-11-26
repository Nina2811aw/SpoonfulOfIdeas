package app;

import data_access.FavouritesDataAccessObject;
import data_access.SpoonacularDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.back_to_search.BackToSearchController;
import interface_adapter.back_to_search.BackToSearchPresenter;
import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipePresenter;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.food_joke.FoodJokeController;
import interface_adapter.food_joke.FoodJokePresenter;
import interface_adapter.food_joke.FoodJokeViewModel;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import interface_adapter.recipe_search.RecipeSearchController;
import interface_adapter.recipe_search.RecipeSearchPresenter;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import interface_adapter.show_favourites.ShowFavouritesController;
import use_case.back_to_search.BackToSearchInteractor;
import use_case.back_to_search.BackToSearchOutputBoundary;
import use_case.choose_recipe.ChooseRecipeDataAccessInterface;
import use_case.choose_recipe.ChooseRecipeInputBoundary;
import use_case.choose_recipe.ChooseRecipeInteractor;
import use_case.choose_recipe.ChooseRecipeOutputBoundary;
import use_case.food_joke.FoodJokeDataAccessInterface;
import use_case.food_joke.FoodJokeInputBoundary;
import use_case.food_joke.FoodJokeInteractor;
import use_case.food_joke.FoodJokeOutputBoundary;
import use_case.recipe_search.RecipeSearchDataAccessInterface;
import use_case.recipe_search.RecipeSearchInputBoundary;
import use_case.recipe_search.RecipeSearchInteractor;
import use_case.recipe_search.RecipeSearchOutputBoundary;
import use_case.show_favourites.ShowFavouritesDataAccessInterface;
import use_case.show_favourites.ShowFavouritesInputBoundary;
import use_case.show_favourites.ShowFavouritesInteractor;
import view.ChooseRecipeView;
import view.RecipeSearchView;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.List;

public class RecipeViewUseCaseFactory {

    public static RecipeSearchView createSearchView(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel, ChooseRecipeViewModel chooseRecipeViewModel,
                                                    FoodJokeViewModel foodJokeViewModel, FavouritesDataAccessObject favouritesDataAccessObject){
        RecipeSearchController recipeSearchController = createSearchCase(viewManagerModel, recipeSearchViewModel, chooseRecipeViewModel);
        FoodJokeController foodJokeController = createFoodJokeCase(foodJokeViewModel);
        ShowFavouritesController showFavouritesController = createShowFavouritesCase(viewManagerModel, recipeSearchViewModel, chooseRecipeViewModel, favouritesDataAccessObject);
        return new RecipeSearchView(recipeSearchController,recipeSearchViewModel, foodJokeController, foodJokeViewModel, showFavouritesController); // delete this line, might want to remove static later

    }

    public static RecipeSearchController createSearchCase(ViewManagerModel viewManagerModel,RecipeSearchViewModel recipeSearchViewModel, ChooseRecipeViewModel chooseRecipeViewModel){
        //throws IOException?
        RecipeSearchOutputBoundary recipeSearchPresenter = new RecipeSearchPresenter(viewManagerModel, recipeSearchViewModel, chooseRecipeViewModel);

        RecipeSearchDataAccessInterface spoonacularDataAccessObject = new SpoonacularDataAccessObject();

        RecipeSearchInputBoundary recipeSearchInputBoundary = new RecipeSearchInteractor(spoonacularDataAccessObject, recipeSearchPresenter); // null has to be replaced by actual objects

        return new RecipeSearchController(recipeSearchInputBoundary);
    }

    // Creates and configures a ShowFavouritesController for handling the transition from the transition from RecipeSearchView
    // to ChooseRecipeView showcasing the user's list of favourited items.
    public static ShowFavouritesController createShowFavouritesCase(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel, ChooseRecipeViewModel chooseRecipeViewModel,
                                           FavouritesDataAccessObject favouritesDataAccessObject){
        RecipeSearchOutputBoundary recipeSearchPresenter = new RecipeSearchPresenter(viewManagerModel, recipeSearchViewModel, chooseRecipeViewModel);
        ShowFavouritesInputBoundary showFavouritesInteractor = new ShowFavouritesInteractor(favouritesDataAccessObject, recipeSearchPresenter);
        return new ShowFavouritesController(showFavouritesInteractor);
    }

    public static ChooseRecipeView createChooseView(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel, ChooseRecipeViewModel chooseRecipeViewModel, NutritionDetailViewModel nutritionDetailViewModel){
        ChooseRecipeController chooseRecipeController = createChooseCase(viewManagerModel, chooseRecipeViewModel, nutritionDetailViewModel);
        BackToSearchController backToSearchController = createBackToSearchUseCase(viewManagerModel, recipeSearchViewModel);
        return new ChooseRecipeView(chooseRecipeController, backToSearchController, chooseRecipeViewModel);
    }


    public static ChooseRecipeController createChooseCase(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel, NutritionDetailViewModel nutritionDetailViewModel){
        ChooseRecipeOutputBoundary chooseRecipePresenter = new ChooseRecipePresenter(viewManagerModel, chooseRecipeViewModel, nutritionDetailViewModel);

        ChooseRecipeDataAccessInterface spoonacularDataAccessObject = new SpoonacularDataAccessObject();

        ChooseRecipeInputBoundary chooseRecipeInputBoundary = new ChooseRecipeInteractor(spoonacularDataAccessObject, chooseRecipePresenter);

        return new ChooseRecipeController(chooseRecipeInputBoundary);


    }

    public static FoodJokeController createFoodJokeCase(FoodJokeViewModel foodJokeViewModel){
        FoodJokeOutputBoundary foodJokePresenter = new FoodJokePresenter(foodJokeViewModel);

        FoodJokeDataAccessInterface spoonacularDataAccessObject = new SpoonacularDataAccessObject();

        FoodJokeInputBoundary foodJokeInteractor = new FoodJokeInteractor(spoonacularDataAccessObject, foodJokePresenter);

        return new FoodJokeController(foodJokeInteractor);
    }

    // Creates and configures a BackToSearchController for handling the transition from the ChooseRecipe view back to the RecipeSearch view.
    public static BackToSearchController createBackToSearchUseCase(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel){
        BackToSearchOutputBoundary backToSearchPresenter = new BackToSearchPresenter(viewManagerModel, recipeSearchViewModel);
        BackToSearchInteractor backToSearchInteractor = new BackToSearchInteractor(backToSearchPresenter);
        return new BackToSearchController(backToSearchInteractor);
    }


}