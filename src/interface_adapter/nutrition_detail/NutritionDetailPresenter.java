package interface_adapter.nutrition_detail;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import use_case.nutrition_detail.NutritionDetailOutputBoundary;
import use_case.nutrition_detail.NutritionDetailOutputData;

public class NutritionDetailPresenter implements NutritionDetailOutputBoundary {
    public NutritionDetailPresenter(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel, NutritionDetailViewModel recipeDetailViewModel) {
    }

    @Override
    public void prepareShowNutritionDetailView(NutritionDetailOutputData nutritionDetailOutputData) {

    }
}
