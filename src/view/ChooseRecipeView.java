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
        this.remove(buttonsRecipes);
        this.removeAll();
        JPanel buttonsRecipes2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsRecipes2.add(new JLabel("Recipes:"));
        buttonsRecipes2.setLayout(new BoxLayout(buttonsRecipes2, BoxLayout.Y_AXIS));
        List<String> recipe_names = chooseRecipeState.getRecipeNames();
        List<JButton> button_list = new ArrayList<>();
        int counter = 0;
        for (String recipe: recipe_names){
            counter ++;
            button = new JButton(recipe);
            button_list.add(button);
            buttonsRecipes2.add(button);
            if (counter > 5){break;}
        }
        counter = 0;
        for (JButton button: button_list){
            int finalCounter = counter;
            button.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if(evt.getSource().equals(button)){
                                ChooseRecipeState currentState = chooseRecipeViewModel.getState();

                                System.out.println("recipe button pressed");
                                chooseRecipeController.execute(currentState.get_recipe_info().get(finalCounter));
                            }
                        }
                    }
            );
            counter ++; // counter must begin at 0 for .get(finalCounter) to be correct. Thus counter++ at end of loop.
        }

        back = new JButton("<--"); // Make the text input a variable input from ChooseViewModel rather than hard coded.
        buttonsRecipes2.add(back);

        buttonsRecipes2.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttonsRecipes2);

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


    }

}
