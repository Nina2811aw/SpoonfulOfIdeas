package use_case.choose_recipe;

public interface ChooseRecipeOutputBoundary {

    /**
     * The choose-recipe use case will always have a valid success view to present,
     * utilizing the recipe data given by Spoonacular. All we require is the
     * presenter to implement a valid success view using this data.
     * @param chooseRecipeOutputData the output data containing recipe details
     */
    void prepareRecipeDetailsSuccessView(ChooseRecipeOutputData chooseRecipeOutputData);
}
