package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import view.ChooseRecipeView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("A Spoonfull of Ideas");
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
        ChooseRecipeViewModel chooseRecipeViewModel = new ChooseRecipeViewModel();

        ChooseRecipeView chooseRecipeView = RecipeViewUseCaseFactory.create(viewManagerModel, chooseRecipeViewModel);
        views.add(chooseRecipeView, chooseRecipeView.viewName);


        viewManagerModel.setActiveView(chooseRecipeView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
