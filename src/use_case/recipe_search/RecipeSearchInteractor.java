package use_case.recipe_search;

public class RecipeSearchInteractor implements RecipeSearchInputBoundary{

    final RecipeSearchDataAccessInterface recipeSearchDataAccessObject;

    final RecipeSearchOutputBoundary recipeSearchPresenter;

    public RecipeSearchInteractor(RecipeSearchDataAccessInterface recipeSearchDataAccessObject, RecipeSearchOutputBoundary recipeSearchPresenter) {
        this.recipeSearchDataAccessObject = recipeSearchDataAccessObject;
        this.recipeSearchPresenter = recipeSearchPresenter;
    }

    @Override
    public void execute(RecipeSearchInputData searchInputData) {
        // execute use case
        recipeSearchDataAccessObject.getRecipeIdeas(searchInputData);

        // call presenter with output data
        RecipeSearchOutputData recipeSearchOutputData = new RecipeSearchOutputData(); // create actual output data
        recipeSearchPresenter.prepareChooseRecipeView(recipeSearchOutputData);

        // if no recipes are found, this will be displayed to the user
        recipeSearchPresenter.prepareNoRecipeFoundView();

    }

}
