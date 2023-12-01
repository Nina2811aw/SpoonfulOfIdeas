package use_case.choose_recipe;

import entity.RecipeInformation;
import use_case.recipe_search.RecipeSearchOutputData;

import java.util.ArrayList;
import java.util.List;

public class ChooseRecipeInteractor implements ChooseRecipeInputBoundary{

    final ChooseRecipeDataAccessInterface chooseRecipeDataAccessObject;

    final ChooseRecipeOutputBoundary chooseRecipePresenter;


    public ChooseRecipeInteractor(ChooseRecipeDataAccessInterface chooseRecipeDataAccessObject, ChooseRecipeOutputBoundary chooseRecipePresenter) {
        this.chooseRecipeDataAccessObject = chooseRecipeDataAccessObject;
        this.chooseRecipePresenter = chooseRecipePresenter;
    }

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
