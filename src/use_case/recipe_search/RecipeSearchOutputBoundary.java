package use_case.recipe_search;

public interface RecipeSearchOutputBoundary {

    void prepareChooseRecipeView(RecipeSearchOutputData recipeSearchOutputData);

    void prepareNoRecipeFoundView();


}
