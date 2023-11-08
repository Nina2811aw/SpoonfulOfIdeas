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

    public ChooseRecipeView(ChooseRecipeController chooseRecipeController, ChooseRecipeViewModel chooseRecipeViewModel){
        this.chooseRecipeController = chooseRecipeController;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        this.chooseRecipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Choose Recipe Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        select = new JButton(ChooseRecipeViewModel.SELECT_BUTTON);
        buttons.add(select);

        select.addActionListener(
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
        );


    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {


    }
}
