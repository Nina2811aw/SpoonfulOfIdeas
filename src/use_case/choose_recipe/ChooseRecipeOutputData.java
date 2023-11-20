package use_case.choose_recipe;

import entity.RecipeInformation;

import java.util.List;

public class ChooseRecipeOutputData {
    public ChooseRecipeOutputData(List<String> recipeDetails) {
        this.recipeDetails = recipeDetails;
    }

    List<String> recipeDetails;

    public List<String> getRecipeDetails() {return this.recipeDetails;
    }
}
