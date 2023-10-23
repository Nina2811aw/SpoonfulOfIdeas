package use_case.recipe_search;

public class RecipeSearchInteractor implements RecipeSearchInputBoundary{

    final RecipeSearchDataAccessInterface recipeSearchDataAccessObject;

    final RecipeSearchOutputBoundary recipeSearchPresenter;

    public RecipeSearchInteractor(RecipeSearchDataAccessInterface recipeSearchDataAccessObject, RecipeSearchOutputBoundary recipeSearchPresenter) {
        this.recipeSearchDataAccessObject = recipeSearchDataAccessObject;
        this.recipeSearchPresenter = recipeSearchPresenter;
    }

    final


    @Override
    public void execute(RecipeSearchInputData searchInputData) {

    }
    //needs to be
}
