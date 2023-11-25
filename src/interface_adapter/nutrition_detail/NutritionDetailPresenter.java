package interface_adapter.nutrition_detail;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import use_case.nutrition_detail.NutritionDetailOutputBoundary;
import use_case.nutrition_detail.NutritionDetailOutputData;

public class NutritionDetailPresenter implements NutritionDetailOutputBoundary {
    private final NutritionDetailViewModel nutritionDetailViewModel;
    private ViewManagerModel viewManagerModel;
    private ChooseRecipeViewModel chooseRecipeViewModel;
    public NutritionDetailPresenter(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel, NutritionDetailViewModel nutritionDetailViewModel) {
        this.nutritionDetailViewModel = nutritionDetailViewModel;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        this.viewManagerModel = viewManagerModel;

    }

    @Override
    public void prepareShowNutritionDetailView(NutritionDetailOutputData nutritionDetailOutputData) {
        System.out.println("nutrition detail presenter");
        viewManagerModel.setActiveView(nutritionDetailViewModel.getViewName());
        System.out.println("active view: "+ viewManagerModel.getActiveView());
        viewManagerModel.firePropertyChanged();

    }
}
