package interface_adapter.choose_recipe;

import interface_adapter.ViewManagerModel;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import use_case.choose_recipe.ChooseRecipeOutputBoundary;
import use_case.choose_recipe.ChooseRecipeOutputData;
import view.RecipeSearchView;

import java.util.List;


public class ChooseRecipePresenter implements ChooseRecipeOutputBoundary {
    private ViewManagerModel viewManagerModel;

    private ChooseRecipeViewModel chooseRecipeViewModel;

    private final NutritionDetailViewModel nutritionDetailViewModel;

    /**
     * Constructs a ChooseRecipePresenter with the given view models and view manager.
     *
     * @param viewManagerModel the model managing the active view
     * @param chooseRecipeViewModel the view model for choosing recipes
     * @param nutritionDetailViewModel the view model for nutrition details
     */
    public ChooseRecipePresenter(ViewManagerModel viewManagerModel,ChooseRecipeViewModel chooseRecipeViewModel, NutritionDetailViewModel nutritionDetailViewModel){
        this.nutritionDetailViewModel = nutritionDetailViewModel;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Updates view to RecipeDetailView showcasing the recipe the user clicked on.
     * @param chooseRecipeOutputData contains the recipe information like id and whether user favourited this recipe
     */
    @Override
    public void prepareRecipeDetailsSuccessView(ChooseRecipeOutputData chooseRecipeOutputData) {
        System.out.println("prepare Nutrition Details view for choose recipe presenter");
        NutritionDetailState nutritionDetailState = nutritionDetailViewModel.getState();
        List<String> recipe = chooseRecipeOutputData.getRecipeDetails();
        nutritionDetailState.setRecipe(recipe); // have to code in the choose recipe output data
        nutritionDetailState.setFavouritesFilled(chooseRecipeOutputData.getFavouriteFilled());
        this.nutritionDetailViewModel.setState(nutritionDetailState);
        nutritionDetailViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(nutritionDetailViewModel.getViewName());
        System.out.println("active view: "+ viewManagerModel.getActiveView());
        viewManagerModel.firePropertyChanged();
    }

}

