package use_case.back_to_search;

import entity.RecipeSpec;
import use_case.recipe_search.RecipeSearchInputData;

public interface BackToSearchDataAccessInterface {

    // for BackToSearch use case interactor to access user specifications.
    RecipeSpec getSpecification();

    // for SearchRecipe use case interactor to set user specifications input data into entity object.
    void setSpecification(RecipeSearchInputData recipeSearchInputData);
}
