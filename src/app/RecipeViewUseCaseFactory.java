package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import view.ChooseRecipeView;
import view.RecipeSearchView;

public class RecipeViewUseCaseFactory {

    public static RecipeSearchView create(ViewManagerModel viewManagerModel, RecipeSearchViewModel chooseRecipeViewModel){
        return new RecipeSearchView(); // delete this line, might want to remove static later
    }
}
