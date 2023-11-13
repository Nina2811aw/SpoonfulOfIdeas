package view;

import entity.RecipeInformation;
import interface_adapter.back_to_search.BackToSearchController;
import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.recipe_search.RecipeSearchState;

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

    // back button variables
    private final BackToSearchController backToSearchController;
    private final JButton back;
    public JPanel buttonsRecipes = new JPanel();

    public ChooseRecipeView(ChooseRecipeController chooseRecipeController, BackToSearchController backController, ChooseRecipeViewModel chooseRecipeViewModel){
        this.chooseRecipeController = chooseRecipeController;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
        chooseRecipeViewModel.addPropertyChangeListener(this);

        this.backToSearchController = backController;

        ChooseRecipeState chooseRecipeState = chooseRecipeViewModel.getState();
        JLabel title = new JLabel("Choose Recipe Screen");
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
        ChooseRecipeState chooseRecipeState = (ChooseRecipeState) evt.getNewValue();
        this.remove(buttonsRecipes);
        this.removeAll();
        JPanel buttonsRecipes2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsRecipes2.add(new JLabel("Recipes:"));
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
        buttonsRecipes2.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttonsRecipes2);

        recipe1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if(evt.getSource().equals(recipe1)){
                            ChooseRecipeState currentState = chooseRecipeViewModel.getState();

                            System.out.println("recipe 1 button pressed");
                            chooseRecipeController.execute(currentState.get_recipe_info().get(1));
                        }
                    }
                }
        );

        recipe2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if(evt.getSource().equals(recipe2)){
                            ChooseRecipeState currentState = chooseRecipeViewModel.getState();

                            System.out.println("recipe 2 button pressed");
                            chooseRecipeController.execute(currentState.get_recipe_info().get(2));
                        }
                    }
                }
        );

        recipe3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if(evt.getSource().equals(recipe3)){
                            ChooseRecipeState currentState = chooseRecipeViewModel.getState();

                            System.out.println("recipe 3 button pressed");
                            chooseRecipeController.execute(currentState.get_recipe_info().get(3));
                        }
                    }
                }
        );

        recipe4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if(evt.getSource().equals(recipe4)){
                            ChooseRecipeState currentState = chooseRecipeViewModel.getState();

                            System.out.println("recipe 4 button pressed");
                            chooseRecipeController.execute(currentState.get_recipe_info().get(4));
                        }
                    }
                }
        );

        recipe5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if(evt.getSource().equals(recipe5)){
                            ChooseRecipeState currentState = chooseRecipeViewModel.getState();

                            System.out.println("recipe 5 button pressed");
                            chooseRecipeController.execute(currentState.get_recipe_info().get(5));
                        }
                    }
                }
        );
    }

}
