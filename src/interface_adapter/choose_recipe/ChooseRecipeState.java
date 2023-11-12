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

    public ChooseRecipeState() {
        recipeIdeasList = new ArrayList<>();
        recipeIdeasList.add(new RecipeInformation(1,"hello1"));
        recipeIdeasList.add(new RecipeInformation(2,"hello2"));
        recipeIdeasList.add(new RecipeInformation(3,"hello3"));
        recipeIdeasList.add(new RecipeInformation(4,"hello4"));
        recipeIdeasList.add(new RecipeInformation(5,"hello5"));

    }

    public ArrayList<JButton> get_buttons(){
        ArrayList<JButton> fin = new ArrayList<JButton>();
        button1 = new JButton(this.getRecipeNames().get(0));
        button2 = new JButton(this.getRecipeNames().get(1));
        button3 = new JButton(this.getRecipeNames().get(2));
        button4 = new JButton(this.getRecipeNames().get(3));
        button5 = new JButton(this.getRecipeNames().get(4));

        fin.add(button1);
        fin.add(button2);
        fin.add(button3);
        fin.add(button4);
        fin.add(button5);

        return fin;
    }

    public int get_length(){return recipeIdeasList.size();}

    public List<String> getRecipeNames() {
        List<String> recipeNames = new ArrayList<>();

        for (int i = 0; i < (recipeIdeasList).size(); i++){
            recipeNames.add(recipeIdeasList.get(i).getTitle());
            }

        return recipeNames;
    }

    public void setRecipeIdeasList(List<RecipeInformation> recipeIdeasList) {
        this.recipeIdeasList = recipeIdeasList;
    }




}
