package interface_adapter.back_to_search;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import use_case.back_to_search.BackToSearchOutputBoundary;

public class BackToSearchPresenter implements BackToSearchOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final RecipeSearchViewModel recipeSearchViewModel;

    public BackToSearchPresenter(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel){
        this.viewManagerModel = viewManagerModel;
        this.recipeSearchViewModel = recipeSearchViewModel;
    }

    @Override
    public void prepareRecipeSearchView() {

        System.out.println("prepare recipe search view from back to search presenter");
        viewManagerModel.setActiveView(recipeSearchViewModel.getViewName());
        System.out.println("active view: "+ viewManagerModel.getActiveView());
        viewManagerModel.firePropertyChanged();
    }
}
