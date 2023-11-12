package app;

import data_access.SpoonacularDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.back_to_choose.BackToChooseViewModel;
import interface_adapter.choose_recipe.ChooseRecipePresenter;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import view.ChooseRecipeView;
import view.RecipeDetailsView;
import view.RecipeSearchView;
import view.ViewManager;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("A Spoonful of Ideas");
        application.setSize(1000, 1000);
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        RecipeSearchViewModel recipeSearchViewModel = new RecipeSearchViewModel();
        ChooseRecipeViewModel chooseRecipeViewModel = new ChooseRecipeViewModel();
        NutritionDetailViewModel nutritionDetailViewModel = new NutritionDetailViewModel();
        SpoonacularDataAccessObject nutritionDetailDataAccessObject;
        nutritionDetailDataAccessObject = new SpoonacularDataAccessObject();
        SpoonacularDataAccessObject backToChooseDataAccessObject;
        backToChooseDataAccessObject = new SpoonacularDataAccessObject();

        RecipeSearchView recipeSearchView = RecipeViewUseCaseFactory.createSearchView(viewManagerModel, recipeSearchViewModel, chooseRecipeViewModel);
        views.add(recipeSearchView, recipeSearchView.viewName);

        ChooseRecipeView chooseRecipeView = RecipeViewUseCaseFactory.createChooseView(viewManagerModel, chooseRecipeViewModel);
        views.add(chooseRecipeView, chooseRecipeView.viewName);

        RecipeDetailsView recipeDetailsView = RecipeDetailsViewUseCaseFactory.createRecipeDetailsView(viewManagerModel, chooseRecipeViewModel, nutritionDetailViewModel, nutritionDetailDataAccessObject, backToChooseDataAccessObject);

        viewManagerModel.setActiveView(recipeSearchView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
