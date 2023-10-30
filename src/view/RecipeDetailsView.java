package view;

import interface_adapter.recipe_search.RecipeSearchController;

import javax.swing.*;
import java.awt.*;


public class RecipeDetailsView {

    private final RecipeDetailsController recipeDetailsController;

    private final RecipeDetailsViewModel recipeViewModel;
    final JButton back;
    public RecipeDetailsView(RecipeDetailsViewModel recipeDetailsViewModel, RecipeDetailsController controller) {

        this.recipeDetailsController = controller;
        this.recipeViewModel = recipeDetailsViewModel;
        this.recipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Recipe Details View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel buttons = new JPanel();
        back = new JButton(recipeViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);
}}
