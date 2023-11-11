package use_case.choose_recipe;

import entity.RecipeInformation;
import interface_adapter.choose_recipe.ChooseRecipePresenter;

import java.util.ArrayList;
import java.util.List;

public class ChooseRecipeInputData {
    public ArrayList<Integer> recipeId;

    public List<RecipeInformation> recipes;

    public ChooseRecipeInputData(List<RecipeInformation> recipes) {
        this.recipes = recipes;
    }

    public RecipeInformation getrecipe1() {
        if (recipes.isEmpty()) {
            System.out.println("no recipies found");
        }
        return recipes.get(0);

    }
}
