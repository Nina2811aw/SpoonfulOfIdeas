package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import view.ChooseRecipeView;

public class RecipeViewUseCaseFactory {

    public static ChooseRecipeView create(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel){
        return new ChooseRecipeView(); // delete this line, might want to remove static later
    }
}
