package use_case.choose_recipe;

import entity.RecipeInformation;
import interface_adapter.choose_recipe.ChooseRecipePresenter;

import java.util.ArrayList;
import java.util.List;

public class ChooseRecipeInputData {
    private final List<RecipeInformation> recipies;
    public ArrayList<Integer> recipeId;

    public ChooseRecipeInputData(List<RecipeInformation> recipes) {
        this.recipies = recipes;
    }

    public RecipeInformation getrecipe1() {
        if (recipies.isEmpty()) {
            System.out.println("no recipies found");
        }
        return recipies.get(0);

    }
}
