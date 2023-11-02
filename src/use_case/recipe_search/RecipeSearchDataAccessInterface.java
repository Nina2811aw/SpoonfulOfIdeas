package use_case.recipe_search;

import entity.RecipeInformation;

import java.util.List;

public interface RecipeSearchDataAccessInterface {
    List<RecipeInformation> getRecipeIdeas(RecipeSearchInputData recipeSearchInputData);

}
