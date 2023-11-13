package use_case.choose_recipe;

import entity.RecipeInformation;
import use_case.recipe_search.RecipeSearchOutputData;

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
        List<List<String>> recipeIdeasList = chooseRecipeDataAccessObject.getRecipeDetails(chooseRecipeInputData);
        System.out.println("got to the interactor.java");

        ChooseRecipeOutputData chooseRecipeOutputData = new ChooseRecipeOutputData();
        chooseRecipePresenter.prepareRecipeDetailsView(chooseRecipeOutputData);

    }
}
