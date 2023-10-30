package view;

import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChooseRecipeView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "Choose Recipe View";

    public final ChooseRecipeViewModel chooseRecipeViewModel;

    public final ChooseRecipeController chooseRecipeController;

    public ChooseRecipeView(ChooseRecipeController chooseRecipeController, ChooseRecipeViewModel chooseRecipeViewModel){
        this.chooseRecipeController = chooseRecipeController;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
