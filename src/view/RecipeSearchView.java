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

    private final JTextField ingredientsInputField = new JTextField(30);

    private final JButton search;

    // checkboxes for diets
    private final JCheckBox vegan;
    private final JCheckBox vegetarian;
    private final JCheckBox keto;
    private final JCheckBox glutenFree;
    private final JCheckBox paleo;

    // checkboxes for allergies
    private final JCheckBox peanuts;
    private final JCheckBox dairy;
    private final JCheckBox soy;

    // drop down for cuisines
    private final JComboBox<String> cuisines;

    // drop down for protein
    private final JComboBox<String> protein;
    // drop down for fat
    private final JComboBox<String> fat;

    private final JComboBox<String> carbs;

    private final JComboBox<String> calories;


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

        JPanel checkboxesDiet = new JPanel();
        checkboxesDiet.add(new JLabel("Diets:"));
        glutenFree = new JCheckBox("gluten-free");
        vegetarian = new JCheckBox("vegetarian");
        vegan = new JCheckBox("vegan");
        keto = new JCheckBox("keto");
        paleo = new JCheckBox("paleo");
        checkboxesDiet.add(glutenFree);
        checkboxesDiet.add(vegetarian);
        checkboxesDiet.add(vegan);
        checkboxesDiet.add(keto);
        checkboxesDiet.add(paleo);

        JPanel checkboxesAllergies = new JPanel();
        checkboxesAllergies.add(new JLabel("Allergies:"));
        peanuts = new JCheckBox("peanuts");
        soy = new JCheckBox("soy");
        dairy = new JCheckBox("dairy");
        checkboxesAllergies.add(peanuts);
        checkboxesAllergies.add(soy);
        checkboxesAllergies.add(dairy);

        JPanel dropDownCuisines = new JPanel();
        dropDownCuisines.add(new JLabel("Cuisine:"));
        String[] cuisineStrings = {"no restriction", "Chinese", "Italien", "Indian", "Mexican", "German"};
        cuisines = new JComboBox<>(cuisineStrings);
        dropDownCuisines.add(cuisines);

        JPanel dropDownMacros = new JPanel();
        dropDownMacros.add(new JLabel("Macro nutrients:"));
        String[] proteinStrings = {"no protein restriction", "low protein", "highProtein"};
        protein = new JComboBox<>(proteinStrings);

        String[] fatStrings = {"no fat restriction", "low fat", "high fat"};
        fat = new JComboBox<>(fatStrings);

        String[] carbsStrings = {"no carbs restriction", "low carbs", "high carbs"};
        carbs = new JComboBox<>(carbsStrings);

        String[] caloriesStrings = {"no calorie restrictions", "low calorie", "high calorie"};
        calories = new JComboBox<>(caloriesStrings);

        dropDownMacros.add(protein);
        dropDownMacros.add(fat);
        dropDownMacros.add(carbs);
        dropDownMacros.add(calories);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(ingredientsInfo);
        this.add(checkboxesDiet);
        this.add(checkboxesAllergies);
        this.add(dropDownCuisines);
        this.add(dropDownMacros);
        this.add(buttons);

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
    /*
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
