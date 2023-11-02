package use_case.recipe_search;

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
        List<Integer> recipeIdeasIDList = recipeSearchDataAccessObject.getRecipeIdeas(searchInputData);

        for(Integer id : recipeIdeasIDList){
            System.out.println(id);
        }

        // if no recipes are found, this will be displayed to the user
        if(recipeIdeasIDList.isEmpty()){
            recipeSearchPresenter.prepareNoRecipeFoundView();
        }
        // call presenter with output data
        RecipeSearchOutputData recipeSearchOutputData = new RecipeSearchOutputData(recipeIdeasIDList);
        recipeSearchPresenter.prepareChooseRecipeView(recipeSearchOutputData);

    }

}
