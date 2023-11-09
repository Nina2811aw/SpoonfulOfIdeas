package view;

import entity.RecipeInformation;
import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.List;


public class ChooseRecipeView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "choose recipe";

    public final ChooseRecipeViewModel chooseRecipeViewModel;

    public final ChooseRecipeController chooseRecipeController;

    final JButton select;
    final JButton recipe1;

    final JButton recipe2;

    final JButton recipe3;

    final JButton recipe4;

    final JButton recipe5;


    public ChooseRecipeView(ChooseRecipeController chooseRecipeController, ChooseRecipeViewModel chooseRecipeViewModel){
        this.chooseRecipeController = chooseRecipeController;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        this.chooseRecipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Choose Recipe Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        select = new JButton(ChooseRecipeViewModel.SELECT_BUTTON);
        buttons.add(select);
        recipe1 = new JButton("Recipe 1"); //change the titles of these buttons according to the recipes given by recipe search later
        buttons.add(recipe1);
        recipe2 = new JButton("Recipe 2");
        buttons.add(recipe2);
        recipe3 = new JButton("Recipe 3");
        buttons.add(recipe3);
        recipe4 = new JButton("Recipe 4");
        buttons.add(recipe4);
        recipe5 = new JButton("Recipe 5");
        buttons.add(recipe5);

        this.add(buttons);

        /*select.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource().equals(select)){
                            ChooseRecipeState currentState = chooseRecipeViewModel.getState();
                            List<RecipeInformation> recipeInfo = currentState.getRecipeIdeasList();
                            chooseRecipeController.execute(recipeInfo);
                        }
                    }
                }
        );*/


    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {


    }
}
