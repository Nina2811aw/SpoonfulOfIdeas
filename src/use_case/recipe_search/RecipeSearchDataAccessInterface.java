package use_case.recipe_search;

import java.util.List;

public interface RecipeSearchDataAccessInterface {
    List<Integer> getRecipeIdeas(RecipeSearchInputData recipeSearchInputData);

}
