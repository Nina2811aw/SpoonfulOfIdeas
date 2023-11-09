package view;

import entity.RecipeInformation;
import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import use_case.choose_recipe.ChooseRecipeInputData;

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

    private JButton recipe1;
    private JButton recipe2;
    private JButton recipe3;
    private JButton recipe4;
    private JButton recipe5;

    public ChooseRecipeView(ChooseRecipeController chooseRecipeController, ChooseRecipeViewModel chooseRecipeViewModel){
        this.chooseRecipeController = chooseRecipeController;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        this.chooseRecipeViewModel.addPropertyChangeListener(this);

        ChooseRecipeState chooseRecipeState = chooseRecipeViewModel.getState();
        JLabel title = new JLabel(ChooseRecipeViewModel.TITLE_BUTTON);
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
