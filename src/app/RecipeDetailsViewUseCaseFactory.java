package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_to_favourites.AddToFavouritesController;
import interface_adapter.add_to_favourites.AddToFavouritesPresenter;
import interface_adapter.back_to_choose.BackToChooseController;
import interface_adapter.back_to_choose.BackToChoosePresenter;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.extended_ingredients.ExtendedIngredientsController;
import interface_adapter.extended_ingredients.ExtendedIngredientsPresenter;
import interface_adapter.extended_ingredients.ExtendedIngredientsViewModel;
import interface_adapter.nutrition_detail.NutritionDetailController;
import interface_adapter.nutrition_detail.NutritionDetailPresenter;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import use_case.add_to_favourites.AddToFavouritesDataAccessInterface;
import use_case.add_to_favourites.AddToFavouritesInputBoundary;
import use_case.add_to_favourites.AddToFavouritesInteractor;
import use_case.add_to_favourites.AddToFavouritesOutputBoundary;
import use_case.back_to_choose.BackToChooseDataAccessInterface;
import use_case.back_to_choose.BackToChooseInputBoundary;
import use_case.back_to_choose.BackToChooseInteractor;
import use_case.back_to_choose.BackToChooseOutputBoundary;
import use_case.extended_ingredients.*;
import use_case.nutrition_detail.NutritionDetailDataAccessInterface;
import use_case.nutrition_detail.NutritionDetailInputBoundary;
import use_case.nutrition_detail.NutritionDetailInteractor;
import use_case.nutrition_detail.NutritionDetailOutputBoundary;
import view.RecipeDetailsView;

import java.io.IOException;

/**
 * Factory class for creating instances related to the Recipe Details View.
 * This class encapsulates the creation logic for the Recipe Details View
 * and its associated controllers and use cases.
 */
public class RecipeDetailsViewUseCaseFactory {

    /**
     * Creates and returns an instance of RecipeDetailsView.
     * This method sets up the necessary controllers and interactors
     * required for the RecipeDetailsView.
     *
     * @param viewManagerModel                 the view manager model
     * @param chooseRecipeViewModel            the choose recipe view model
     * @param recipeDetailViewModel            the recipe detail view model
     * @param nutritionDetailDataAccessObject  the data access object for nutrition details
     * @param backToChooseDataAccessObject     the data access object for navigating back to choose
     * @param addToFavouritesDataAccessObject  the data access object for adding to favorites
     * @return an instance of RecipeDetailsView
     * @throws IOException if an I/O error occurs
     */
    public static RecipeDetailsView createRecipeDetailsView(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel,
                                                            NutritionDetailViewModel nutritionDetailViewModel, ExtendedIngredientsViewModel extendedIngredientsViewModel,
                                                            NutritionDetailDataAccessInterface nutritionDetailDataAccessObject, ExtendedIngredientsDataAccessInterface extendedIngredientsDataAccessInterface,
                                                            BackToChooseDataAccessInterface backToChooseDataAccessObject, AddToFavouritesDataAccessInterface addToFavouritesDataAccessObject) throws IOException {


        NutritionDetailController nutritionDetailController = createRecipeDetailsCase(viewManagerModel, chooseRecipeViewModel, nutritionDetailViewModel, nutritionDetailDataAccessObject);

        ExtendedIngredientsController extendedIngredientsController = createExtendedIngredientsCase(viewManagerModel, chooseRecipeViewModel, extendedIngredientsViewModel, extendedIngredientsDataAccessInterface);

        BackToChooseController backToChooseController = createBackToChooseCase(viewManagerModel, chooseRecipeViewModel, backToChooseDataAccessObject);
        AddToFavouritesController addToFavouritesController = createAddToFavouritesCase(viewManagerModel, nutritionDetailViewModel, addToFavouritesDataAccessObject);

        return new RecipeDetailsView(nutritionDetailController, nutritionDetailViewModel, extendedIngredientsController, extendedIngredientsViewModel, backToChooseController, addToFavouritesController);
    }
    /**
     * Creates and returns a NutritionDetailController.
     *
     * @param viewManagerModel the view manager model
     * @param chooseRecipeViewModel the choose recipe view model
     * @param recipeDetailViewModel the recipe detail view model
     * @param recipeDetailDataAccessObject the data access object for recipe details
     * @return an instance of NutritionDetailController
     */
    private static NutritionDetailController createRecipeDetailsCase(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel, NutritionDetailViewModel recipeDetailViewModel, NutritionDetailDataAccessInterface recipeDetailDataAccessObject) {
        NutritionDetailOutputBoundary nutritionDetailOutputBoundary = new NutritionDetailPresenter(viewManagerModel, chooseRecipeViewModel, recipeDetailViewModel);
        NutritionDetailInputBoundary nutritionDetailInteractor = new NutritionDetailInteractor(recipeDetailDataAccessObject, nutritionDetailOutputBoundary);
        return new NutritionDetailController(nutritionDetailInteractor);
    }

