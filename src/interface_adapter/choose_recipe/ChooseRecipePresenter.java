package interface_adapter.choose_recipe;

import interface_adapter.ViewManagerModel;
import use_case.choose_recipe.ChooseRecipeOutputBoundary;
import use_case.choose_recipe.ChooseRecipeOutputData;


public class ChooseRecipePresenter implements ChooseRecipeOutputBoundary {
    private ViewManagerModel viewManagerModel;

    private final ChooseRecipeViewModel chooseRecipeViewModel;

    public ChooseRecipePresenter(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel){
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareRecipeDetailsView(ChooseRecipeOutputData chooseRecipeOutputData) {


    }
}
