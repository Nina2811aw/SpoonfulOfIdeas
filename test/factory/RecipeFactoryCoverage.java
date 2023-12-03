package factory;

import app.MainApp;
import app.RecipeDetailsViewUseCaseFactory;
import app.RecipeViewUseCaseFactory;
import data_access.FavouritesDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_to_favourites.AddToFavouritesController;
import interface_adapter.back_to_choose.BackToChooseController;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.food_joke.FoodJokeViewModel;
import interface_adapter.nutrition_detail.NutritionDetailController;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import use_case.add_to_favourites.AddToFavouritesDataAccessInterface;
import use_case.back_to_choose.BackToChooseDataAccessInterface;
import use_case.nutrition_detail.NutritionDetailDataAccessInterface;
import view.ChooseRecipeView;
import view.RecipeDetailsView;
import view.RecipeSearchView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RecipeFactoryCoverage {

    @Mock
    private ViewManagerModel viewManagerModel;
    @Mock
    private ChooseRecipeViewModel chooseRecipeViewModel;
    @Mock
    private NutritionDetailViewModel nutritionDetailViewModel;
    @Mock
    private NutritionDetailDataAccessInterface nutritionDetailDataAccess;
    @Mock
    private BackToChooseDataAccessInterface backToChooseDataAccess;
    @Mock
    private AddToFavouritesDataAccessInterface addToFavouritesDataAccess;
    @Mock
    private RecipeSearchViewModel recipeSearchViewModel;
    @Mock
    private FoodJokeViewModel foodJokeViewModel;
    @Mock
    private FavouritesDataAccessObject favouritesDataAccessObject;
    @Mock
    private MainApp main;




        // Additional assertions can be made to verify the correct setup of RecipeDetailsView
    @Test
    public void testCreateRecipeDetailsView() throws IOException {
        // Factory method call
        RecipeDetailsView result = RecipeDetailsViewUseCaseFactory.createRecipeDetailsView(
                viewManagerModel, chooseRecipeViewModel, nutritionDetailViewModel,
                nutritionDetailDataAccess, backToChooseDataAccess, addToFavouritesDataAccess);

        // Assertions
        assertNotNull(result);
    }

    @Test
    public void testCreateRecipeView() throws IOException {
        // Factory method call
        RecipeSearchView resultRecipeView = RecipeViewUseCaseFactory.createSearchView(viewManagerModel, recipeSearchViewModel,
                chooseRecipeViewModel, foodJokeViewModel, favouritesDataAccessObject);
        ChooseRecipeView resultChooseView = RecipeViewUseCaseFactory.createChooseView(viewManagerModel, recipeSearchViewModel,
                chooseRecipeViewModel, nutritionDetailViewModel, favouritesDataAccessObject);
        // Assertions
        assertNotNull(resultRecipeView);
        assertNotNull(resultChooseView);
    }

    @Test
    void testMain() {
        // Redirect System.out to prevent console output during the test
        System.setOut(new java.io.PrintStream(new java.io.OutputStream() {
            @Override
            public void write(int b) {
                // Do nothing
            }
        }));

        // Call main method
        try {
            MainApp.main(new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Restore System.out
        System.setOut(System.out);
    }
}
