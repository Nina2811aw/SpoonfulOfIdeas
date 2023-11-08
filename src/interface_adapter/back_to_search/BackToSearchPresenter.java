package interface_adapter.back_to_search;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.recipe_search.RecipeSearchState;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import use_case.back_to_search.BackToSearchOutputBoundary;
import use_case.back_to_search.BackToSearchOutputData;

public class BackToSearchPresenter implements BackToSearchOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final RecipeSearchViewModel recipeSearchViewModel;

    public BackToSearchPresenter(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel){
        this.viewManagerModel = viewManagerModel;
        this.recipeSearchViewModel = recipeSearchViewModel;
    }

    @Override
    public void prepareRecipeSearchView(BackToSearchOutputData previousSpecification) {

        System.out.println("prepare recipe search view from back to search presenter");
        // RecipeSearchState recipeSearchState = recipeSearchViewModel.getState();
        // might be useless. Need to verify that I don't actually have to update states.
        viewManagerModel.setActiveView(recipeSearchViewModel.getViewName());
        System.out.println("active view: "+ viewManagerModel.getActiveView());
        viewManagerModel.firePropertyChanged();
    }
}
