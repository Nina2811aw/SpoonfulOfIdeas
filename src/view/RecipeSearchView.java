package view;
import interface_adapter.recipe_search.RecipeSearchController;
import interface_adapter.recipe_search.RecipeSearchState;
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

    public final String viewName = "Recipe Search View";

    private final JTextField ingredientsInputField = new JTextField(15);

    private final JButton search;
    public final RecipeSearchViewModel recipeSearchViewModel;

    public final RecipeSearchController recipeSearchController;

    public RecipeSearchView(RecipeSearchController controller, RecipeSearchViewModel recipeSearchViewModel){

        this.recipeSearchController = controller;
        this.recipeSearchViewModel = recipeSearchViewModel;
        recipeSearchViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(RecipeSearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel ingredientsInfo = new LabelTextPanel(new JLabel(RecipeSearchViewModel.INGREDIENTS_LABEL), ingredientsInputField);

        JPanel buttons = new JPanel();
        search = new JButton(RecipeSearchViewModel.SEARCH_BUTTON);
        buttons.add(search);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
        this.add(ingredientsInfo);

        // action listener when search button gets pressed
        search.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if(evt.getSource().equals(search)){
                            RecipeSearchState currentState = recipeSearchViewModel.getState();

                            // arguments have to be adapted based on attributed of RecipeSearchState
                            recipeSearchController.execute();
                        }
                    }
                }
        );

        // user types in ingredients
        ingredientsInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        RecipeSearchState currentState = recipeSearchViewModel.getState();
                        String text = ingredientsInputField.getText() + e.getKeyChar();
                        currentState.setIngredients(text);
                        recipeSearchViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

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
     * use_case.recipe_search.Diet:
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
     * use_case.recipe_search.Cuisine
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
