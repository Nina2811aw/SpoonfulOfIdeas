package view;
import interface_adapter.recipe_search.RecipeSearchController;
import interface_adapter.recipe_search.RecipeSearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class RecipeSearchView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "Recipe View";

    public final RecipeSearchViewModel recipeSearchViewModel;

    public final RecipeSearchController recipeSearchController;

    public RecipeSearchView(RecipeSearchController controller, RecipeSearchViewModel recipeSearchViewModel){
        this.recipeSearchController = controller;
        this.recipeSearchViewModel = recipeSearchViewModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    // should include a textbox for ingredients
    // should include checkboxes for:
    /**
     * Diet:
     * Keto
     * Vegetarian
     * Gluten-Free
     * Vegan
     * Paleo
     *
     * Allergies
     * Peanuts
     * Dairy
     * Soy
     *
     * Cuisine
     * African
     * Chinese
     * German
     * Mexican
     * Indian
     * Italian
     *
     * Macronutrients
     *
     * High Protein
     * Low Fat
     * Low Carbs
     * High Carbs
     * Low Calorie
     * High Calorie
     */

}
