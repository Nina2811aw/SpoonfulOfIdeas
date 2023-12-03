package interface_adapter.extended_ingredients;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import use_case.extended_ingredients.ExtendedIngredientsOutputBoundary;
import use_case.extended_ingredients.ExtendedIngredientsOutputData;

public class ExtendedIngredientsPresenter implements ExtendedIngredientsOutputBoundary {
    private final ExtendedIngredientsViewModel extendedIngredientsViewModel;
    private ViewManagerModel viewManagerModel;
    private ChooseRecipeViewModel chooseRecipeViewModel;
    public ExtendedIngredientsPresenter(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel, ExtendedIngredientsViewModel extendedIngredientsViewModel) {
        this.extendedIngredientsViewModel = extendedIngredientsViewModel;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        this.viewManagerModel = viewManagerModel;

    }

    @Override
    public void prepareShowExtendedIngredientsView(ExtendedIngredientsOutputData extendedIngredientsOutputData) {
        System.out.println("nutrition detail presenter");
        viewManagerModel.setActiveView(extendedIngredientsViewModel.getViewName());
        System.out.println("active view: "+ viewManagerModel.getActiveView());
        viewManagerModel.firePropertyChanged();

    }
}
