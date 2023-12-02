package use_case.choose_recipe;

import entity.RecipeInformation;
import use_case.recipe_search.RecipeSearchOutputData;

import java.util.ArrayList;
import java.util.List;

public class ChooseRecipeInteractor implements ChooseRecipeInputBoundary{

    final ChooseRecipeDataAccessInterface chooseRecipeDataAccessObject;

    final ChooseRecipeOutputBoundary chooseRecipePresenter;

    /**
     * Constructor sets up interactor so that it can access the presenter and the unifiedRecipeDAO.
     * @param chooseRecipeDataAccessObject the data access object for recipe details
     * @param chooseRecipePresenter the presenter for the choose recipe use case
     */
    public ChooseRecipeInteractor(ChooseRecipeDataAccessInterface chooseRecipeDataAccessObject, ChooseRecipeOutputBoundary chooseRecipePresenter) {
        this.chooseRecipeDataAccessObject = chooseRecipeDataAccessObject;
        this.chooseRecipePresenter = chooseRecipePresenter;
    }

    /**
     * Executes the choose recipe use case logic.
     * Retrieves recipe details based on input data, checks if the recipe is a favourite,
     * and prepares data for presenter so that the view can
     * correctly update from ChooseRecipeView to RecipeDetailsView
     *
     * @param chooseRecipeInputData the input data for choosing a recipe
     */
    @Override
    public void execute(ChooseRecipeInputData chooseRecipeInputData) {
        List<String> recipeDetailsList = chooseRecipeDataAccessObject.getRecipeDetails(chooseRecipeInputData);
        System.out.println("got to the interactor.java");

        System.out.println(recipeDetailsList.get(0) + " : " + recipeDetailsList.get(1));

        ChooseRecipeOutputData chooseRecipeOutputData = new ChooseRecipeOutputData(recipeDetailsList);
        chooseRecipeOutputData.setFavouriteFilled(chooseRecipeDataAccessObject.isFavourites(String.valueOf(chooseRecipeInputData.getrecipe().getID())));
        chooseRecipePresenter.prepareRecipeDetailsSuccessView(chooseRecipeOutputData);
    }
}
