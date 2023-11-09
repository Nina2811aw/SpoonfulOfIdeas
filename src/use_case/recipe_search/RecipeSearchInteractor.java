package use_case.recipe_search;

import entity.RecipeInformation;
import use_case.choose_recipe.ChooseRecipeInputData;

import java.util.List;

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
        List<RecipeInformation> recipeIdeasList = recipeSearchDataAccessObject.getRecipeIdeas(searchInputData);

        for(RecipeInformation recipe : recipeIdeasList){
            System.out.println(recipe.getID() + " : " + recipe.getTitle());
        }

        // if no recipes are found, this will be displayed to the user
        if(recipeIdeasList.isEmpty()){
            recipeSearchPresenter.prepareNoRecipeFoundView();
        }
        // call presenter with output data
        RecipeSearchOutputData recipeSearchOutputData = new RecipeSearchOutputData(recipeIdeasList);
        //ChooseRecipeInputData chooseRecipeInputData = new ChooseRecipeInputData(recipeIdeasList);
        recipeSearchPresenter.prepareChooseRecipeView(recipeSearchOutputData);

    }

}
