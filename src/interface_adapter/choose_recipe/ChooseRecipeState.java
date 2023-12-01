package interface_adapter.choose_recipe;

import entity.RecipeInformation;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ChooseRecipeState {
    private List<RecipeInformation> recipeIdeasList;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    /**
     * Constructs a new ChooseRecipeState with default recipe information (recipeId, recipeName).
     */
    public ChooseRecipeState() {
        recipeIdeasList = new ArrayList<>();
        recipeIdeasList.add(new RecipeInformation(1,"hello1"));
        recipeIdeasList.add(new RecipeInformation(2,"hello2"));
        recipeIdeasList.add(new RecipeInformation(3,"hello3"));
        recipeIdeasList.add(new RecipeInformation(4,"hello4"));
        recipeIdeasList.add(new RecipeInformation(5,"hello5"));
    }

    /**
     * Getter which returns the list of recipe information.
     * @return the list of RecipeInformation objects
     */
    public List<RecipeInformation> get_recipe_info(){return recipeIdeasList;}

    /**
     * Getter which returns a new array containing just the names of all recipes in the recipe ideas list.
     * @return a list of recipe names
     */
    public List<String> getRecipeNames() {
        List<String> recipeNames = new ArrayList<>();

        for (int i = 0; i < (recipeIdeasList).size(); i++){
            recipeNames.add(recipeIdeasList.get(i).getTitle());
            }

        return recipeNames;
    }

    /**
     * Setter which sets the list of recipe ideas.
     * @param recipeIdeasList the new list of RecipeInformation objects to update state with
     */
    public void setRecipeIdeasList(List<RecipeInformation> recipeIdeasList) {
        this.recipeIdeasList = recipeIdeasList;
    }
}
