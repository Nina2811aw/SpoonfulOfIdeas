package interface_adapter.back_to_search;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import use_case.back_to_search.BackToSearchOutputBoundary;

public class BackToSearchPresenter implements BackToSearchOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final RecipeSearchViewModel recipeSearchViewModel;

    /**
     * Constructor sets up presenter so that it can update the view.
     *
     * @param viewManagerModel should contain the core viewManager used in the program.
     * @param recipeSearchViewModel should contain the core viewManager used in the program.
     */
    public BackToSearchPresenter(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel){
        this.viewManagerModel = viewManagerModel;
        this.recipeSearchViewModel = recipeSearchViewModel;
    }

    // Presenter switches from current view to the Search view.
    @Override
    public void prepareRecipeSearchView() {
        System.out.println("prepare recipe search view from back to search presenter");
        viewManagerModel.setActiveView(recipeSearchViewModel.getViewName());
        System.out.println("active view: "+ viewManagerModel.getActiveView());
        viewManagerModel.firePropertyChanged();
    }
}
