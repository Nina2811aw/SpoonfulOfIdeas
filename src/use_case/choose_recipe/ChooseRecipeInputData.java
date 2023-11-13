package use_case.choose_recipe;

import entity.RecipeInformation;
import interface_adapter.choose_recipe.ChooseRecipePresenter;

import java.util.ArrayList;
import java.util.List;

public class ChooseRecipeInputData {

    public RecipeInformation recipe;

    public ChooseRecipeInputData(RecipeInformation recipe) {
        this.recipe = recipe;
    }

    public RecipeInformation getrecipe() {return recipe;}
}
