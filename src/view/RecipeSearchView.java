package view;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.food_joke.FoodJokeController;
import interface_adapter.food_joke.FoodJokeState;
import interface_adapter.food_joke.FoodJokeViewModel;
import interface_adapter.recipe_search.RecipeSearchController;
import interface_adapter.recipe_search.RecipeSearchState;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import use_case.recipe_search.Cuisine;

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

    private JTextField ingredientsInputField = new JTextField(30);

    private final JButton search;

    private final JButton joke;

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
    //private final JComboBox<Cuisine> cuisines;

    // drop down for protein
    private final JComboBox<String> protein;
    // drop down for fat
    private final JComboBox<String> fat;

    private final JComboBox<String> carbs;

    private final JComboBox<String> calories;

    public final RecipeSearchViewModel recipeSearchViewModel;

    public final RecipeSearchController recipeSearchController;

    private final FoodJokeViewModel foodJokeViewModel;
    public final FoodJokeController foodJokeController;

    public RecipeSearchView(RecipeSearchController controller, RecipeSearchViewModel recipeSearchViewModel, FoodJokeController foodJokeController, FoodJokeViewModel foodJokeViewModel){

        this.recipeSearchController = controller;
        this.recipeSearchViewModel = recipeSearchViewModel;
        recipeSearchViewModel.addPropertyChangeListener(this);

        this.foodJokeController = foodJokeController;
        this.foodJokeViewModel = foodJokeViewModel;
        foodJokeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(RecipeSearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton ingredientsSearchedFor = new JButton("Ingredients Stored");
        ingredientsSearchedFor.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        checkboxesAllergies.add(new JLabel("Intolerances:"));
        peanuts = new JCheckBox("peanuts");
        soy = new JCheckBox("soy");
        dairy = new JCheckBox("dairy");
        checkboxesAllergies.add(peanuts);
        checkboxesAllergies.add(soy);
        checkboxesAllergies.add(dairy);

        JPanel dropDownCuisines = new JPanel();
        dropDownCuisines.add(new JLabel("Cuisine:"));
        String[] cuisineStrings = {"no restriction", "Chinese", "Italien", "Indian", "Mexican", "African", "German"};
        //Cuisine[] cuisineStrings = {Cuisine.NORESTRICTION, Cuisine.ITALIEN};
        cuisines = new JComboBox<>(cuisineStrings);
        dropDownCuisines.add(cuisines);

        JPanel dropDownMacros = new JPanel();
        dropDownMacros.add(new JLabel("Macro nutrients:"));
        String[] proteinStrings = {"no protein restriction", "low protein", "high protein"}; // if these names are changed, the controller has to be adapted
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

        JPanel foodJoke = new JPanel();
        joke = new JButton("show me fun food trivia");
        foodJoke.add(joke);

        ingredientsInputField.setToolTipText("Type In Your Ingredients");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(ingredientsInfo);
        this.add(ingredientsSearchedFor);
        this.add(checkboxesDiet);
        this.add(checkboxesAllergies);
        this.add(dropDownCuisines);
        this.add(dropDownMacros);
        this.add(buttons);
        this.add(foodJoke);

        // action listener when search button gets pressed
        search.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if(evt.getSource().equals(search)){
                            RecipeSearchState currentState = recipeSearchViewModel.getState();

                            System.out.println("search button pressed");
                            // arguments have to be adapted based on attributed of RecipeSearchState
                            recipeSearchController.execute(currentState.getIngredients(), currentState.getDiets(), currentState.getIntolerances(), currentState.getCuisine(), currentState.getProtein(), currentState.getFat(), currentState.getCarbs(), currentState.getCalories());
                            //changed the type of getIngredients()
                        }
                    }
                }
        );

        // user types in ingredients

        ingredientsSearchedFor.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        RecipeSearchState state = recipeSearchViewModel.getState();
                        JOptionPane.showMessageDialog(RecipeSearchView.super.getComponent(0), state.getIngredients());
                    }
                }
        );

        ingredientsInputField.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        RecipeSearchState currentState = recipeSearchViewModel.getState();
                        String text = ingredientsInputField.getText();
                        currentState.addIngredients(text);//need to change set ingredients to add ingredients
                        ingredientsInputField.setText("");
                        recipeSearchViewModel.setState(currentState);
                        System.out.println(recipeSearchViewModel.getState().getIngredients()); // get rid
                    }
                }
        );
        // will get an error if you don't add an ingrediet

        glutenFree.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(glutenFree.isSelected()){
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setGlutenFree(true);
                            recipeSearchViewModel.setState(currentState);
                        } else{
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setGlutenFree(false);
                            recipeSearchViewModel.setState(currentState);
                        }
                    }
                }
        );

        vegetarian.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(vegetarian.isSelected()){
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setVegetarian(true);
                            recipeSearchViewModel.setState(currentState);
                        } else{
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setVegetarian(false);
                            recipeSearchViewModel.setState(currentState);
                        }
                    }
                }

        );

        vegan.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(vegan.isSelected()){
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setVegan(true);
                            recipeSearchViewModel.setState(currentState);
                        } else{
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setVegan(false);
                            recipeSearchViewModel.setState(currentState);
                        }
                    }
                }
        );

        paleo.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(paleo.isSelected()){
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setPaleo(true);
                            recipeSearchViewModel.setState(currentState);
                        } else{
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setPaleo(false);
                            recipeSearchViewModel.setState(currentState);
                        }
                    }
                }
        );

        keto.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(keto.isSelected()){
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setKeto(true);
                            recipeSearchViewModel.setState(currentState);
                        } else{
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setKeto(false);
                            recipeSearchViewModel.setState(currentState);
                        }
                    }
                }
        );

        peanuts.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(peanuts.isSelected()){
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setPeanutIntolerance(true);
                            recipeSearchViewModel.setState(currentState);
                        } else{
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setPeanutIntolerance(false);
                            recipeSearchViewModel.setState(currentState);
                        }
                    }
                }
        );

        dairy.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(dairy.isSelected()){
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setDairyIntolerance(true);
                            recipeSearchViewModel.setState(currentState);
                        } else{
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setDairyIntolerance(false);
                            recipeSearchViewModel.setState(currentState);
                        }
                    }
                }
        );

        soy.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(soy.isSelected()){
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setSoyIntolerance(true);
                            recipeSearchViewModel.setState(currentState);
                        } else{
                            RecipeSearchState currentState = recipeSearchViewModel.getState();
                            currentState.setSoyIntolerance(false);
                            recipeSearchViewModel.setState(currentState);
                        }
                    }
                }
        );

        cuisines.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedCuisine = cuisines.getSelectedItem().toString();
                        RecipeSearchState currentState = recipeSearchViewModel.getState();
                        currentState.setCuisine(selectedCuisine);
                        recipeSearchViewModel.setState(currentState);
                    }
                }
        );

        protein.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedProtein = protein.getSelectedItem().toString();
                        RecipeSearchState currentState = recipeSearchViewModel.getState();
                        currentState.setProtein(selectedProtein);
                        recipeSearchViewModel.setState(currentState);
                    }
                }
        );

        fat.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedFat = fat.getSelectedItem().toString();
                        RecipeSearchState currentState = recipeSearchViewModel.getState();
                        currentState.setFat(selectedFat);
                        recipeSearchViewModel.setState(currentState);
                    }
                }
        );

        carbs.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedCarb = carbs.getSelectedItem().toString();
                        RecipeSearchState currentState = recipeSearchViewModel.getState();
                        currentState.setCarbs(selectedCarb);
                        recipeSearchViewModel.setState(currentState);
                    }
                }
        );

        calories.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedCalories = calories.getSelectedItem().toString();
                        RecipeSearchState currentState = recipeSearchViewModel.getState();
                        currentState.setCalories(selectedCalories);
                        recipeSearchViewModel.setState(currentState);
                    }
                }
        );

        joke.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if(evt.getSource().equals(joke)){
                            foodJokeController.execute();
                        }

                    }
                }
        );



    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("property change food joke");
        FoodJokeState state = (FoodJokeState) evt.getNewValue();
        JOptionPane.showMessageDialog(this, state.getFoodJoke());

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
