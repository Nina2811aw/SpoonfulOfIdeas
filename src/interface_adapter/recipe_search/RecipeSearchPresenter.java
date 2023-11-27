package interface_adapter.recipe_search;

import app.RecipeViewUseCaseFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import use_case.recipe_search.RecipeSearchOutputBoundary;
import use_case.recipe_search.RecipeSearchOutputData;
import view.ChooseRecipeView;
import view.RecipeSearchView;

import javax.swing.*;

public class RecipeSearchPresenter implements  RecipeSearchOutputBoundary{

    private final RecipeSearchViewModel recipeSearchViewModel;

    private final ChooseRecipeViewModel chooseRecipeViewModel;

    private ViewManagerModel viewManagerModel;

    public RecipeSearchPresenter(ViewManagerModel viewManagerModel, RecipeSearchViewModel recipeSearchViewModel, ChooseRecipeViewModel chooseRecipeViewModel){
        this.viewManagerModel = viewManagerModel;
        this.recipeSearchViewModel = recipeSearchViewModel;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
    }

    // this method is called when recipe ideas have been found
    @Override
    public void prepareChooseRecipeView(RecipeSearchOutputData recipeSearchOutputData) {
        System.out.println("prepare choose recipe view for recipe search presenter");
        ChooseRecipeState chooseRecipeState = new ChooseRecipeState();
        chooseRecipeState.setRecipeIdeasList(recipeSearchOutputData.getRecipeIDList());
        this.chooseRecipeViewModel.setState(chooseRecipeState);
        chooseRecipeViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(chooseRecipeViewModel.getViewName());
        System.out.println("active view: "+ viewManagerModel.getActiveView());
        viewManagerModel.firePropertyChanged();

    }

    // this method is called when no recipe ideas have been found
    @Override
    public void prepareNoRecipeFoundView() {
        recipeSearchViewModel.firePropertyChanged();

    }
    // need this to return RecipeSearchOutputBoundry Type


}
