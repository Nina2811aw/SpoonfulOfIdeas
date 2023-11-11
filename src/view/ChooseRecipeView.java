package view;

import entity.RecipeInformation;
import interface_adapter.back_to_search.BackToSearchController;
import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ChooseRecipeView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "choose recipe";

    public final ChooseRecipeViewModel chooseRecipeViewModel;

    public final ChooseRecipeController chooseRecipeController;

    final JButton recipe1;
    final JButton recipe2;
    final JButton recipe3;
    final JButton recipe4;
    final JButton recipe5;

    // back button variables
    private final BackToSearchController backToSearchController;
    private final JButton back;

    public ChooseRecipeView(ChooseRecipeController chooseRecipeController, BackToSearchController backController, ChooseRecipeViewModel chooseRecipeViewModel){
        this.chooseRecipeController = chooseRecipeController;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        this.chooseRecipeViewModel.addPropertyChangeListener(this);

        this.backToSearchController = backController;

        ChooseRecipeState chooseRecipeState = chooseRecipeViewModel.getState();
        JLabel title = new JLabel("Choose Recipe Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsRecipes = new JPanel();
        buttonsRecipes.setLayout(new BoxLayout(buttonsRecipes, BoxLayout.Y_AXIS));
        buttonsRecipes.add(new JLabel("Recipes:"));
        buttonsRecipes.setAlignmentX(Component.CENTER_ALIGNMENT);
        recipe1 = new JButton(String.valueOf(chooseRecipeState.getRecipeNames().get(0)));
        recipe2 = new JButton("");
        recipe3 = new JButton("");
        recipe4 = new JButton("");
        recipe5 = new JButton("");
        buttonsRecipes.add(recipe1);
        buttonsRecipes.add(recipe2);
        buttonsRecipes.add(recipe3);
        buttonsRecipes.add(recipe4);
        buttonsRecipes.add(recipe5);

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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {


    }
}