    private static ExtendedIngredientsController createExtendedIngredientsCase(ViewManagerModel viewManagerModel, ChooseRecipeViewModel chooseRecipeViewModel, ExtendedIngredientsViewModel extendedIngredientsViewModel, ExtendedIngredientsDataAccessInterface extendedIngredientsDataAccessInterface) {
        ExtendedIngredientsOutputBoundary extendedIngredientsOutputBoundary = new ExtendedIngredientsPresenter(viewManagerModel, chooseRecipeViewModel, extendedIngredientsViewModel);
        ExtendedIngredientsInputBoundary extendedIngredientsInteractor = new ExtendedIngredientsInteractor(extendedIngredientsDataAccessInterface, extendedIngredientsOutputBoundary);
        return new ExtendedIngredientsController(extendedIngredientsInteractor);
    }

    /**
     * Creates and returns a BackToChooseController.
     *
     * @param viewManagerModel the view manager model
     * @param chooseRecipeViewModel the choose recipe view model
     * @param recipeDataAccessObject the data access object for recipe data
     * @return an instance of BackToChooseController
     * @throws IOException if an I/O error occurs
     */
    private static BackToChooseController createBackToChooseCase(ViewManagerModel viewManagerModel,
                                                                 ChooseRecipeViewModel chooseRecipeViewModel, BackToChooseDataAccessInterface recipeDataAccessObject) throws IOException {
        BackToChooseOutputBoundary backToChooseOutputBoundary = new BackToChoosePresenter(chooseRecipeViewModel, viewManagerModel);
        BackToChooseInputBoundary backToChooseInteractor = new BackToChooseInteractor(recipeDataAccessObject, backToChooseOutputBoundary);

        return new BackToChooseController(backToChooseInteractor);
    }

    /**
     * Creates and returns an AddToFavouritesController.
     *
     * @param viewManagerModel the view manager model
     * @param nutritionDetailViewModel the nutrition detail view model
     * @param addToFavouritesDataAccessObject the data access object for adding to favourites
     * @return an instance of AddToFavouritesController
     * @throws IOException if an I/O error occurs
     */
    private static AddToFavouritesController createAddToFavouritesCase(ViewManagerModel viewManagerModel, NutritionDetailViewModel nutritionDetailViewModel, AddToFavouritesDataAccessInterface addToFavouritesDataAccessObject) throws IOException{
        AddToFavouritesOutputBoundary addToFavouritesOutputBoundary = new AddToFavouritesPresenter(viewManagerModel, nutritionDetailViewModel);
        AddToFavouritesInputBoundary addToFavouritesInteractor = new AddToFavouritesInteractor(addToFavouritesDataAccessObject, addToFavouritesOutputBoundary);

        return new AddToFavouritesController(addToFavouritesInteractor);
    }
}
