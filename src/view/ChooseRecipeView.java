package view;

import entity.RecipeInformation;
import interface_adapter.back_to_search.BackToSearchController;
import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.recipe_search.RecipeSearchState;

import javax.swing.*;
import javax.swing.text.html.HTML;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChooseRecipeView extends JPanel implements ActionListener, PropertyChangeListener{

    public String viewName = "choose recipe";

    public final ChooseRecipeViewModel chooseRecipeViewModel;

    public final ChooseRecipeController chooseRecipeController;

    public JButton button;

    // back button variables
    private final BackToSearchController backToSearchController;
    private JButton back;
    public JPanel buttonsRecipes = new JPanel();

    public ChooseRecipeView(ChooseRecipeController chooseRecipeController, BackToSearchController backController, ChooseRecipeViewModel chooseRecipeViewModel){
        this.chooseRecipeController = chooseRecipeController;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        chooseRecipeViewModel.addPropertyChangeListener(this);

        this.backToSearchController = backController;

        ChooseRecipeState state = chooseRecipeViewModel.getState();
        JLabel title = new JLabel(ChooseRecipeViewModel.TITLE_BUTTON);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsRecipes = new JPanel();
        buttonsRecipes.setLayout(new BoxLayout(buttonsRecipes, BoxLayout.Y_AXIS));
        buttonsRecipes.add(new JLabel("Recipes:"));
        buttonsRecipes.setAlignmentX(Component.CENTER_ALIGNMENT);

        back = new JButton("<--"); // Make the text input a variable input from ChooseViewModel rather than hard coded.
        buttonsRecipes.add(back);

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            backToSearchController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttonsRecipes);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    // Changed the property change to add the number of buttons passed with a max of 5 buttons,
    // also created a list that I iterate through and write a listener for each button

    // This method changes all the buttons based on the recipes passed in through the recipe search API call
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ChooseRecipeState chooseRecipeState = (ChooseRecipeState) evt.getNewValue();
        this.removeAll();

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel for the "Back" button aligned left
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        back = new JButton();
        Icon backIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/back_icon.png")));
        back.setIcon(backIcon);
        back.addActionListener(e -> {
            if (e.getSource() == back) {
                backToSearchController.execute();
            }
        });
        backPanel.add(back);

        // Panel for recipe buttons with vertical alignment
        JPanel recipePanel = new JPanel();
        recipePanel.setLayout(new BoxLayout(recipePanel, BoxLayout.Y_AXIS));
        recipePanel.add(new JLabel("Recipes:"));
        final int maxButtons = 5; // Maximum number of buttons

        // Create and add recipe buttons
        int counter = 0;
        for (String recipe : chooseRecipeState.getRecipeNames()) {
            if (counter >= maxButtons) {
                break;
            }
            JButton recipeButton = new JButton(recipe);
            int finalCounter = counter;
            recipeButton.addActionListener(e -> {
                ChooseRecipeState currentState = chooseRecipeViewModel.getState();
                System.out.println("Recipe button pressed");
                chooseRecipeController.execute(currentState.get_recipe_info().get(finalCounter));
            });
            recipePanel.add(recipeButton);
            counter++;
        }

        // Add the back panel to the top of the main panel
        mainPanel.add(backPanel, BorderLayout.NORTH);

        // Center the recipe panel
        JPanel centerWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerWrapper.add(recipePanel);
        mainPanel.add(centerWrapper, BorderLayout.CENTER);

        // Set the main panel as the layout for 'this'
        this.setLayout(new BorderLayout());
        this.add(mainPanel);

        // Refresh the container to reflect the changes
        this.revalidate();
        this.repaint();
    }

}
