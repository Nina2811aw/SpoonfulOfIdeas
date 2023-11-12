package view;

import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.nutrition_detail.NutritionDetailState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChooseRecipeView extends JPanel implements ActionListener, PropertyChangeListener{

    public String viewName = "choose recipe";

    public final ChooseRecipeViewModel chooseRecipeViewModel;

    public final ChooseRecipeController chooseRecipeController;

    public JButton recipe1;
    public JButton recipe2;
    public JButton recipe3;
    public JButton recipe4;
    public JButton recipe5;

    public JPanel buttonsRecipes = new JPanel();

    public ChooseRecipeView(ChooseRecipeController chooseRecipeController, ChooseRecipeViewModel chooseRecipeViewModel){
        this.chooseRecipeController = chooseRecipeController;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        chooseRecipeViewModel.addPropertyChangeListener(this);

        ChooseRecipeState state = chooseRecipeViewModel.getState();
        JLabel title = new JLabel(ChooseRecipeViewModel.TITLE_BUTTON);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsRecipes = new JPanel();
        buttonsRecipes.setLayout(new BoxLayout(buttonsRecipes, BoxLayout.Y_AXIS));
        buttonsRecipes.add(new JLabel("Recipes:"));
        buttonsRecipes.setAlignmentX(Component.CENTER_ALIGNMENT);
        recipe1 = new JButton(state.getRecipeNames().get(0));
        recipe2 = new JButton(state.getRecipeNames().get(1));
        recipe3 = new JButton(state.getRecipeNames().get(2));
        recipe4 = new JButton(state.getRecipeNames().get(3));
        recipe5 = new JButton(state.getRecipeNames().get(4));
        buttonsRecipes.add(recipe1);
        buttonsRecipes.add(recipe2);
        buttonsRecipes.add(recipe3);
        buttonsRecipes.add(recipe4);
        buttonsRecipes.add(recipe5);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttonsRecipes);
    }

    public void change_view_name(String str){
        viewName = str;
    }
    public void change_buttons(String b1, String b2, String b3, String b4, String b5){
        buttonsRecipes.remove(recipe1);
        buttonsRecipes.remove(recipe2);
        buttonsRecipes.remove(recipe3);
        buttonsRecipes.remove(recipe4);
        buttonsRecipes.remove(recipe5);
        recipe1 = new JButton(b1);
        recipe2 = new JButton(b2);
        recipe3 = new JButton(b3);
        recipe4 = new JButton(b4);
        recipe5 = new JButton(b5);
        buttonsRecipes.add(recipe1);
        buttonsRecipes.add(recipe2);
        buttonsRecipes.add(recipe3);
        buttonsRecipes.add(recipe4);
        buttonsRecipes.add(recipe5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ChooseRecipeState chooseRecipeState = (ChooseRecipeState) evt.getNewValue();
        this.remove(buttonsRecipes);
        this.removeAll();
        JPanel buttonsRecipes2 = new JPanel();
        buttonsRecipes2.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonsRecipes2.setLayout(new BoxLayout(buttonsRecipes2, BoxLayout.Y_AXIS));
        recipe1 = new JButton(chooseRecipeState.getRecipeNames().get(1));
        recipe2 = new JButton(chooseRecipeState.getRecipeNames().get(2));
        recipe3 = new JButton(chooseRecipeState.getRecipeNames().get(3));
        recipe4 = new JButton(chooseRecipeState.getRecipeNames().get(4));
        recipe5 = new JButton(chooseRecipeState.getRecipeNames().get(5));
        buttonsRecipes2.add(recipe1);
        buttonsRecipes2.add(recipe2);
        buttonsRecipes2.add(recipe3);
        buttonsRecipes2.add(recipe4);
        buttonsRecipes2.add(recipe5);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttonsRecipes2);

    }

}
