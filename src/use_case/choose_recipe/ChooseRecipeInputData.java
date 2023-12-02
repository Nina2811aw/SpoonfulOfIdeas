package use_case.choose_recipe;

import entity.RecipeInformation;
import interface_adapter.choose_recipe.ChooseRecipePresenter;

import java.util.ArrayList;
import java.util.List;

public class ChooseRecipeInputData {

    public RecipeInformation recipe;

    /**
     * Constructs a ChooseRecipeInputData object with the specified RecipeInformation entity.
     * @param recipe the RecipeInformation object containing the details (recipeId, recipeName) of the recipe
     */
    public ChooseRecipeInputData(RecipeInformation recipe) {
        this.recipe = recipe;
    }

    /**
     * Gets the recipe information.
     * @return the in-class-object-stored RecipeInformation object
     */
    public RecipeInformation getrecipe() {return recipe;}

}
