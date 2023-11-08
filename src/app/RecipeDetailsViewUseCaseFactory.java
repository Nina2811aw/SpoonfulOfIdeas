package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.back_to_choose.BackToChooseController;
import interface_adapter.back_to_choose.BackToChoosePresenter;
import interface_adapter.back_to_choose.BackToChooseViewModel;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.nutrition_detail.NutritionDetailController;
import interface_adapter.nutrition_detail.NutritionDetailPresenter;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import use_case.back_to_choose.BackToChooseDataAccessInterface;
import use_case.back_to_choose.BackToChooseInputBoundary;
import use_case.back_to_choose.BackToChooseInteractor;
import use_case.back_to_choose.BackToChooseOutputBoundary;
import use_case.nutrition_detail.NutritionDetailDataAccessInterface;
import use_case.nutrition_detail.NutritionDetailInputBoundary;
import use_case.nutrition_detail.NutritionDetailInteractor;
import use_case.nutrition_detail.NutritionDetailOutputBoundary;
import view.RecipeDetailsView;

import java.io.IOException;

public class RecipeDetailsViewUseCaseFactory {

    public static RecipeDetailsView createRecipeDetailsView(ViewManagerModel viewManagerModel, BackToChooseViewModel backToChooseViewModel, ChooseRecipeViewModel chooseRecipeViewModel,
                                                            NutritionDetailViewModel recipeDetailViewModel, NutritionDetailDataAccessInterface nutritionDetailDataAccessObject, BackToChooseDataAccessInterface backToChooseDataAccessObject) throws IOException {
        NutritionDetailController nutritionDetailController = createRecipeDetailsCase(viewManagerModel, chooseRecipeViewModel, recipeDetailViewModel, nutritionDetailDataAccessObject);
        BackToChooseController backToChooseController = createBackToChooseCase(viewManagerModel, backToChooseViewModel, chooseRecipeViewModel, backToChooseDataAccessObject);

        return null;
    }

    private static NutritionDetailController createRecipeDetailsCase(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel, NutritionDetailViewModel recipeDetailViewModel, NutritionDetailDataAccessInterface recipeDetailDataAccessObject) {
        NutritionDetailOutputBoundary nutritionDetailOutputBoundary = new NutritionDetailPresenter(viewManagerModel, chooseRecipeViewModel, recipeDetailViewModel);

        NutritionDetailInputBoundary nutritionDetailInteractor = new NutritionDetailInteractor(recipeDetailDataAccessObject, nutritionDetailOutputBoundary);
        return new NutritionDetailController(nutritionDetailInteractor);

    }
    private static BackToChooseController createBackToChooseCase(ViewManagerModel viewManagerModel, BackToChooseViewModel backToChooseViewModel,
                                                                 ChooseRecipeViewModel chooseRecipeViewModel, BackToChooseDataAccessInterface recipeDataAccessObject) throws IOException {
        BackToChooseOutputBoundary backToChooseOutputBoundary = new BackToChoosePresenter(chooseRecipeViewModel, viewManagerModel, backToChooseViewModel);
        BackToChooseInputBoundary backToChooseInteractor = new BackToChooseInteractor(recipeDataAccessObject, backToChooseOutputBoundary);

        return new BackToChooseController(backToChooseInteractor);


    }

}
